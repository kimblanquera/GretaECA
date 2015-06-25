import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import Bean.*;
import Impl.*;
import Interface.*;

public class Driver {

	// MAIN CONTROL
	public static void main(String args[]){

		// START CONFIGURATION

		GregorianCalendar today = new GregorianCalendar();
		int t = today.get(Calendar.AM_PM);

		ArrayList<Speech> list = new ArrayList<Speech>();
		SpeechInterface speechInt = new SpeechImplementation();
		AnswerInterface ansInt = new AnswerImplementation();
		boolean cancel = false, eng = false, next = false;
		int start = 0, x = 0;
		Speech q = new Speech();
		String disp = "", lang = "";

		// SET UP BODY PART LIST - TESTED: SUCCESSFULL
		ArrayList<BodyPart> engList = new ArrayList<BodyPart>();
		ArrayList<BodyPart> filList = new ArrayList<BodyPart>();
		ArrayList<String> tokens = new ArrayList<String>();
		String engFile = "../Reference Files/Body Parts - English.csv";
		String filFile = "../Reference Files/Body Parts - Filipino.csv";
		String endStr = "";
		
		engList = initPartList(engFile);
		filList = initPartList(filFile);
		
		//-----------------------------------------------------------------------
		
		// SET UP SELECTION

		JFrame frame = new JFrame();

		String s = "Select Language";

		Object[] langOptions = {

			"English",
			"Filipino"

		};

		int choice = JOptionPane.showOptionDialog(frame, s, "Language Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, langOptions, langOptions[1]);

		if (choice == 0) {

			eng = true;
			lang = "eng";
			s = "Language: English\n\nBegin consultation?";
			start = JOptionPane.showConfirmDialog(frame, s);
			endStr = "Consultation has ended. Thank you.";

		}
		else if(choice == 1) {

			endStr = "Tapos na ang konsultasyon. Maraming salamat.";
			eng = false;
			lang = "fil";
			s = "Lengwahe: Tagalog\n\nSimulan ang konsultasyon?";
			Object[] ops = {

				"Oo",
				"Hindi"

			};
			start = JOptionPane.showOptionDialog(frame, s, "Simula", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ops, ops[1]);

		}

		if(start == JOptionPane.YES_OPTION) {
		
			Answer ans = new Answer();
			String question = "", bpFile = "", optionsFile = "", optionList = "", answer, yesStr, noStr, cancelStr;
			Speech Q = new Speech();
			int step = 1, c;
			XMLinfo xml = new XMLinfo();
			xml.setCurrType(-1);
			int type = 0;
			ArrayList<String> questionTokens = new ArrayList<String>();

			do {

				// GET LIST OF QUESTIONS
				list = speechInt.getQuestionByStep(step);
				next = false; // if true, then go to next block
				
				// ASK EACH QUESTION
				for (c = 0; c < list.size() && !next && !cancel; c++) {

					Q = list.get(c);
					System.out.println(Q.getEngText());
					type = speechInt.getType(Q.getTextTypeID(), Q.getIntentTypeID());

					// ADD PARSER AND BODY PART CHECKER
					xml = speechInt.getXML(type, lang, xml.getCurrType());
					String xmlFile = xml.getFileName();

					if(eng) {
						
						yesStr = Q.getEngYes();
						noStr = Q.getEngNo();
						cancelStr = "Cancel";
						optionList = " Your options are " + Q.getEngYes() + ", " + Q.getEngNo() + ", Not Applicable and Cancel";
						optionsFile = "bml/eng/readOptions.xml";
						question = Q.getEngText();
						questionTokens = parseQuestion(question);
						bpFile = searchPart(questionTokens, engList);
						

					}
					else {
						
						yesStr = Q.getEngYes();
						noStr = Q.getEngNo();
						cancelStr = "Ikansela";
						optionList = " Ang inyong mga opsyon ay " + Q.getFilYes() + ", " + Q.getFilNo() + " at Ikansela";
						optionsFile = "bml/fil/readOptions.xml";
						question = Q.getFilText();
						question = strPhonetics(question);
						questionTokens = parseQuestion(question);
						bpFile = searchPart(questionTokens, filList);

					}
					//String text = question.concat(optionList);
					editXML(xmlFile, question);
					execGreta(xmlFile);
					if(!bpFile.isEmpty()) {
						
						String path = "bml/";
						bpFile = path.concat(bpFile);
						execGreta(bpFile);
						
					}
					editXML(optionsFile, optionList);
					execGreta(optionsFile);
					//System.out.println(optionsFile);
					ans = displayUI(Q,eng,xmlFile);
					answer = ans.getAnswer();
					
					// INSERT REPLY STUFF HERE
					xml = speechInt.getXML(3, lang, xml.getCurrType());
					xmlFile = xml.getFileName();
					execGreta(xmlFile);

					if(answer.equalsIgnoreCase(yesStr)) {
						
						ansInt.addAnswer(ans, Q); // ADDS TO DATABASE
						next = true;
						step = Q.getYesNext();
						System.out.println("Next step: " + step);
						

					}
					else if(answer.equalsIgnoreCase(noStr)) {

						//System.out.println("\nanswered no");
						ansInt.addAnswer(ans, Q); // ADDS TO DATABASE

					}
					else if(answer.equalsIgnoreCase("N/A")) {
						
						ansInt.addAnswer(ans, Q); // ADDS TO DATABASE
						
					}
					else if(answer.equalsIgnoreCase(cancelStr)) {

						cancel = true;
						
					}

				}

				if(!next) {

					step = Q.getNoNext();

				}

				if(step == -1) {

					String d = "bml/" + lang + "/instruct_hospital.xml";
					execGreta(d);
					cancel = true;
				}

				// PAUSE BEFORE NEXT QUESTION
				try {

					TimeUnit.SECONDS.sleep(5);

				}
				catch(InterruptedException e) {

					e.printStackTrace();
					
				}

				
			}while(!cancel && step != 0 && list.size() > 0);

			// END
			JOptionPane.showMessageDialog(frame, endStr);
			
			try {

				TimeUnit.SECONDS.sleep(3);

			}
			catch(InterruptedException e) {

				e.printStackTrace();
				
			}
			
			System.exit(0);
	
		}

		
		/*
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	Answer ans = new Answer();
	                Speech Q = new Speech();
	            	new Processor(ans, Q);

	            }
	        });
		*/

	} // END MAIN

	// READS FROM CSV AND SAVES TO ARRAYLIST - TESTED: SUCCESSFUL
	public static ArrayList<BodyPart> initPartList(String fileName) {

		ArrayList<BodyPart> list = new ArrayList<BodyPart>();
		BufferedReader readCSV = null;

		try {
			String newLine = "";
			String delimiter = ",";
			readCSV = new BufferedReader(new FileReader(fileName));

			while((newLine = readCSV.readLine()) != null) {

				BodyPart bp = new BodyPart();
				String array[] = newLine.split(delimiter);
				bp.setPart(array[0]);
				bp.setUsed(false);
				bp.setXMLFile(array[1]);
				list.add(bp);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {

			try {
				readCSV.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	// TOKENIZE QUESTION - TESTED: SUCCESSFUL
	public static ArrayList<String> parseQuestion(String question) {

		ArrayList<String> list = new ArrayList<String>();
		String array[] = question.split(" ");
		int max = array.length;
		int c;

		for(c = 0; c < max; c++) {
			list.add(array[c]);

		}

		return list;
		
	}

	// SEARCH FOR BODY PART AND RETURN XML - TESTED: SUCCESSFUL
	public static String searchPart(ArrayList<String> tokens, ArrayList<BodyPart> bpList) {

		int maxTokens = tokens.size();
		int maxBP = bpList.size();
		int c, d;

		for(c = 0; c < maxTokens; c++) {
			
			
			String tok = tokens.get(c);
			
			for (d = 0; d < maxBP; d++) {
				
				BodyPart bp = new BodyPart();
				bp = bpList.get(d);
				
				if(tok.compareTo(bp.getPart()) == 0) {
					bp.setUsed(true);
					return bp.getXMLFile();
				}

			}

		}

		return "";

	}

	// SHOWS UI
	public static Answer displayUI(Speech Q, boolean eng, String xmlFile) {
		Answer a = new Answer();
		Processor p = new Processor(a,Q,eng, xmlFile);
		//System.out.println(p.getAns().getAnswer());
		return p.getAns();

	}

	// EDITS XML FILE WITH TEXT
	public static void editXML(String filename, String speech) {

		XMLmod mod = new XMLmod();

		try {
		    DOMParser parser = new DOMParser();
		    parser.parse(filename);
		    Document doc = parser.getDocument();

		    // Get the document's root XML node
		    NodeList root = doc.getChildNodes();

		    // Navigate down the hierarchy to get to the CEO node
		    Node first = mod.getNode("bml", root);
		    NodeList firstNodes = first.getChildNodes();
		    Node sec = mod.getNode("speech", firstNodes);
			mod.setLastValue("speech", speech, firstNodes);
			mod.setAttrValue(sec, "text", speech); // CHANGE ATTR VALUE


		    // OVERWRITE XML FILE
		    doc = parser.getDocument();
		    OutputFormat format = new OutputFormat(doc);
		    format.setIndenting(true);
		    XMLSerializer serializer = new XMLSerializer(
		    new FileOutputStream(new File(filename)), format);
		    serializer.serialize(doc);

		}
		catch ( Exception e ) {
		    e.printStackTrace();
		}

	}

	// SENDS FILE TO GRETA FOR EXECUTION
	public static void execGreta(String filename) {


		GretaResponse greta = new GretaResponse();
		greta.executeArea(filename);

	}

	// CHANGES SPELLING OF CERTAIN WORDS
	public static String strPhonetics(String str) {

		boolean changed = false;
		int max = str.length();
		int c;

		for (c = 0; c < max; c++) {

			/*if(str.charAt(c) == 'a' || str.charAt(c) == 'A') {

				str = replace(str, c, "ah");
				changed = true;
			}
			else*/ if(str.charAt(c) == 'e' || str.charAt(c) == 'E') {

				str = replace(str, c, "eh");
				changed = true;

			}
			else if(str.charAt(c) == 'i' || str.charAt(c) == 'I') {

				str = replace(str, c, "ee");
				changed = true;

			}
			else if(str.charAt(c) == 'o' || str.charAt(c) == 'O') {

				str = replace(str, c, "oh");
				changed = true;

			}
			else if(str.charAt(c) == 'u' || str.charAt(c) == 'U') {

				str = replace(str, c, "oo");
				changed = true;

			}

			if(changed == true) {

				max = str.length();
				c++;
				changed = false;

			}

		}


		return str;

	}

	// PERFORMS REPLACE ACTION
	public static String replace(String oldStr, int charNum, String replaceWith) {

		String newStr = new String();
		int max = oldStr.length();

		newStr = oldStr.substring(0,charNum) + replaceWith + oldStr.substring(charNum+1, max);

		return newStr;

	}


} // END CLASS DRIVER

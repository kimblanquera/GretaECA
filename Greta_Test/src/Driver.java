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
		boolean cancel = false, eng = false, next = false;
		int start = 0, x = 0;
		Speech q = new Speech();
		String disp = "", yes = "", no = "", lang = "";

		// SET UP BODY PART LIST
		ArrayList<BodyPart> engList = new ArrayList<BodyPart>();
		ArrayList<BodyPart> filList = new ArrayList<BodyPart>();
		String engFile = "../Reference Files/Body Parts - English.csv";
		String filFile = "../Reference Files/Body Parts - Filipino.csv";

		engList = initPartList(engFile);
		filList = initPartList(filFile);

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

			//System.out.println("English");

		}
		else if(choice == 1) {

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
			String question = "";
			Speech Q = new Speech();
			int step = 1, c, answer;
			XMLinfo xml = new XMLinfo();
			xml.setCurrType(-1);
			int type = 0;

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

						question = Q.getEngText();

					}
					else {

						question = Q.getFilText();
						question = strPhonetics(question);
					}

					//editXML(xmlFile, question);
					//execGreta(xmlFile);
					ans = displayUI(Q,eng);
					answer = ans.getAnswer();

					// INSERT REPLY STUFF HERE
					xml = speechInt.getXML(3, lang, xml.getCurrType());
					xmlFile = xml.getFileName();
					execGreta(xmlFile);

					if(answer == JOptionPane.YES_OPTION) {

						next = true;
						step = Q.getYesNext();
						//System.out.println("Next step: " + step);

					}
					else if(answer == JOptionPane.NO_OPTION) {

						//System.out.println("\nanswered no");

					}
					else if(answer == JOptionPane.CANCEL_OPTION) {

						cancel = true;

					}



				}

				if(!next) {

					step = Q.getNoNext();

				}

				if(step == -1) {

					//String d = "bml/" + lang + "/instruct_hospital.xml";
					//execGreta(d);
					cancel = true;
				}

				// PAUSE BEFORE NEXT QUESTION
				try {

					TimeUnit.SECONDS.sleep(3);

				}
				catch(InterruptedException e) {

				}


			}while(!cancel && step != 0 && list.size() > 0);

			System.out.println("Ended.");
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

	// READS FROM CSV AND SAVES TO ARRAYLIST
	public static ArrayList<BodyPart> initPartList(String fileName) {

		ArrayList<BodyPart> list = new ArrayList<BodyPart>();
		BufferedReader readCSV = null;

		try {
			String newLine = "";
			readCSV = new BufferedReader(new FileReader(fileName));

			while((newLine = readCSV.readLine()) != null) {

				BodyPart bp = new BodyPart();
				bp.setPart(newLine);
				bp.setUsed(false);
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

	public static ArrayList<String> parseQuestion(String question) {

		ArrayList<String> list = new ArrayList();



	}

	// SHOWS UI
	public static Answer displayUI(Speech Q, boolean eng) {
		Answer a = new Answer();
		Processor p = new Processor(a,Q,eng);
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

			if(str.charAt(c) == 'a' || str.charAt(c) == 'A') {

				str = replace(str, c, "ah");
				changed = true;
			}
			else if(str.charAt(c) == 'e' || str.charAt(c) == 'E') {

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

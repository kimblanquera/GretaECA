import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.*;

import connection.Connect;
import connection.ConnectInt;
import Bean.Answer;
import Bean.Speech;
import Impl.SpeechImplementation;
import Interface.SpeechInterface;
import Bean.XMLinfo;

public class Processor {

	private static JOptionPane pane;
	private Answer a;
	private static boolean lang;
	private Speech sp;
	
	public void setAns(Answer ans) {
		
		this.a = ans;
		
	}
	
	public void setSpeech(Speech x) {
		
		this.sp = x;
		
	}
	
	
	public Answer getAns() {
		
		return a;
		
	}
	
	public Speech getSp() {
		
		return sp;
		
	}
	
	public Processor(){}
	
	// START DRIVER()
	public Processor(Answer ans, Speech Q, boolean eng, String xmlFile) {
		final boolean lang = eng;
		a = ans;
		a.setConfirm(false);
		sp = Q;
		JFrame fr = new JFrame();
		a.setFrame(fr);
		String str = new String();
		String op1 = new String();
		String op2 = new String();
		String cancel = new String();
		String again = new String();
		String title = new String();
		
		if(eng) {
			
			op1 = Q.getEngYes();
			op2 = Q.getEngNo();
			str = Q.getEngText();
			cancel = "Cancel";
			again = "Repeat the question";
			title = "Consultation";
			
		}
		else {
			
			op1 = Q.getFilYes();
			op2 = Q.getFilNo();
			str = Q.getFilText();
			cancel = "Ikansela";
			again = "Ulitin ang tanong";
			title = "Konsultasyon";
		}
		
		JFrame frame = new JFrame();
		final JDialog dialog = new JDialog(frame, title, true);
		pane = new JOptionPane();
		ButtonGroup btnGroup = new ButtonGroup();
		JToggleButton yes = getButton(frame, pane, op1, Q, ans, eng, xmlFile);
		JToggleButton no = getButton(frame, pane, op2, Q, ans, eng, xmlFile);
		JToggleButton na = getButton(frame, pane, "N/A", Q, ans, eng, xmlFile);
		JToggleButton can = getButton(frame, pane, cancel, Q, ans, eng, xmlFile);
		JToggleButton repeat = getButton(frame, pane, again, Q, ans, eng, xmlFile);
		btnGroup.add(yes);
		btnGroup.add(no);
		btnGroup.add(na);
		btnGroup.add(repeat);
		btnGroup.add(can);
		pane.setMessage(str);
		pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		pane.setOptions(new Object[] { yes, no, na, repeat, can });
		
		//pane = new JOptionPane(str, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, options, null);
		//pane.addPropertyChangeListener(this);
		//final JDialog dialog = pane.createDialog("Question");
		dialog.setContentPane(pane);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		dialog.addWindowListener(new WindowAdapter() {
		
			// START WINDOWCLOSING
			public void windowClosing(WindowEvent we) {
			
				JFrame fr = new JFrame();
				String s = new String();
				if(lang) {
					s = "Are you sure you want to cancel?";
				}
				else
					s = "Sigurado ba kayo sa inyong sagot?";
				int choice = JOptionPane.showConfirmDialog(fr,s); // change language of options!!!
				if(choice == JOptionPane.YES_OPTION) {
					
					dialog.dispose();
						
				}
				
			}
			// END WINDOWCLOSING
				
		});
			
		if(dialog.isVisible() && a.getConfirm()) {
		
			dialog.setVisible(false);
			dialog.dispose();
		
		}
		else {
				
			dialog.pack();
			dialog.setVisible(true);
				
		}
		a = ans;
		//System.out.println(a.getAnswer());
			
			
	}
	// END DRIVER()
		
	public static JToggleButton getButton(final JFrame frame, final JOptionPane p, String text, final Speech s, final Answer x, final Boolean lang, final String xmlFile) {
		final JToggleButton button = new JToggleButton(text);
		ActionListener actionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent actionEvent) {
				
				p.setValue(button.getText());
				int choice = 0;
				String answer = new String();
				answer = p.getValue().toString();
				JFrame fr = new JFrame();
				String l = "", yes = "", no = "", sure = "", yesStr = "", noStr = "";
				
				if (lang) {
					
					l = "eng";
					yes = s.getEngYes();
					no = s.getEngNo();
					sure = "Are you sure about your answer?";
					yesStr = "Yes";
					noStr = "No";
					
				}
				else {
					
					l = "fil";
					yes = s.getFilYes();
					no = s.getFilNo();
					sure = "Sigurado na ba kayo sa inyong sagot?";
					yesStr = "Oo";
					noStr = "Hindi";
				}
				
				String[] options = {
					
					yesStr,
					noStr
						
				};
				
				if(answer.equalsIgnoreCase(yes)) {
					String file = "bml/" + l + "/repeatOption.xml";
					System.out.println(file);
					editXML(file,yes);
					execGreta(file);
					shortWait();
					editXML(file,sure);
					execGreta(file);
					choice = JOptionPane.showOptionDialog(fr, sure, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					shortWait();
					
				}
				else if(answer.equalsIgnoreCase("N/A")) {
					String file = "bml/" + l + "/repeatOption.xml";
					System.out.println(file);
					editXML(file,yes);
					shortWait();
					execGreta(file);
					editXML(file,sure);
					execGreta(file);
					choice = JOptionPane.showOptionDialog(fr, sure, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					shortWait();
				}
				else if(answer.equalsIgnoreCase(no)) {
					String file = "bml/" + l + "/repeatOption.xml";
					editXML(file,no);
					execGreta(file);
					shortWait();
					//answer = "No";
					editXML(file,sure);
					execGreta(file);
					choice = JOptionPane.showOptionDialog(fr, sure, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					shortWait();
			
				}
				else if(answer.equalsIgnoreCase("Repeat the question") || answer.equalsIgnoreCase("Ulitin ang tanong")) {
					
					//choice = JOptionPane.showConfirmDialog(fr, sure);
					execGreta(xmlFile);
					choice = JOptionPane.NO_OPTION;
					shortWait();
					
				}
				else if(answer.equalsIgnoreCase("Cancel") || answer.equalsIgnoreCase("Ikansela")) {
					
					choice = JOptionPane.showOptionDialog(fr, sure, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
				}
						
				if(choice == JOptionPane.YES_OPTION) {
					x.setAnswer(answer);
					x.setConfirm(true);
					x.getFrame().dispose();
					fr.dispose();
					frame.dispose();
					//System.exit(0);
				
				}
				
			}
			
		};
		button.addActionListener(actionListener);
		
		return button;
	}
	
	
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
	
	public static void execGreta(String filename) {
		
		
		GretaResponse greta = new GretaResponse();
		greta.executeArea(filename);
		
	}
	
public static void longWait() {
		
		try {

			TimeUnit.SECONDS.sleep(10);

		}
		catch(InterruptedException e) {

			e.printStackTrace();
			
		}

		
	}
	
	public static void shortWait() {
		
		try {

			TimeUnit.SECONDS.sleep(5);

		}
		catch(InterruptedException e) {

			e.printStackTrace();
			
		}

		
	}

	
}

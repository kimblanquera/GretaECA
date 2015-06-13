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

import connection.Connect;
import connection.ConnectInt;
import Bean.Answer;
import Bean.Speech;
import Impl.SpeechImplementation;
import Interface.SpeechInterface;
import Bean.XMLinfo;

public class Processor implements PropertyChangeListener {

	private JOptionPane pane;
	private Answer a;
	private boolean lang;
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
	public Processor(Answer ans, Speech Q, boolean eng) {
		lang = eng;
		a = ans;
		a.setConfirm(false);
		sp = Q;
		JFrame fr = new JFrame();
		a.setFrame(fr);
		String str = new String();
		String op1 = new String();
		String op2 = new String();
		String cancel = new String();
		
		if(eng) {
			
			op1 = Q.getEngYes();
			op2 = Q.getEngNo();
			str = Q.getEngText();
			cancel = "Cancel";
			
		}
		else {
			
			op1 = Q.getFilYes();
			op2 = Q.getFilNo();
			str = Q.getFilText();
			cancel = "Ikansela";
			
		}
		
		Object[] options = {
			
			op1,
			op2,
			cancel
				
		};
		
		pane = new JOptionPane(str, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION, null, options, null);
		pane.addPropertyChangeListener(this);
		final JDialog dialog = new JDialog(a.getFrame(), "Click", true);
		//final JDialog dialog = pane.createDialog("Question");
		dialog.setContentPane(pane);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.addWindowListener(new WindowAdapter() {
		
			// START WINDOWCLOSING
			public void windowClosing(WindowEvent we) {
			
				JFrame fr = new JFrame();
				int choice = JOptionPane.showConfirmDialog(fr, "Are you sure?");
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
			
			
	}
	// END DRIVER()
		

	// START PROPERTYCHANGE
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		
		String p = e.getPropertyName();
		String ans = "";
		int finalAns = 0;
		if(pane.isVisible() && (e.getSource() == pane) && (JOptionPane.VALUE_PROPERTY.equals(p) || JOptionPane.INPUT_VALUE_PROPERTY.equals(p))) {
					
			if(pane.getValue() == JOptionPane.UNINITIALIZED_VALUE || pane.getValue() == null) {
				return;
			}
			else {
				int choice = 0;
				String answer = new String();
				ans = pane.getValue().toString();
				JFrame fr = new JFrame();
				String l = "", yes = "", no = "";
				if (lang) {
					
					l = "eng";
					yes = sp.getEngYes();
					no = sp.getEngNo();
				}
				else {
					
					l = "fil";
					yes = sp.getFilYes();
					no = sp.getFilNo();
					
				}
				
				if(ans == sp.getEngYes() || ans == sp.getFilYes()) {
					String file = "bml/" + l + "/repeatOption.xml";
					System.out.println(file);
					finalAns = JOptionPane.YES_OPTION;
					//editXML(file,yes);
					//execGreta(file);
					//answer = "Yes";
					choice = JOptionPane.showConfirmDialog(fr, "Are you sure?");
							
				}
				else if(ans == sp.getEngNo() || ans == sp.getFilNo()) {
					String file = "bml/" + l + "/repeatOption.xml";
					finalAns = JOptionPane.NO_OPTION;
					//editXML(file,no);
					//execGreta(file);
					//answer = "No";
					choice = JOptionPane.showConfirmDialog(fr, "Are you sure?");
			
				}
				else if(ans == "Cancel" || ans == "Ikansela") {
					
					choice = JOptionPane.showConfirmDialog(fr, "Are you sure?");
					
				}
						
				if(choice == JOptionPane.YES_OPTION) {
					
					a.setAnswer(finalAns);
					a.setConfirm(true);
					a.getFrame().dispose();
					fr.dispose();
					//System.exit(0);
				
				}
						
			}
		}
		// END IF	
	
	}
	// END PROPERTYCHANGE

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
	
	
}

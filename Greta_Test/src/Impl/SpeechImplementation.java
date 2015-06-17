package Impl;
import Bean.Speech;
import Interface.SpeechInterface;
import connection.Connect;
import connection.ConnectInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.Random;
import java.util.*;
import Bean.XMLinfo;

public class SpeechImplementation implements SpeechInterface {

	private Connection con;
	private ConnectInt newCon;
	
	@Override
	public ArrayList<Speech> allSpeech() {
		ArrayList<Speech> list = new ArrayList<Speech>();
		
		try {
            newCon = ConnectInt.getNewCon();
            con = newCon.getConnection();
            String query = "SELECT * FROM inputText";
            PreparedStatement p = con.prepareStatement(query);
            ResultSet result = p.executeQuery(query);
            
            while(result.next()) {
            	
            	Speech s = new Speech();
            	s.setID(result.getInt("question_id"));
            	s.setStep(result.getInt("step"));
            	s.setTextTypeiD(result.getInt("textTypeID"));
                s.setIntentTypeID(result.getInt("intentTypeID"));
                s.setFilText(result.getString("filText"));
                s.setEngText(result.getString("engText"));
                s.setFilYes(result.getString("filYes"));
                s.setFilNo(result.getString("filNo"));
                s.setEngYes(result.getString("engYes"));
                s.setEngNo(result.getString("engNo"));
                s.setYesNext(result.getInt("yesNext"));
                s.setNoNext(result.getInt("noNext"));
            	list.add(s);
            	
            }
            con.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
		
		
		return list;
	}
	
	public int getType(int textTypeID, int intentTypeID) {
	
		if (textTypeID == 1 && intentTypeID == 1) { // QUESTION && NORMAL
			
			return 1;
			
		}
		else if (textTypeID == 1 && intentTypeID == 2) { // QUESTION && NEG

			return 2;
			
		}
		else if (textTypeID == 2 && intentTypeID == 1) { // REPLY && POSITIVE

			return 3;
			
		}
		else if (textTypeID == 2 && intentTypeID == 2) { // REPLY && NEG

			return 4;
			
		}

		return 0;
	
	}
	
	public XMLinfo getXML(int type, String lang, int y) {
		
		XMLinfo xml = new XMLinfo();
		
		Random r = new Random();
		
		if(type == 1) {
		
			int x = 0;
			
			do {
				
				x = r.nextInt(3);
				
			}while(x == y);
			
			
			if(x == 0) { 
				
				String s = "bml/" + lang + "/question_normal2.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 1) {
				
				String s = "bml/" + lang + "/question_normal3.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 2) {
				
				String s = "bml/" + lang + "/question_normal4.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 3) {
				
				String s = "bml/" + lang + "/question_normal5.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			
		}
		else if(type == 2) {
			
			int x = 0;
			
			do {
				
				x = r.nextInt(2);
				
			}while(x == y);
			
			if(x == 0) {
				
				String s = "bml/" + lang + "/question_gentle.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
				
			}
			else if(x == 1) {
				
				String s = "bml/" + lang + "/question_gentle2.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 2) {
				
				String s = "bml/" + lang + "/question_gentle3.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			
		}
		else if(type == 3) {
			
			int x = 0;
			
			do {
				
				x = r.nextInt(2);
				
			}while(x == y);
			
			if(x == 0) {
				
				String s = "bml/" + lang + "/reply_pos1.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
				
			}
			else if(x == 1) {
				
				String s = "bml/" + lang + "/reply_pos2.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 2) {
				
				String s = "bml/" + lang + "/reply_pos2.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			
		}
		else if(type == 4) {
			
			int x = 0;
			
			do {
				
				x = r.nextInt(2);
				
			}while(x == y);
			
			if(x == 0) {
				
				String s = "bml/" + lang + "/reply_neg1.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
				
			}
			else if(x == 1) {
				
				String s = "bml/" + lang + "/reply_neg2.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			else if(x == 2) {
				
				String s = "bml/" + lang + "/reply_neg3.xml";
				xml.setFileName(s);
				xml.setCurrType(x);
				return xml;
				
			}
			
		}
		else if(type == 5) {
			
			String s = "bml/" + lang + "/instruct_hospital.xml";
			xml.setFileName(s);
			xml.setCurrType(0);
			return xml;
			
			
		}

		
		return xml;
		
	}
	
	public ArrayList<Speech> getQuestionByStep(int i) {
		
		ArrayList<Speech> list = new ArrayList<Speech>();
		
		try {
            newCon = ConnectInt.getNewCon();
            con = newCon.getConnection();
            String query = "SELECT * FROM inputText WHERE step =" + Integer.toString(i);
            PreparedStatement p = con.prepareStatement(query);
            ResultSet result = p.executeQuery(query);
            
            while(result.next()) {
            	
            	Speech s = new Speech();
            	s.setID(result.getInt("question_id"));
            	s.setStep(result.getInt("step"));
            	s.setTextTypeiD(result.getInt("textTypeID"));
                s.setIntentTypeID(result.getInt("intentTypeID"));
                s.setFilText(result.getString("filText"));
                s.setEngText(result.getString("engText"));
                s.setFilYes(result.getString("filYes"));
                s.setFilNo(result.getString("filNo"));
                s.setEngYes(result.getString("engYes"));
                s.setEngNo(result.getString("engNo"));
                s.setYesNext(result.getInt("yesNext"));
                s.setNoNext(result.getInt("noNext"));
            	list.add(s);
            	
            }
            con.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
		
		
		return list;
		
	}
	
}
	
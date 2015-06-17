package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.*;
import Interface.*;
import connection.ConnectInt;

public class AnswerImplementation implements AnswerInterface {

	private Connection con;
	private ConnectInt newCon;
	
	@Override
	public int addAnswer(Answer a, Speech q) {
		
		try {
            
			newCon = ConnectInt.getNewCon();
            con = newCon.getConnection();
            
            System.out.println(q.getID() + " " + a.getAnswer());
            
            //String query = "INSERT INTO patient_answers_table VALUES(" + q.getID() + ", '" + a.getAnswer() + "');";
            String query = "INSERT INTO patient_answers_table VALUES(2, 'N/A');";
            PreparedStatement p = con.prepareStatement(query);
            p.executeUpdate(query);
            
            con.close();
            return 1;
            
        }
        catch(SQLException e) {
            System.out.println(e);
            return 0;
        }
		
	}
	
}

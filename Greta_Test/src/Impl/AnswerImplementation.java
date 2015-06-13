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
            String query = "INSERT INTO answer VALUES(''," + a.getAnswer() + ");";
            PreparedStatement p = con.prepareStatement(query);
            p.executeQuery(query);
            
            query = "SELECT * FROM answer ORDER BY answerID DESC LIMIT 1 ";
            p = con.prepareStatement(query);
            ResultSet result = p.executeQuery(query);
            
            int x = result.getInt("answerID");
            
            query = "INSERT INTO questionAnswer VALUES(" + Integer.toString(q.getID())  + ", " + Integer.toString(x) + ");";
            
            con.close();
            return 1;
        }
        catch(SQLException e) {
            System.out.println(e);
            return 0;
        }
		
	}
	
}

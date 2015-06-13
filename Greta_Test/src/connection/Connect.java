/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kim
 */
public class Connect extends ConnectInt {
    
    public Connection getConnection() {
        try {
            Class.forName(driver());
            Connection conn = DriverManager.getConnection(url(), userName(), pw());
            return conn;
        } catch (SQLException ex) {
           System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
    
}

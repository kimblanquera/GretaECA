/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;
import connection.ConnectInt;
import java.sql.Connection;
/**
 *
 * @author Kim
 */
public abstract class ConnectInt {
    private String driverName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/getbetter";
    private String admin = "root";
    private String password = "";
    
    public static ConnectInt getNewCon() {
    
        return new Connect();
        
    }
    
    public abstract Connection getConnection();
    
    public String driver() {
        return driverName;
    }
    
    public String url() {
        return url;
    }
    
    public String userName() {
        return admin;
    }
    
    public String pw() {
        return password;
    }
    
    public void setdriver(String s) {
        this.driverName = s;
    }
    
    public void seturl(String s) {
        this.url = s;
    }
    
    public void setuserName(String s) {
        this.admin = s;
    }
    
    public void setpw(String s) {
        this.password = s;
    }
}

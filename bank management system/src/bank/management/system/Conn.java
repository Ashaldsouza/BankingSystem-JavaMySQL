
package bank.management.system;

import java.sql.*;  

class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "ash020104");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

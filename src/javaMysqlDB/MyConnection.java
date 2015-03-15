/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMysqlDB;

/**
 *
 * @author nullmonkey
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection {
          
    public Connection connection = null;
    
    public Connection getConnection()

        {
            //
                System.out.println("--------Testing Mysql Connection ------");
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } 
                catch (ClassNotFoundException e) {
                        
                        System.out.println("Where is MySQL Driver?");
                        e.printStackTrace();
            //return;
                }
                
System.out.println("Mysql Driver Registered!");

// Connection connection = null;

                try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","mysql");
                    } 
                catch (SQLException e) {
                        System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    //return;
                    }
                
                    if (connection != null) {
                        System.out.println("Connected to DataBase ");
                    } 
                    else {
                            System.out.println("Failed to make connection!");
                    }
return connection ;
}
}


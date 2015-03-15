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
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PersonDao {

    public Statement statement = null;
    public Connection dbConnection = null;

     public List<Person> getAllNames() throws SQLException {
        List<Person> mylist = new ArrayList();
        try {
            MyConnection mc = new MyConnection();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
            
            
                    String selectTableSQL = "SELECT * FROM travel.person";
                    ResultSet rs = statement.executeQuery(selectTableSQL);
            
            while (rs.next()) {
                //Integer pId = rs.getInt("personid");
                String pName = rs.getString("name");
                //String pJobTitle = rs.getString("jobtitle");
             

            Person e = new Person(pName);
            
                //System.out.println("Person ID : " + pId);
               // System.out.println("Person NAME : " + pName);
            
             mylist.add(e);
            }
        }    
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return mylist;
    }
    
    public List<Person> getAllPerson() throws SQLException {
        List<Person> mylist = new ArrayList();
        try {
            MyConnection mc = new MyConnection();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
            
            
                    String selectTableSQL = "SELECT * FROM travel.person";
                    ResultSet rs = statement.executeQuery(selectTableSQL);
            
            while (rs.next()) {
                Integer pId = rs.getInt("personid");
                String pName = rs.getString("name");
                String pJobTitle = rs.getString("jobtitle");
             

            Person e = new Person(pId, pName, pJobTitle);
            
                //System.out.println("Person ID : " + pId);
               // System.out.println("Person NAME : " + pName);
            
             mylist.add(e);
            }
        } 
        
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return mylist;
    }


//   public void insertPerson(String Name, String jobTitle) throws SQLException {
//        String insertTableSQL = "INSERT INTO travel.person "
//                + "(name, jobtitle) " + "VALUES"
//                + "('" + Name + "','" + jobTitle + "')";
//        try {
//            MyConnection mc = new MyConnection();
//            dbConnection = mc.getConnection();
//            statement = dbConnection.createStatement();
//    //System.err.println(insertTableSQL);
//            // execute insert SQL stetement
//            statement.executeUpdate(insertTableSQL);
//            System.out.println("Record is inserted into person table!");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
//    }
}

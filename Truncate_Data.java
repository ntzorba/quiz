//package Example_Import; 

import java.sql.*; 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.io.*; 
import java.lang.String; 
import java.util.Scanner; 

public class Truncate_Data{ 
//import mysql-connector-java-5.1.32.jar 
//http://www.tutorialspoint.com/jdbc/jdbc-create-tables.htm 
private static String JDBC_URL = "jdbc:mysql://localhost:3306/quiz"; 
private static String USER = "root"; 
private static String PASSWORD = "Unix11unix12"; 

public static void main(String[] args) throws IOException { 

Connection myConnection = null; 
Statement statement = null; 
PreparedStatement preparedStatement = null; 

try{ 
//CONNECTING TO THE DATABASE

//Class.forName("com.mysql.jdbc.Driver");
myConnection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD); 


System.out.println("Connected to database"); //CONNECTED 

// CREATING TABLE IN THE DATABASE	
// System.out.println("Creating table in given database..."); 
// statement = myConnection.createStatement(); 

// String sql = "CREATE TABLE REGISTRATION " + 
// "(id INTEGER not NULL, " + 
// " last VARCHAR(25), " + 
// " first VARCHAR(25), " + 
// " balance FLOAT, " + 
// " Credit FLOAT," + 
// " Date DATE," + 
// " Rating CHAR," + 
// " PRIMARY KEY ( id ))"; 

// statement.executeUpdate(sql); 
// System.out.println("Created table in given database..."); 
// statement.close(); //closing statement 


//CREATING A PREPARED STATEMENT 
String truncateTableSQL = "Truncate table question"; 
//+ "(id, name, question, answer) VALUES" 
//+ "(?,?,?,?)"; 


preparedStatement = myConnection.prepareStatement(truncateTableSQL); 
/*
//RETRIEVING INFORMATION FROM CSV FILE 

//opening a file input stream 
BufferedReader reader = new BufferedReader(new FileReader("SAMPLE.csv")); 

String line = null; //line read from csv 
Scanner scanner = null; //scanned line 

SimpleDateFormat date = new SimpleDateFormat("mm/DD/yyyy"); 

reader.readLine(); //omits the first line 

//READING FILE LINE BY LINE AND UPLOADING INFORMATION TO DATABASE 
while((line = reader.readLine()) != null){ 
scanner = new Scanner(line); 
scanner.useDelimiter(","); 
while(scanner.hasNext()){ 
preparedStatement.setInt(1,Integer.parseInt(scanner.next())); 
preparedStatement.setString(2, scanner.next()); 
preparedStatement.setString(3, scanner.next()); 
preparedStatement.setString(4, scanner.next());
}	
*/
preparedStatement.executeUpdate(); 
 

preparedStatement.close(); 

System.out.println("Data imported"); 

//reader.close(); //closing CSV reader 

} catch (SQLException e){ 
e.printStackTrace(); 
}finally{//CLOSING CONNECTION 
try{ 
if(statement!=null) 
myConnection.close(); 
}catch(SQLException se){ 
}// do nothing 
try{ 
if(myConnection!=null) 
myConnection.close(); 
}catch(SQLException se){ 
se.printStackTrace(); 
} 
System.out.println("Connection closed"); 
} 
} 
} 

package ineuronutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ineuron.jdbcutil;

//import java.util.Scanner;
import java.io.*;


public class selectApp {
	public static void main(String[] args) throws SQLException 
	{

		Connection connection = null;
		PreparedStatement psmt= null;
		ResultSet resultSet= null;
		int sid=0;
		
		

		try {
			connection = jdbcutil.getJdbcConnection();
			
			String sqlSelectQuery= "select sid,sname,sage,saddress from student where sid=?";
			
			
			if(connection!=null) {
				psmt= connection.prepareStatement(sqlSelectQuery);
			}
			
			if(psmt!=null)
			{
				Scanner scan = new Scanner(System.in);
				
				System.out.println("enter the id of student :: ");
				int sid1=scan.nextInt();
				
				//use precomplied query to set the values
				
				psmt.setInt(1, sid1);
				
				
				// execute the query
				resultSet = psmt.executeQuery();
			
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
					System.out.println(resultSet.getInt(1)+"\t"+ resultSet.getString(2)+"\t"+resultSet.getInt(3)+
					"\t"+ resultSet.getString(4));
				}
				else {
					System.out.println("Record not avialable for the give id:::"+ sid);
				}
			}

			
			
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcutil.cleanUp(connection, psmt, resultSet);
				System.out.println("closing the resources...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}

			


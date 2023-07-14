package ineuron;
import java.io.*;
import java.sql.*;
import java.util.*;

public class jdbcutil {
	private jdbcutil() 
	{
	}

		
		

		public static Connection getJdbcConnection() throws SQLException, IOException
		{

			// Take the data from properties file
			FileInputStream fis = new FileInputStream("D:\\JavaApps\\jdbcPreparedstatement\\src\\ineuronproperty\\applicationproperties");
			Properties properties = new Properties();
			properties.load(fis);

			// Step2. Establish the Connection
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("username"), properties.getProperty("password"));
			System.out.println("connection object created...");
			return connection;
		}

		public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException 
		{
			// Step6. Close the resources
			if (connection != null) 
			{
				connection.close();
			}

			if (statement != null) 
			{
				statement.close();
			}
			if (resultSet != null) 
			{
				resultSet.close();
			}

		}

	
}

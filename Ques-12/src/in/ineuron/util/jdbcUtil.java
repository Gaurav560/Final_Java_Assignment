package in.ineuron.util;

import java.io.*;
import java.sql.*;

import java.util.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class jdbcUtil {

	private jdbcUtil() {} //constructor
	public static Connection getJdbcConnection()throws SQLException, IOException {
		
		
		   HikariConfig config = new HikariConfig("D:\\JDBC programs\\JavaJDBC_AdvanceCURD1\\src\\in\\ineuron\\properties\\application.properties");
		   HikariDataSource dataSource = new HikariDataSource(config); 
	        return dataSource.getConnection();
	
	
	
	  }
	

}

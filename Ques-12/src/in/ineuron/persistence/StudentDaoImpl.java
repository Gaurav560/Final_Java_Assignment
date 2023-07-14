
package in.ineuron.persistence;

import java.io.IOException;
import java.sql.*;

import in.ineuron.dto.Student;
import in.ineuron.util.jdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection= null;
	PreparedStatement psmt= null;
    ResultSet resultSet = null;
	
	

	@Override
	public String addStudent(String sname, Integer sage,String saddress) {
		String sqlInsertQuery=" insert into student(`name`,`age`,`address`) values (?,?,?)";
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			if(connection!=null) 
				
				psmt= connection.prepareStatement(sqlInsertQuery);
			
			if(psmt!=null) {
				psmt.setString(1, sname);
				psmt.setInt(2, sage);
				psmt.setString(3,saddress);
				
				int rowaffect= psmt.executeUpdate();
				
				if(rowaffect==1) {
					return "success";
				}
			}
			
		} 
		
		
		catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failure";
	}
	
	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQuery="select id,name,age,address from student where id=?";
		Student student=null;
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			if(connection!=null) 
				
				psmt= connection.prepareStatement(sqlSelectQuery);
			
			if(psmt!=null) {
				psmt.setInt(1, sid);
			}
			if(psmt!=null) {
				resultSet = psmt.executeQuery();
			}
			if(resultSet!=null) {
				if(resultSet.next()) {
					student = new Student();
					
					//copying resultSet data student object
					student.setId(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setAge(resultSet.getInt(3));
					student.setAddress(resultSet.getString(4));
					return student;
				}
			}
		} 
		
		
		catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
		
		
	}
	
	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery=" delete from student where id =?";
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			if(connection!=null) 
				
				psmt= connection.prepareStatement(sqlDeleteQuery);
			
			if(psmt!=null) {
			
				psmt.setInt(1, sid);
				
				
				int rowaffect= psmt.executeUpdate();
				
				if(rowaffect==1) {
					return "success";
				}else {
					return "not found";
				}
			}
			
		} 
		
		
		catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		
		return "failure";
	}
	
	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery="update student set name=?, age=?, address=? where id=? ";
		try {
			connection=jdbcUtil.getJdbcConnection();
			
			if(connection!=null) 
				
				psmt= connection.prepareStatement(sqlUpdateQuery);
			
			if(psmt!=null) {
				psmt.setString(1, student.getName());
				psmt.setInt(2, student.getAge());
				psmt.setString(3, student.getAddress());
				psmt.setInt(4, student.getId());
				
				int rowaffect= psmt.executeUpdate();
				
				if(rowaffect==1) {
					return "success";
				}
			}
			
		} 
		
		
		catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failure";
	}
	
	
	

}
	
	
	
	



































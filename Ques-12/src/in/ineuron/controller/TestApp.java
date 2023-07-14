package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.service.factory.StudentServiceFactory;

//controller logic
public class TestApp {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("ENTER YOUR CHOICE PRESS[1/2/3/4/5]");
			String option = br.readLine();
			
			switch(option) {
			case"1": insertOperation();
				break;
			case"2": selectOperation();
				break;
			case"3": updateRecord();
				break;
			case"4": deleteRecord();
				break;
			case"5": System.out.println("*********Thank you for using application************");
			         System.exit(0);
				break;
			default:System.out.println("Invalid Input");
			     break;
			}
			
		}		
		
		
	}
	    
		public static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the student name:: ");
		String name =scan.next();
		
		System.out.println("Enter the age of student :: ");
		Integer age =scan.nextInt();
		
		System.out.println("Enter the student address :: ");
		String address =scan.next();
		
		String msg =studentService.addStudent(name,age,address);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted successfully");
		} else {
			System.out.println("record inserted failed...");
		}
     
	}
		
	    
        public static void selectOperation() {
        	Scanner scan =new Scanner(System.in);
    		System.out.println("Enter the student id :: ");
    		Integer id =scan.nextInt();
    		
    		IStudentService studentService = StudentServiceFactory.getStudentService();
            Student std= studentService.searchStudent(id);
    		if(std!=null) {
    			System.out.println(std);
    			System.out.println("ID\tNAME\tAGE\tADDRESS");
    			System.out.println(std.getId()+"\t"+std.getName()+"\t"+std.getAge()+"\t"+std.getAddress());
    			
    		}else {
    			System.out.println("Record not found for thid id :: "+id);
    		}
    		
        } 	
	    
	    
	    public static void updateRecord()throws IOException  {
	    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the student id  :: ");
			String id =br.readLine();
			
			IStudentService studentService = StudentServiceFactory.getStudentService();
			  Student student =studentService.searchStudent(Integer.parseInt(id));
				
			  if(student!=null) {
				  Student newStudent = new Student();
					System.out.println("Student id is :: "+student.getId());
					newStudent.setId(student.getId());
					
					System.out.println("Student old name is :: "+student.getName()+"  Enter new name :: ");
					String newName =br.readLine();
					if(newName.equals("")||newName=="") {
						newStudent.setName(student.getName());
					}
					else {
						newStudent.setName(newName);
					}
					
					
					System.out.println("Student oldAge is :: "+student.getAge() +"  Enter new age :: ");
					String newAge =br.readLine();
					if(newAge.equals("")||newAge=="") {
						newStudent.setAge(student.getAge());
					}
					else {
						newStudent.setAge(Integer.parseInt(newAge));
					}
					
					System.out.println("Student oldAddress is :: "+student.getAddress() +"  Enter new address :: ");
					String newAddress =br.readLine();
					if(newAddress.equals("")||newAddress=="") {
						newStudent.setAddress(student.getAddress());
					}
					else {
						newStudent.setAddress(newAddress);
					}
					
					System.out.println("New student data is :: "+newStudent);
					System.out.println();
					
					String status = studentService.updateStudent(newStudent);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("record updated successfully");
					}
					else  {
						System.out.println("record updation failed");
					}
						
	  		}else {
	  			System.out.println("Record not found for thid id :: "+id);
	  		}
					
	    }
	    
	    
	    
	    public static void deleteRecord() {
	    Scanner scan =new Scanner(System.in);
		System.out.println("Enter the student id  :: ");
		Integer id =scan.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		String msg =studentService.deleteStudent(id);
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("record deleted successfully");
		}
		else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("record not avaliable for the given Id :: "+id);
		}
		else {
			System.out.println("record deletion failed...");
		}
     
	    }
		
		

}

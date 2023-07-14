package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	//operations to be implemented
    public String addStudent(String name,Integer age, String address );
    
    public Student searchStudent(Integer id);
    
    public String updateStudent(Student student );
    
    public String deleteStudent(Integer id);

}

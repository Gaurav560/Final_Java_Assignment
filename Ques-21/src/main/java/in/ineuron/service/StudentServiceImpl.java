package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Student;
import in.ineuron.dao.StudentRepo;

@Service("service")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	public String insertDetails(Student student) {

		Student saveStudent = null;
		if (student != null) {
			saveStudent = repo.save(student);
		}
		return saveStudent != null ? "Student details  registered succesfully with " + saveStudent.getId()
				: "student details  registration failed";
	}

}

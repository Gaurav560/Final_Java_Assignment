
package in.ineuron.service;

import in.ineuron.dao.factory.copy.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;
import in.ineuron.service.factory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	
	@Override
	public String addStudent(String name, Integer age, String address) {
		stdDao =StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(name,age,address);
	}

	@Override
	public Student searchStudent(Integer id) {
		stdDao =StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao =StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) {
		stdDao =StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(id);
	}

}



package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.ineuron.dao.EmployeeRepo;
import in.ineuron.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmloyeeService {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public String saveDetails(Employee employee) {

		Integer eId = repo.save(employee).getEId();
		return "Employee details are save successfully with id ::" + eId;
	}

}

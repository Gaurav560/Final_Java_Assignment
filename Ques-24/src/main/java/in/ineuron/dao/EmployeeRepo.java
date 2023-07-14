package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Employee;

public interface EmployeeRepo extends JpaRepository <Employee, Integer> {

}

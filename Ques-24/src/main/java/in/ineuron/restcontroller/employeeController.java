package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Employee;
import in.ineuron.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/empl")
public class employeeController {
	
	@Autowired
	private EmployeeServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<String> registerDetails(@RequestBody Employee empl) {

		String msg= service.saveDetails(empl);
		return  new ResponseEntity<String>(msg,HttpStatus.OK);

	}
}

package in.ineuron;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Student;
import in.ineuron.service.IStudentService;

@SpringBootApplication
public class Ques21Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(Ques21Application.class, args);

		IStudentService service = factory.getBean(IStudentService.class);

		Scanner scanner = new Scanner(System.in);

//		System.out.print("Enter Id of student  : ");
//		Integer id = scanner.nextInt();
//		System.out.println();
		
		
		System.out.print("Enter name of student  : ");
		String name = scanner.nextLine();
		System.out.println();
		
		System.out.print("Enter name of studet's address : ");
		String address = scanner.nextLine();
		System.out.println();

		System.out.print("Enter mark of the student: ");
		double marks = scanner.nextDouble();
		System.out.println();
		
		Student student = new Student(null, name, address, marks);
		System.out.println(service.insertDetails(student));

		((ConfigurableApplicationContext) factory).close();

	}

}

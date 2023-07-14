package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.UserDetail;
import in.ineuron.service.IUserDetailMgmtService;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
	   IUserDetailMgmtService service = factory.getBean(IUserDetailMgmtService.class);

	   Scanner scanner = new Scanner(System.in);
	  
	   /*
	   System.out.print("Enter your id: ");
       long ids = scanner.nextLong();
	   */
	   
		List<Long> ids = new ArrayList<Long>();
		ids.add(1L);
		ids.add(2L);
       Iterable<UserDetail> records = service.fetchAllDetailsByID(ids);
       records.forEach(order->System.out.println(order));
	   
	   
	   	   
	   ((ConfigurableApplicationContext) factory).close();
	}

}

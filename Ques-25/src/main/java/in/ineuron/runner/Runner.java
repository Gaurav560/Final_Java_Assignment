package in.ineuron.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.service.Serviceclass;


@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private Serviceclass service;

	@Override
	public void run(String... args) throws Exception {

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println(" begin the operation  ");
			
			System.out.println("Kindly enter the value of a :: ");
			int a = scan.nextInt();
			System.out.println("Kindly enter the value of b :: ");
			int b = scan.nextInt();

			service.add(a, b);
		}
	}

}

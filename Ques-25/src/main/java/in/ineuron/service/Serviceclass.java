package in.ineuron.service;


import org.springframework.stereotype.Service;

@Service
public class Serviceclass {

	public int add(int a, int b) {
		int result = a + b;
		return result;
	}
}

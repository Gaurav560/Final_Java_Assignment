interface vechile1 {
	public void car();// contains only abstract methos

}

class Honda1 implements vechile1 {
	public void car() {
		System.out.println("this Car is awsome ........");
	}
}

public class InterfaceClassExample {
	public static void main(String[] args) {
		Honda1 honda = new Honda1();
		honda.car();
	}
}

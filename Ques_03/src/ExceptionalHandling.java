import java.util.Scanner;

public class ExceptionalHandling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter an number : ");
        int number = scanner.nextInt();

        try {
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
            System.out.println("Number is: " + number);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    
	}

}
 
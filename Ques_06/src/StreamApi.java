


	import java.util.ArrayList;
	import java.util.List;
	import java.util.stream.Collectors;

	public class StreamApi  {
	    public static void main(String[] args) {
	        // Create a large data set
	        List<Integer> numbers = new ArrayList<>();
	        for (int i = 1; i <= 100; i++) {
	            numbers.add(i);
	        }

	        // Filter the data to get even numbers
	        List<Integer> evenNumbers = numbers.stream()
	                .filter(num -> num % 2 == 0)
	                .collect(Collectors.toList());
	        System.out.println("Even numbers: " + evenNumbers);

	        // Sort the data in descending order
	        List<Integer> sortedNumbers = numbers.stream()
	                .sorted((a, b) -> b.compareTo(a))
	                .collect(Collectors.toList());
	        System.out.println("Sorted numbers: " + sortedNumbers);
	    }
	}

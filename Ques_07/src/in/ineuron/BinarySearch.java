package in.ineuron;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {10,20,25,30,36,58,68};
		System.out.println("Enter the key");
	  Scanner scan=new Scanner(System.in);
	  int key= scan.nextInt();
	  int low=0;
	  int high =arr.length-1;
	  while(low<=high) {
		  int mid = (low+high)/2;
		  if(key==arr[mid]) {
			  System.out.println("Key found at this index "+ mid);
			  break;
		  }
		  else if(key<arr[mid]) {
			  high= mid-1;
		  }
		  else if(key>arr[mid]) {
			  low = mid+1;
		  }
	  }
	  if(low>high) {
		  System.out.println("key not found");
	  }
	  

	}

}

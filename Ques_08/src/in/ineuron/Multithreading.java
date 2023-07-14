package in.ineuron;

class MyThread extends Thread{ //Thread is a inbuilt class
	
	public void run() { //run is a method inside Thread means run() method is predefined 
		 System.out.println("Even numbers"); 
		for(int i=1; i<=10; i++) { //this is the first task
	        if(i%2==0)
        	 System.out.println(i);
         }
    }
}
public class Multithreading {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start(); // here we use .start() method to call run() method, when start() method is called from this point we have two threads available 
		 
		 System.out.println("Odd numbers");                                   //one is main thread and another is user defined thread
		for(int i=1; i<10; i++) {  
			 if(i%2!=0)                                      // Thread scheduler will decide which thread should go for execution
			System.out.println(i);     //Maximum of the time thread scheduler give first chance to main method thread for execution then user defined thread 
		}

	}

}




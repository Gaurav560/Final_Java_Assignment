abstract class vechile {
    public abstract void car ();//abstract methos
    
    public void bike () {//concrete method
        System.out.println("this Bike is awsome ......");
    }
}

class Honda extends vechile {
    public void car() { //overrides the abstract method
        System.out.println("this Car is awsome ........");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
    	Honda honda = new Honda();
    	honda.car();
        honda.bike();
    }
}

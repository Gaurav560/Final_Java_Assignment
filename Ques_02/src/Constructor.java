class Parent {
    public Parent() {
        System.out.println("Parent class constructor invoked ---- 1");
    }
}

class Child extends Parent {
    public Child() {
      super(); // Invoking parent class constructor
        System.out.println("Child class constructor invoked -----2");
    }
}

public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Child child = new Child();//child class object
	}

}
/*
 * When you run the ConstructorInvocationDemo program, it creates an instance of
 * the Child class. The Child class constructor uses the super() keyword to
 * invoke the parent class constructor. As a result, both the parent class
 * constructor and the child class constructor are invoked.
 */
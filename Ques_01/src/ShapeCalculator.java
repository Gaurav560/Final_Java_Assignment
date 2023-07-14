import java.util.Scanner;

interface Shape {
	double calculateArea();

	double calculatePerimeter();

}

class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
}

class Triangle implements Shape {
	private double base;
	private double height;

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	public double calculateArea() {
		return 0.5 * base * height;
	}

	public double calculatePerimeter() {
		return 3 * base;
	}
}

class Square implements Shape {
	private float side;

	public Square(float side) {
		super();
		this.side = side;
	}

	@Override
	public double calculateArea() {
		return side * side;
	}

	@Override
	public double calculatePerimeter() {

		return 4 * side;
	}

}

class Reactangle implements Shape {
	float length;
	float breath;

	public Reactangle(float length, float breath) {
		super();
		this.length = length;
		this.breath = breath;
	}

	@Override
	public double calculateArea() {
		return length * breath;
	}

	@Override
	public double calculatePerimeter() {

		return 2 * (length + breath);
	}

}

public class ShapeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("***************CIRCLE************");
		System.out.print("Enter the radius of the circle: ");
		double radius = scanner.nextDouble();
		Shape circle = new Circle(radius);
		System.out.println("Circle Area: " + circle.calculateArea());
		System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
		System.out.println();

		System.out.println("***************TRIANGLE************");
		System.out.print("Enter the base of the triangle: ");
		double base = scanner.nextDouble();
		System.out.print("Enter the height of the triangle: ");
		double height = scanner.nextDouble();
		Shape triangle = new Triangle(base, height);
		System.out.println("Triangle Area: " + triangle.calculateArea());
		System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());
		System.out.println();

		System.out.println("***************SQUARE************");
		System.out.print("Enter the length of the square: ");
		float side = scanner.nextFloat();
		Shape square = new Square(side);
		System.out.println("Square Area: " + square.calculateArea());
		System.out.println("Square Perimeter: " + square.calculatePerimeter());
		System.out.println();

		System.out.println("***************REACTANGLE************");
		System.out.print("Enter the length of the reactangle: ");
		float length = scanner.nextFloat();
		System.out.print("Enter the breath of the reactangle: ");
		float breath = scanner.nextFloat();
		Shape reactangle = new Reactangle(length, breath);
		System.out.println("Reactangle Area: " + reactangle.calculateArea());
		System.out.println("Reactangle Perimeter: " + reactangle.calculatePerimeter());
		System.out.println();
	}
}

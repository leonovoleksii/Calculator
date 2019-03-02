import java.util.Scanner;

public class Calculator {
	private String str;
	private double result;
	public void setStr() {
		System.out.print("Hello! I am calculator! What would you like to calculate? Enter here: ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
	}
	public String getStr() {
		return str;
	}
	public double getRes() {
		return result;
	}
	public void calculate() {

	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setStr();
		System.out.println(calculator.getStr());
	}
}
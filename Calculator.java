import java.util.Scanner;
import bin.*;

public class Calculator {
	private String str;
	private double result = 0;
	public void setStr() {
		System.out.print("Enter here: ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
	}
	public String getStr() {
		return str;
	}
	public double getRes() {
		return result;
	}
	public void calculate(boolean isRoman) {
		char charr[] = getStr().toCharArray();
		int i = 0;
		//while there is something to calculate
		while (i < charr.length) {
			//get next operator
			Operator operator = new Operator(charr);
			//skip all void charaters
			while (i < charr.length && charr[i] == Character.MIN_VALUE)
				i++;
			//get next operand
			Operand operand = new Operand(charr, isRoman);
			//skip all void characters
			while (i < charr.length && charr[i] == Character.MIN_VALUE)
				i++;
			//add or substract operand to/from value
			switch (operator.getValue()){
				case '+':
					result += operand.getValue();
					break;
				case '-':
					result -= operand.getValue();
					break;
				case '0':
					result += operand.getValue();
					break;
			}
		}
	}

	public boolean inputIsValid() {
		boolean arabic =false, roman = false;
		String s = getStr();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'M') 
				roman = true;
			else if ((int)c >= (int)'0' && (int)c <= (int)'9')
				arabic = true;
		}
		//return true if only arabic or only roman type
		return (arabic^roman);
	}

	public boolean isRoman() {
		String s = getStr();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I' || c == 'V' || c == 'X' || c == 'L' || c == 'C' || c == 'M')
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Hello! I am calculator! What would you like to calculate?");
		while (true) {
			Calculator calculator = new Calculator();
			Scanner sc = new Scanner(System.in);
			calculator.setStr();
			if (calculator.getStr().equals("q"))
				break;
			if (calculator.inputIsValid()) {
				calculator.calculate(calculator.isRoman());
				System.out.println("Answer is: " + calculator.getRes());
			} else {
				System.out.println("Your input is invalid!");
			}
			System.out.println("To quit the program enter q");
		}
	}
}
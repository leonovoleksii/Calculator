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
		char charr[] = getStr().toCharArray();
		Operand operand1 = new Operand(charr);
		str = arrToStr(charr);
		Operator operator = new Operator(str);
		str = str.substring(1, str.length());
		charr = str.toCharArray();
		Operand operand2 = new Operand(charr);
		str = arrToStr(charr);
		switch (operator.getValue()){
			case '+':
				result = operand1.getValue() + operand2.getValue();
				break;
			case '-':
				result = operand1.getValue() - operand2.getValue();
				break;
			case '*':
				result = operand1.getValue() * operand2.getValue();
				break;
			case '/':
				if (operand2.getValue() == 0) {
					System.out.println("Can't divide by zero!");
					break;
				}
				result = (float)operand1.getValue() / (float)operand2.getValue();
				break;
		}
	}
	public static String arrToStr(char[] charr) {
		String s = "";
		for (int i = 0; i < charr.length; i++) {
			if (charr[i] == Character.MIN_VALUE)
				continue;
			s += (charr[i]);
		}
		return s;
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setStr();
		calculator.calculate();
		System.out.println(calculator.getRes());
	}
}
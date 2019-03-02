import java.util.Scanner;

public class Calculator {
	private String str;
	private double result;
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
	public boolean inputIsValid() {
		boolean arabic =false, roman = false;
		String s = getStr();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'I' || c == 'V' || c == 'X') 
				roman = true;
			else if ((int)c >= (int)'0' && (int)c <= (int)'9')
				arabic = true;
		}
		return (arabic^roman);
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello! I am calculator! What would you like to calculate?");
		while (true) {
			calculator.setStr();
			if (calculator.inputIsValid()) {
				calculator.calculate();
				System.out.println("Answer is: " + calculator.getRes());
			} else {
				System.out.println("Your input is invalid!");
			}
			System.out.println("Would you like to try again?(Print y or Y to continue)");
			String answer = sc.next();
			if (!answer.equals("y") && !answer.equals("Y"))
				break;
		}
	}
}
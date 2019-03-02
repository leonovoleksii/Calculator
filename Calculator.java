import java.util.Scanner;

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
	public void calculate() {
		char charr[] = getStr().toCharArray();
		int i = 0;
		while (i < charr.length) {
			Operator operator = new Operator(charr);
			while (i < charr.length && charr[i] == Character.MIN_VALUE)
				i++;
			char op = operator.getValue();
			System.out.println(op);
			Operand operand = new Operand(charr);
			System.out.println(operand.getValue());
			while (i < charr.length && charr[i] == Character.MIN_VALUE)
				i++;
			switch (op){
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
			if (c == 'I' || c == 'V' || c == 'X') 
				roman = true;
			else if ((int)c >= (int)'0' && (int)c <= (int)'9')
				arabic = true;
		}
		return (arabic^roman);
	}

	public static void main(String[] args) {
		System.out.println("Hello! I am calculator! What would you like to calculate?");
		while (true) {
			Calculator calculator = new Calculator();
			Scanner sc = new Scanner(System.in);
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
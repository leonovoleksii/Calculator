public class Operator {
	private char value;
	public Operator(String str) {
		value = str.charAt(0);
	}
	public char getValue() {
		return value;
	}

	public static void main(String[] args) {
		String str = "+1234";
		Operator operator = new Operator(str);
		System.out.println(operator.getValue());
	}
}
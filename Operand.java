public class Operand {
	private int value;
	public Operand(char[] str) {
		if (str[0] == 'I' || str[0] == 'V' || str[0] == 'X') {
			RomanNumber number = new RomanNumber(str);
			value = number.getValue();
		} else {
			ArabicNumber number = new ArabicNumber(str);
			value = number.getValue();
		}
	}
	
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		String str = "123*345";
		Operand operand = new Operand(str.toCharArray());
		System.out.println(operand.getValue());
	}
}
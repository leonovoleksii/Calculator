public class ArabicNumber {
	private int value;
	public ArabicNumber(char[] str) {
		int i = 0;
		while ((i < str.length) && !(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')) {
			value = value * 10 + (int)str[i] - (int)'0';
			str[i] = Character.MIN_VALUE;
			i++;
		}
	}
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		ArabicNumber num = new ArabicNumber("123".toCharArray());
		System.out.println(num.getValue());
	}
}
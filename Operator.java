public class Operator {
	private char value = '0';
	public Operator(char[] charr) {
		int i = 0;
		while (i < charr.length && charr[i] == Character.MIN_VALUE)
			i++;
		if (i < charr.length && (charr[i] == '+' || charr[i] =='-')) {
			value = charr[i];
			charr[i] = Character.MIN_VALUE;
		}
	}
	public char getValue() {
		return value;
	}

	public static void main(String[] args) {
		String str = "+1234";
		Operator operator = new Operator(str.toCharArray());
		System.out.println(operator.getValue());
	}
}
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
		char[] charr = {Character.MIN_VALUE, Character.MIN_VALUE, '+', 'I', 'I', '*', 'I', 'I', 'I', '/', 
		'I', 'V', '+', 'V', 'I', 'I', '*', 'X', 'V'};
		Operator operator = new Operator(charr);
		System.out.println(operator.getValue());
		System.out.println(charr);
	}
}
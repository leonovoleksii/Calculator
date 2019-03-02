public class Operand {
	private double value = 1;
	public Operand(char[] str) {
		if (str[0] == 'I' || str[0] == 'V' || str[0] == 'X') {
			RomanNumber number = new RomanNumber(str);
			value = number.getValue();
		} else {
			ArabicNumber number = new ArabicNumber(str);
			char sgn = sign(str);
			if (sgn == '+' || sgn == '-' || sgn == '0') {
				value = number.getValue();
			} else {
				switch(sgn) {
					case '*':
						value = number.getValue() * (new Operand(str)).getValue();
						break;
					case '/':
						value = (double)number.getValue() / (double)(new Operand(str)).getValue();
						break;
				}
			}
		}
	}
	
	public double getValue() {
		return value;
	}

	public static char sign(char[] str) {
		char sgn = '0';
		int i = 0;
		while (i < str.length) {
			char c = str[i];
			if (sgn == '0' && (c == '*' || c == '/' || c == '+' || c == '-')) {
				sgn = c;
				if (c == '*' || c == '/') {
					str[i] = Character.MIN_VALUE;
				}
			}
			i++;
		}
		return sgn;
	}

	public static void main(String[] args) {
		String str = "123*123/2";
		Operand operand = new Operand(str.toCharArray());
		System.out.println(operand.getValue());
	}
}
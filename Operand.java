public class Operand {
	private double value = 0;
	public Operand(char[] str) {
		if (str[0] == 'I' || str[0] == 'V' || str[0] == 'X') {
			RomanNumber number = new RomanNumber(str);
			value = number.getValue();
		} else {
			ArabicNumber number = new ArabicNumber(str);
			value = number.getValue();
			System.out.println(number.getValue());
			char sgn = sign(str);
			while (sgn != '-' && sgn != '+' && sgn != '0') {
				ArabicNumber number2 = new ArabicNumber(str);
				System.out.println(number2.getValue());
				switch(sgn) {
					case '*':
						value *= number2.getValue();
						break;
					case '/':
						value /= number2.getValue();
						break;
				}
				sgn = sign(str);
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
		String str = "123/2*356*2/4/4";
		Operand operand = new Operand(str.toCharArray());
		System.out.println(operand.getValue());
	}
}
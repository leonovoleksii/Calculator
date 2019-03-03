package bin;

//operand is the result of multiplication or division
public class Operand {
	private double value = 0;
	public Operand(char[] str, boolean isRoman) {
		//if numbers are in roman format act like roman number
		if (isRoman) {
			RomanNumber number = new RomanNumber(str);
			value = number.getValue();
			char sgn = sign(str);
			while (sgn != '-' && sgn != '+' && sgn != '0') {
				number = new RomanNumber(str);
				switch(sgn) {
					case '*':
						value *= number.getValue();
						break;
					case '/':
						value /= number.getValue();
						break;
				}
				sgn = sign(str);
			}
		} else { //if numbers are in arabic format act like roman number
			ArabicNumber number = new ArabicNumber(str);
			value = number.getValue();
			char sgn = sign(str);
			while (sgn != '-' && sgn != '+' && sgn != '0') {
				number = new ArabicNumber(str);
				switch(sgn) {
					case '*':
						value *= number.getValue();
						break;
					case '/':
						value /= number.getValue();
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
		Operand op = new Operand("II*III/IV+VII*XV".toCharArray(), true);
		System.out.println(op.getValue());
	}
}
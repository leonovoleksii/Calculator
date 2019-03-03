package bin;

public class Num {
	private int value;
	protected char[] str;
	public int getValue() {return value;}
	public int next() {return value;}
	public char sign() {
		char sgn = '0';
		int i = 0;
		while (i < str.length) {
			char c = str[i];
			if (sgn == '0' && (c == '*' || c == '/' || c == '+' || c == '-')) {
				sgn = c;
				if (c == '*' || c == '/')
					str[i] = Character.MIN_VALUE;
			}
			i++;
		}
		return sgn;
	}
}
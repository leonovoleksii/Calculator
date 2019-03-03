package bin;

public class ArabicNumber extends Num {
	private int value;
	private char[] str;
	public ArabicNumber(char[] str) {
		this.str = str;
		super.str = str;
		value = 0;
	}
	public int next() {
		value = 0;
		int i = 0;
		//skip all void characters
		while (i < str.length && str[i] == Character.MIN_VALUE)
			i++;
		//create number until found operator or the end of line
		while ((i < str.length) && !(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')) {
			value = value * 10 + (int)str[i] - (int)'0';
			//delete digit
			str[i] = Character.MIN_VALUE;
			i++;
		}
		return value;
	}

	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		char[] charr = "123+1223-1234".toCharArray();
		ArabicNumber num = new ArabicNumber(charr);
		System.out.println(num.next());
		System.out.println(num.sign());
		System.out.println(num.next());
		System.out.println(num.sign());
		System.out.println(num.next());
		System.out.println(num.sign());

	}
}
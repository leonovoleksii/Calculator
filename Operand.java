public class Operand {
	private int value;
	public Operand(char[] str) {
		if (str[0] == 'I' || str[i] == 'V' || str[i] == 'X') {
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

	public static String arrToStr(char[] charr) {
		String s = "";
		for (int i = 0; i < charr.length; i++) {
			s += (charr[i]);
		}
		return s;
	}

	public static void main(String[] args) {
		String str = "123*345";
		char[] arr = new char[str.length()];
		arr = str.toCharArray();
		Operand operand = new Operand(arr);
		str = arrToStr(arr);
		System.out.println(str);
		System.out.println(operand.getValue());
	}
}
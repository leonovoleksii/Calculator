public class Operand {
	private int value;
	public Operand(char[] str) {
		int i = 0;
		while (!(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')) {
			value = value * 10 + (int)str[i] - (int)'0';
			str[i] = Character.MIN_VALUE;
			i++;
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
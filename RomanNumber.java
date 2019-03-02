public class RomanNumber {
	private int value;
	public RomanNumber(char[] str) {
		int i = 0;
		while ((i < str.length) && !(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')) {
			switch(str[i]) {
				case 'I':
					if (i + 1 < str.length)
						if (str[i + 1] == 'V') {
							value += 4;
							i++;
						} else if (str[i + 1] == 'X') {
							value += 9;
							i++;
						} else {
							value += 1;
						}
					else {
						value += 1;
					}
					break;
				case 'V':
					value += 5;
					break;
				case 'X':
					value += 10;
					break;
			}
			str[i] = Character.MIN_VALUE;
			i++;
		}
	}
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		RomanNumber num = new RomanNumber("X".toCharArray());
		System.out.println(num.getValue());
	}
}
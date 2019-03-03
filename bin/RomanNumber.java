package bin;

public class RomanNumber {
	private int value;
	public RomanNumber(char[] str) {
		int i = 0;
		//skip all void characters
		while (i < str.length && str[i] == Character.MIN_VALUE)
			i++;
		//create number until found operator or the end of line
		while (i < str.length && !(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')) {
			switch(str[i]) {
				case 'I': 
					value += 1;
					//delete digit
					str[i] = Character.MIN_VALUE;
					if (i + 1 < str.length) {
						if (str[i + 1] == 'V') {
							value += 3;
							//delete digit
							str[i + 1] = Character.MIN_VALUE;
							i++;
						} else if (str[i + 1] == 'X') {
							value += 8;
							//delete digit
							str[i + 1] = Character.MIN_VALUE;
							i++;
						}
					}
					i++;
					break;
				case 'V':
					//delete digit
					str[i] = Character.MIN_VALUE;
					i++;
					value += 5;
					break;
				case 'X':
					//delete digit
					str[i] = Character.MIN_VALUE;
					i++;
					value += 10;
					break;
			}
		}
	}
	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		char[] charr = "IV".toCharArray();
		RomanNumber num = new RomanNumber(charr);
		System.out.println(num.getValue());
		System.out.println(charr);
	}
}
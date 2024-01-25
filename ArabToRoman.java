public class ArabToRoman {
	public static String convert(int arab) {
		if (arab > 3999 || arab == 0) {
			return "Unrepresentable Value";
		}
		String numeral = "";
		String[] numeralRange = new String[] {"M", "", ""};
		numeral += getDigit(arab/1000, numeralRange);
		arab = arab % 1000;
		numeralRange = new String[] {"C", "D", "M"};
		numeral += getDigit(arab/100, numeralRange);
		arab = arab % 100;
		numeralRange = new String[] {"X", "L", "C"};
		numeral += getDigit(arab/10, numeralRange);
		arab = arab % 10;
		numeralRange = new String[] {"I", "V", "X"};
		numeral += getDigit(arab, numeralRange);
		return numeral;
	}

	// Returns numeral based on digit
	public static String getDigit(int digit, String[] numRange) {
		String numeral = "";
		switch (digit) {
			case 1:
				numeral = numRange[0];
				break;
			case 2:
				numeral = numRange[0] + numRange[0];
				break;
			case 3:
				numeral = numRange[0] + numRange[0] + numRange[0];
				break;
			case 4:
				numeral = numRange[0] + numRange[1];
				break;
			case 5:
				numeral = numRange[1];
				break;
			case 6:
				numeral = numRange[1] + numRange[0];
				break;
			case 7:
				numeral = numRange[1] + numRange[0] + numRange[0];
				break;
			case 8:
				numeral = numRange[1] + numRange[0] + numRange[0] + numRange[0];
				break;
			case 9:
				numeral = numRange[0] + numRange[2];
				break;
			case 10:
				numeral = numRange[2];
				break;
		}
		return numeral;
	}
}
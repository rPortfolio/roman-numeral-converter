class RomanToArab {
	static final String[] numerals = {"I", "V", "X", "L", "C", "D", "M"};
	
	public static int convert(String numeral) {
		int arab = 0;
		int previousDegree = 0;
		for (int i = numeral.length() - 1; i >= 0; i--) {
			int value = getNumeralValue(numeral.substring(i, i + 1));
			int degree = getNumeralDegree(numeral.substring(i, i + 1));
			if (value == -1) {
				return -1;
			}
			if (degree >= previousDegree) {
				arab += value;
			} else {
				if (degree % 2 != 0 || degree - previousDegree < -2) {
					return -1;
				}
				arab -= value;
			}
			previousDegree = degree;
		}
		return arab;
	}

	// Returns value of numeral if input is numeral, else -1
	public static int getNumeralValue(String numeral) {
		if (numeral.equals("I")) {
			return 1;
		} else if (numeral.equals("V")) {
			return 5;
		} else if (numeral.equals("X")) {
			return 10;
		} else if (numeral.equals("L")) {
			return 50;
		} else if (numeral.equals("C")) {
			return 100;
		} else if (numeral.equals("D")) {
			return 500;
		} else if (numeral.equals("M")) {
			return 1000;
		}
		return -1;
	}
	
	// Returns degree of numeral 0 through 6 if input is a numeral, else -1
	// Exists to check what the current highest numeral is
	public static int getNumeralDegree(String numeral) {
		for (int i = 0; i < numerals.length; i++) {
			if (numeral.equals(numerals[i])) {
				return i;
			}
		}
		return -1;
	}
}
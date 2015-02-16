import java.util.HashMap;

class FizzBuzz {

	// used in getOutputFromLookup()
	private static HashMap<Integer, String> outputLookup;
	static {
		outputLookup = new HashMap<Integer, String>();
		outputLookup.put(1, "fizz");
		outputLookup.put(2, "buzz");
		outputLookup.put(3, "fizzbuzz");
	}

	public static void main(String[] args) {
		System.out.println("FizzBuzz");
		for (int number = 1; number <= 100; number++) {
			System.out.print(getOutput(number) + "  ");
		}
		System.out.println();

		System.out.println("FizzBuzz - production alt");
		for (int number = 1; number <= 100; number++) {
			System.out.print(getOutputProduction(number) + "  ");
		}
		System.out.println();
		
		System.out.println("FizzBuzz - from lookup");
		for (int number = 1; number <= 100; number++) {
			System.out.print(getOutputFromLookup(number) + "  ");
		}
		System.out.println();
	}
	
	static String getOutput(Integer number) {
		String output = new String();
		String fizzbuzz = new String();
				
		// check for special case
		fizzbuzz = "";
		if (number % 3 == 0) {
			// replace
			fizzbuzz += "fizz";
		}
		
		if (number % 5 == 0) {
			fizzbuzz += "buzz";
		}

		if (fizzbuzz.isEmpty()) {
			// default number
			return number.toString();
		} else {
			return fizzbuzz;
		}
	}
	
	static String getOutputProduction(Integer number) {
		String output = new String();
		Boolean isFizz = false;
		Boolean isBuzz = false;
		
		// set conditions
		if (number %3 == 0) {
			isFizz = true;
		}
		
		if (number %5 == 0) {
			isBuzz = true;
		}
		
		// check conditions
		if (isFizz && isBuzz) {
			output = "fizzbuzz";
		} else if (isFizz) {
			output = "fizz";
		} else if (isBuzz) {
			output = "buzz";
		} else {
			output = number.toString();
		}

		return output;
	}
	
	static String getOutputFromLookup(Integer number) {
		// if do not want to always save string
		// then special check 0 case in below return
		outputLookup.put(0, number.toString());
		int count = 0;
		
		// cumulative bitmap "counter"
		if (number % 3 == 0) {
			count = count | 0x1;
		}
		
		if (number % 5 == 0) {
			count = count | 0x2;
		}
		
		// with static map would need to special check 0 case
		return outputLookup.get(count);
	}

}
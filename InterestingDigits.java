public class InterestingDigits {
	public int[] digits(int base) {

		int[] test;
		String nums = "";

		Integer digit = 2;
		Integer multiple = 1;
		Integer count = 1;

		int index = 0;
		while (digit <= base - 1) {
			while (multiple <= 999) {
				multiple = digit * count;
				count++;
				if (isInteresting(multiple, digit, base) == true) {
					continue;
				} else {
					break;
				}
			}

			if (isInteresting(multiple, digit, base) == true) {

				nums += digit.toString();
				if (digit < base - 1) {
					nums += ",";
				}

			}

			multiple = 1;
			count = 1;
			digit++;
		}

		String[] tokens = nums.split(",");
		test = new int[tokens.length];

		for (String t : tokens) {
			test[index] = Integer.parseInt(t);
			index++;
		}

		return test;
	}

	public boolean isInteresting(int num, int digit, int base) {
		boolean interesting = false;
		int sum = 0;
		while (num > 0) {
			sum = sum + num % base;
			num = num / base;
		}
		// System.out.println("sum "+sum);
		if (sum % digit == 0) {
			interesting = true;
		} else {
			interesting = false;
		}

		return interesting;
	}
}

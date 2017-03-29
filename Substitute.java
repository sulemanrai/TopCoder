public class Substitute {
	public int getValue(String key, String code) {

		String tmp = "";
		Integer result = 0;
		Integer tmp1 = 0;
		for (int j = 0; j < key.length(); j++) {
			System.out.println("" + key.charAt(j));
			for (int i = 0; i < code.length(); i++) {
				System.out.println("" + code.charAt(i));
				if (code.charAt(i) == key.charAt(j) && j == key.length() - 1) {
					if (tmp != "") {
						result = Integer.parseInt(tmp);
					}
					tmp1 = result % 10;
					result = (result / 10) * 100 + tmp1;
				} else if (code.charAt(i) == key.charAt(j)) {
					tmp += (j + 1);
				}
			}
		}
		return result;
	}
}
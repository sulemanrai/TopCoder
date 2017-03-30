public class Substitute {
	public int getValue(String key, String code) {

		String tmp = "";
		char lastcharacter = key.charAt(key.length() - 1);
		for (int j = 0; j < code.length(); j++) {
			for (int i = 0; i < key.length(); i++) {
				if ((code.charAt(j) == key.charAt(i))) {					
					if (code.charAt(j) == lastcharacter) {
						tmp += "0";
					} else {
						tmp = tmp + (i + 1);
					}
				}
			}
		}

		Integer result = Integer.parseInt(tmp);
		return result;
	}
}
public class Lexer {
	int number_consumed = 0;
	String[] stringArrayconsumed;

	public String[] tokenize(String[] tokens, String input) {
		stringArrayconsumed = new String[input.length()];
		String[] consumed = {};
		String[] sortedtokens = {};
		if (tokens.equals(null)) {
			return stringArrayconsumed;
		} else {
			sortedtokens = SortAndFindMaxToken(tokens);
			//System.out.println(Arrays.toString(sortedtokens));
			while (input.length() != 0) {				
				input = check_if_token_exists(sortedtokens, input);
				//System.out.println((input));
				if (input.length() != 0) {
					input = input.substring(1);
				}
				//System.out.println("input"+input);
			}

			consumed = new String[number_consumed];			
			for (int i = 0; i < number_consumed; i++) {
				consumed[i] = stringArrayconsumed[i];
			}
			return consumed;
		}
	}

	public String[] SortAndFindMaxToken(String[] tokens) {
		String[] sortedtokens = {};
		for (int i = (tokens.length - 1); i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (tokens[j - 1].length() < tokens[j].length()) {
					String temp = tokens[j - 1];
					tokens[j - 1] = tokens[j];
					tokens[j] = temp;
				}
			}
		}

		sortedtokens = tokens;		
		return sortedtokens;
	}


	String check_if_token_exists(String[] tokens, String input) {
		boolean token_exists = false;
		String output = "";
		while (input.length() != 0) {
			for (int i = 0; i < tokens.length; i++) {
				if (input.length() >= tokens[i].length()) {
					token_exists = (input.substring(0, tokens[i].length()).equals(tokens[i]));					
					if (token_exists == true) {
						stringArrayconsumed[number_consumed] = tokens[i];
						number_consumed++;
						input = input.substring(tokens[i].length());
						output = input;						
						break;
					} else {
						output = input;
					}
				} else {
					token_exists = false;
				}
				//System.out.println("tokenexits "+token_exists);
			}
			if (token_exists == false) {
				break;
			}
			
		}
		return output;
	}
}

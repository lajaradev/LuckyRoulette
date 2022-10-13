

public class Character {
	
	public static String emptySentence (String randomSentence) {
		
		String emptyRandomSentence = randomSentence
				.replace("a", "_").replace("b", "_").replace("c", "_").replace("d", "_").replace("e", "_")
				.replace("f", "_").replace("g", "_").replace("h", "_").replace("i", "_").replace("j", "_")
				.replace("k", "_").replace("l", "_").replace("m", "_").replace("n", "_").replace("o", "_")
				.replace("p", "_").replace("q", "_").replace("r", "_").replace("s", "_").replace("t", "_")
				.replace("u", "_").replace("v", "_").replace("w", "_").replace("x", "_").replace("y", "_")
				.replace("z", "_");
	
		return emptyRandomSentence;
				
	}
	
	public static String isVowel(String letter) {
		
		if( letter.equals("a") || letter.equals("e") || letter.equals("i") || 
			letter.equals("o") || letter.equals("u") )  {
			return letter;
		}
		else {
			return null;
		}
			
	}
	
	public static String isConsonant(String letter) {
		
		if( letter.equals("b") || letter.equals("c") || letter.equals("d") || 
			letter.equals("f") || letter.equals("g") || letter.equals("h") ||
			letter.equals("j") || letter.equals("k") || letter.equals("l") || 
			letter.equals("m") || letter.equals("n") || letter.equals("p") ||
			letter.equals("q") || letter.equals("r") || letter.equals("s") ||
			letter.equals("t") || letter.equals("v") || letter.equals("w") ||
			letter.equals("x") || letter.equals("y") || letter.equals("z"))  {
			return letter;
		}
		else {
			return null;
		}
			
	}
	
	
	

	
}

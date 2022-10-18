import java.text.Normalizer;
import java.util.ArrayList;

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
	
	public static ArrayList<Integer> index (String letter, String randomSentence) {
		
		// GET INDEXS OF MY LETTER
		
		char l = letter.charAt(0);
		char[] character = randomSentence.toCharArray();
		ArrayList<Integer> arl = new ArrayList<Integer>();
		
		for(int i = 0; i < character.length; i ++) {
			if(character[i] == l) { // System.out.println("character: /" + l + "/ index "+ i);	
				arl.add(i);
			}
		}		
		//System.out.println("Arraylist contains: " + arl.toString()); 
		return arl;
	}
	
	public static String newletter (String letter, String randomSentence, String emptyRandomSentence, String newletterinSentence) {
		
		ArrayList<Integer> arl = new ArrayList<Integer>();
		char[] character = randomSentence.toCharArray();
		
		arl = index(letter, randomSentence);
		
		for(int i = 0; i < character.length; i ++) { // size array char of the randomSentence
			for(int j = 0; j < arl.size(); j ++) { // size array int Index
				if(i == arl.get(j)) { // Compare index of the sentence with int of the arrayIndex 
					newletterinSentence = newletterinSentence.substring(0,i) + letter + newletterinSentence.substring(i + 1);				
				} // substring: copy from index 0 to i + letter + copies the rest
			}
		}			
	
		return newletterinSentence;
				
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
	
	
	
	
	public static String stripAccents(String s) 
	{
	    /*Salvamos las ñ*/
	    s = s.replace('ñ', '\001');
	    s = s.replace('Ñ', '\002');
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    /*Volvemos las ñ a la cadena*/
	    s = s.replace('\001', 'ñ');
	    s = s.replace('\002', 'Ñ');

	    return s;
	}   
	

	
}

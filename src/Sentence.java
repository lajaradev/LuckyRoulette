public class Sentence {
	
	static final String sentence1 = "you ony fail when you stop trying";
	static final String sentence2 = "well done is better than well said";
	static final String sentence3 = "try ir again, fail again, fail better";
	static final String sentence4 = "once you choose hope, anything's possible";
	static final String sentence5 = "the secret of your success is determined by your daily diary";
	static final String sentence6 = "if opportunity doesn't knock, build a door";
	static final String sentence7 = "success in management requires learning as fast as the world is changing";
	static final String sentence8 = "dream as if you'll live forever, live as if you'll die today";
	static final String sentence9 = "if you have everything under control, you're not moving fast enough";
	
	
	public static String giveMeSentence(String LEVEL) {
		
		String randomSentence = null;
		int number = (int)(Math.random()*3+1);
		System.out.println("Number: " + number);
		
		if(LEVEL.equals("expert")) {
			System.out.println("Expert Mode\n");
			if(number == 1) {
				randomSentence = Sentence.sentence7;
			}
			else if(number == 2) {
				randomSentence = Sentence.sentence8;
			}
			else {
				randomSentence = Sentence.sentence9;
			}		
			
		}
		else if(LEVEL.equals("medium")) {
			System.out.println("Medium Mode\n");
			if(number == 1) {
				randomSentence = Sentence.sentence4;
			}
			else if(number == 2) {
				randomSentence = Sentence.sentence5;
			}
			else {
				randomSentence = Sentence.sentence6;
			}
		}
		
		else{ 
			System.out.println("Rookie Mode\n");
			
			if(number == 1) {
				randomSentence = Sentence.sentence1;
			}
			else if(number == 2) {
				randomSentence = Sentence.sentence2;
			}
			else {
				randomSentence = Sentence.sentence3;
			}	
		}
		return randomSentence;
	}
	
}

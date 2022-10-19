public class Sentence {
	
	private static final String EXPERT 	   = "expert";
	private static final String EXPERTMODE = "Expert Mode";
	private static final String MEDIUM     = "medium";
	private static final String MEDIUMMODE = "Medium Mode";
	private static final String ROOKIEMODE = "Rookie Mode";
	
	private static final String sentence1  = "you ony fail when you stop trying";
	private static final String sentence2  = "well done is better than well said";
	private static final String sentence3  = "try ir again, fail again, fail better";
	private static final String sentence4  = "once you choose hope, anything's possible";
	private static final String sentence5  = "the secret of your success is determined by your daily diary";
	private static final String sentence6  = "if opportunity doesn't knock, build a door";
	private static final String sentence7  = "success in management requires learning as fast as the world is changing";
	private static final String sentence8  = "dream as if you'll live forever, live as if you'll die today";
	private static final String sentence9  = "if you have everything under control, you're not moving fast enough";
	
	
	public static String giveMeSentence(String LEVEL) {
		
		String randomSentence = null;
		int number = (int)(Math.random()*3+1);
		
		if(LEVEL.equals(EXPERT)) {
			System.out.println(EXPERTMODE);
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
		else if(LEVEL.equals(MEDIUM)) {
			System.out.println(MEDIUMMODE);
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
			System.out.println(ROOKIEMODE);
			
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

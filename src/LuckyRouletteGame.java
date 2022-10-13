
import java.util.Scanner;

public class LuckyRouletteGame {
	
	Scanner sc = new Scanner(System.in);
	
	public void startGame(String LEVEL){
		
		System.out.println("Juego iniciado");
		Player player = new Player();
		Character character = new Character();
		
		
		String randomSentence = Sentence.giveMeSentence(LEVEL);
		System.out.println(randomSentence);
		
		
		String emptyRandomSentence = Character.emptySentence(randomSentence);
		System.out.println(emptyRandomSentence);
		
		continuePlaying(LEVEL);
		
		System.out.print("FIN");
		
	}
	
	public void continuePlaying(String LEVEL){
		
		int MAXattempt;
		if(LEVEL.equals("expert")) {
			MAXattempt = 5;
		}
		else if(LEVEL.equals("medium")) {
			MAXattempt = 8;
		}
		else {
			MAXattempt = 10;
		}
		
		for(int attempt = 1; attempt < MAXattempt + 1; attempt ++) {
			
			System.out.println("ATTEMPT " + attempt);
			System.out.print("Enter a consonant: ");
			String letter = sc.nextLine();
			String validateChar = Character.isConsonant(letter);
			System.out.println("Consonant: " + validateChar);
			
		}
		
	}

	public static String showResultInfo(String randomSentence) {
		
		
		
		return randomSentence;
		
	}
	
}

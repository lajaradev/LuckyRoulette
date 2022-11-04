package es.poo.lucky_roulette;
import java.util.Scanner;

public class LuckyRouletteGame {
	
	private static final String INI1 			= "ROUND";
	private static final String INI2 			= "STARTED";
	private static final String END 			= "END";
	private static final String SPACE         	= " ";
	private static final String ATTEMPT 		= "ATTEMPT: ";
	private static final String ENTERCONSONANT 	= "Enter a consonant: ";
	private static final String ENTERVOWEL 		= "Enter a vowel: ";
	private static final String NOTIS 			= "The letter is not in the sentence";
	private static final String COMPARESENTENCE	= "What's the sentence?";
	private static final String WINNER  		= "Congratulation, you have won";
	private static final String LOSER  			= "Sorry, you lost";
	private static final String SCORE  			= "Roll Score: ";
	private static final String ROUNDSCORE  	= "TOTAL SCORE: ";
	private static final String ROUND         	= "Rounds: ";
	private static final String LEVEL         	= "Level: (rookie / medium / expert)";
	private static final String BUYVOWEL        = "Do you want to buy a vowel?";
	private static final String SOLVE        	= "Do you want to solve the sentence?";
	private static final String AFFIRMA	 	  	= "yes or no";
	private static final String YES	 	  		= "yes";
	
	private static Scanner scanIn = new Scanner(System.in);
	
	public static String screen(String str) {
		
		System.out.println(str);
		return(scanIn.nextLine());
		
	}
	
	/* get the number of round and the level */
	public static Round roundData() { // COLLECT THE VALUE
		
		int intRound = Integer.parseInt(screen(ROUND));
		String strLevel = screen(LEVEL);
		
		Round round = new Round();
		
		round.setRoundNumber(intRound);	 // NUMBER ROUNDS
		round.setLevel(strLevel); // LEVEL
		
		return round; // RETURN OBJECT round
	}

	/* START THE GAME !*/
	public void startGame(){
		
		Round round = roundData(); // TAKE MY OBJECT round
		
		String randomSentence;
		String emptyRandomSentence;
		String newletterinSentence;
		String validatedLetter;
		String letter;
		String buyVowel;
		
		int score = 0;
		int attempt = 1;
		int scoreAttempt = 0;
		int scoreRound = 0;
		int numLetters = 0;
		
		boolean solve = false;
		
		/* Loop for all rounds 
		 * In each round it gives us a random phrase, and encrypt it
		 * */
		for(int i = 1; i < round.getRoundNumber() + 1; i ++) {
			
			randomSentence = Sentence.giveMeSentence(round.getLevel());
			emptyRandomSentence = Character.emptySentence(randomSentence);			
			newletterinSentence = emptyRandomSentence;
			
			System.out.println(INI1 + SPACE + i + SPACE + INI2);
			System.out.println(randomSentence);
			System.out.println(emptyRandomSentence);
			System.out.println(SPACE);
			
			/* In this loop we process the number of attempts that the player has according to the level entered */
			while(attempt < round.numberAttemps() + 1 && solve == false) {
				
					score = Thrower.throwScore(); 
					
					/* Start by introducing a consonant */
					do {						
						System.out.println(ATTEMPT + attempt);
						System.out.println(SCORE + score);
						System.out.print(ENTERCONSONANT);
						
						letter = scanIn.nextLine();
						validatedLetter = Character.isConsonant(letter);
						
					} while(validatedLetter == null);		
					
					/* Check if the sentence has the consonant entered to assign it to the encrypted phrase and give the player the points */
					if(randomSentence.contains(letter)) {		
						
						newletterinSentence = Character.newletter(letter, randomSentence, emptyRandomSentence, newletterinSentence);
						
						numLetters = Character.countLetter(letter, randomSentence);
						scoreAttempt = numLetters * score;
						
						if(score == 0){
							scoreRound = 0;
						}
						else{
						  scoreRound += scoreAttempt;
						}
						
						System.out.println(newletterinSentence);
						System.out.println(SCORE + scoreAttempt + SPACE + ROUNDSCORE + scoreRound);
						
					}
					else {
						System.out.println(NOTIS);
					}
					
					/* Add an attempt to the round */
					attempt ++;
					
					/* If player has enough points, we offer the player to buy a vowel */
					if(scoreRound > 30) {
						System.out.println(BUYVOWEL);
						buyVowel = screen(AFFIRMA);
						if(buyVowel.compareTo(YES) == 0) {
							do {
								System.out.print(ENTERVOWEL);
								letter = scanIn.nextLine();
								validatedLetter = Character.isVowel(letter);
								
							} while(validatedLetter == null);
							
							/* If the vowel is present, we add it to the encrypted sentence */
							if(randomSentence.contains(letter)) {						
								newletterinSentence = Character.newletter(letter, randomSentence, emptyRandomSentence, newletterinSentence);
								System.out.println(newletterinSentence);
							}
							else {
								System.out.println(NOTIS);
							}
							scoreRound -= 30;
							System.out.println(ROUNDSCORE + scoreRound);
						}
					}
					
					/* Ask if you want to solve the sentence */
					System.out.println(SOLVE);
					buyVowel = screen(AFFIRMA);
					if(buyVowel.compareTo(YES) == 0) {
						winnerORloser(randomSentence);
						solve = true;
					}		
				}
			
			System.out.println(END);
		}
			
	}
	
	/* Method to check if the sentence is correct */
	public void winnerORloser(String randomSentence) {
		
		String validateSentence;
		
		System.out.println(COMPARESENTENCE);
		validateSentence = scanIn.nextLine();
	
		if(randomSentence.equals(validateSentence)) {
			System.out.println(WINNER);
		}
		else{
			System.out.println(LOSER);
			
		}
		
	}
		
}

	


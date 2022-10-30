package es.poo.lucky_roulette;
import java.util.InputMismatchException;
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
	private static final String INITIALSCORE  	= "Initial Score: ";
	private static final String LOWSCORE  		= "You don't have enough score (min 30) -> Your score is: ";
	private static final String CHECKNUMBER  	= "You haven't entered a number. Try again: ";
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
	
	public static Round roundData() { // COLLECT THE VALUE
		
		int intRound = Integer.parseInt(screen(ROUND));
		String strLevel = screen(LEVEL);
		
		Round round = new Round();
		
		round.setRoundNumber(intRound);	 // NUMBER ROUNDS
		round.setLevel(strLevel); // LEVEL
		
		return round; // RETURN OBJECT round
	}

	public void startGame(){
		
		Round round = roundData(); // TAKE MY OBJECT round
		
		String randomSentence;
		String emptyRandomSentence;
		String newletterinSentence;
		String validatedLetter;
		String letter;
		String buyVowel;
		
		int score = 0;
		int option = 0;
		int attempt = 1;
		int scoreAttempt = 0;
		int scoreRound = 0;
		int numLetters = 0;
		
		for(int i = 1; i < round.getRoundNumber() + 1; i ++) {
			
			randomSentence = Sentence.giveMeSentence(round.getLevel());
			emptyRandomSentence = Character.emptySentence(randomSentence);			
			newletterinSentence = emptyRandomSentence;
			
			System.out.println(INI1 + SPACE + i + SPACE + INI2);
			System.out.println(randomSentence);
			System.out.println(emptyRandomSentence);
			System.out.println(SPACE);
			
			while(attempt < round.numberAttemps() + 1) {
				
					score = Thrower.throwScore(); // 1. Throw
					
					do {						
						System.out.println(ATTEMPT + attempt);
						System.out.println(SCORE + score);
						System.out.print(ENTERCONSONANT);
						
						letter = scanIn.nextLine();
						validatedLetter = Character.isConsonant(letter);
						
					} while(validatedLetter == null);		
					
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
					
					attempt ++;
					
					// 2. Buy vowel
							
					if(scoreRound > 30) {
						System.out.println(BUYVOWEL);
						buyVowel = screen(AFFIRMA);
						if(buyVowel.compareTo(YES) == 0) {
							do {
								System.out.print(ENTERVOWEL);
								letter = scanIn.nextLine();
								validatedLetter = Character.isVowel(letter);
								
							} while(validatedLetter == null);
							
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
					
					System.out.println(SOLVE);
					buyVowel = screen(AFFIRMA);
					if(buyVowel.compareTo(YES) == 0) {
						winnerORloser(randomSentence);
						break; // exit if
						//return; //exit for
						//TODO INIT NEW ROUND (exit while)
					}		
				}
			
			System.out.println(END);
		}
			
	}
	
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

	


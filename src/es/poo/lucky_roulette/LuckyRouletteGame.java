package es.poo.lucky_roulette;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LuckyRouletteGame {
	
	private static final String INI1 			= "ROUND";
	private static final String INI2 			= "STARTED";
	private static final String END 			= "END";
	private static final String SPACE         	= " ";
	
	private static final String EXPERT 			= "expert";
	private static final String MEDIUM 			= "medium";
	private static final String ATTEMPT 		= "ATTEMPT: ";
	private static final String ENTERCONSONANT 	= "Enter a consonant: ";
	private static final String ENTERVOWEL 		= "Enter a vowel: ";
	private static final String NOTIS 			= "The letter is not in the sentence";
	private static final String OPTION 			= "Choose a option: ";
	private static final String OPTION1 		= "1. Throw";
	private static final String OPTION2 		= "2. Buy vowel";
	private static final String OPTION3 		= "3. Solve panel";
	private static final String OPTION4 		= "Invalid Character";
	private static final String COMPARESENTENCE	= "What's the sentence?";
	private static final String WINNER  		= "Congratulation, you have won";
	private static final String LOSER  			= "Sorry, you lost";
	private static final String SCORE  			= "Roll Score: ";
	private static final String ROUNDSCORE  	= "TOTAL SCORE: ";
	private static final String INITIALSCORE  	= "Initial Score: ";
	private static final String LOWSCORE  		= "You don't have enough score (min 30) -> Your score is: ";
	private static final String CHECKNUMBER   = "You haven't entered a number. Try again: ";
	
	Scanner sc = new Scanner(System.in);
	Scanner SC = new Scanner(System.in);
	
	Thrower throwScore = new Thrower();
	Character character = new Character();
	private int score = 0;
	
	public void startGame(String LEVEL, int ROUNDS){
		
		for(int i = 1; i < ROUNDS + 1; i ++) {
			
			System.out.println(INI1 + SPACE + i + SPACE + INI2);
			System.out.println(INITIALSCORE + score);
			System.out.println(SPACE);
			
			
			String randomSentence = Sentence.giveMeSentence(LEVEL);
			String emptyRandomSentence = Character.emptySentence(randomSentence);
			
			continuePlaying(LEVEL, randomSentence, emptyRandomSentence);
			
			System.out.println(END);
		}
		
	}
	
	public void continuePlaying(String LEVEL, String randomSentence, String emptyRandomSentence){
		
		String newletterinSentence = emptyRandomSentence;
		String validatedLetter;
		String letter;
		
		int MAXattempt;
		int option = 0;
		int attempt = 1;
		int scoreAttempt = 0;
		int scoreRound = 0;
		int numLetters = 0;
	
		if(LEVEL.equals(EXPERT)) {
			MAXattempt = 5;
		}
		else if(LEVEL.equals(MEDIUM)) {
			MAXattempt = 8;
		}
		else {
			MAXattempt = 10;
		}
		
		System.out.println(randomSentence);
		System.out.println(emptyRandomSentence);
		
		while(attempt < MAXattempt + 1) {
			
			System.out.println(SPACE);
			System.out.println(OPTION);
			System.out.println(OPTION1);
			System.out.println(OPTION2);
			System.out.println(OPTION3);
			
			try {
				option = SC.nextInt();
			}catch(InputMismatchException e) {
				System.out.println(CHECKNUMBER);
				SC.nextLine();
			}
			
			switch(option) {
				
				case 1: // 1. Throw
					
					score = Thrower.throwScore();
					
					do {						
						System.out.println(ATTEMPT + attempt);
						System.out.println(SCORE + score);
						System.out.print(ENTERCONSONANT);
						
						letter = sc.nextLine();
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
					break;
				
				case 2: // 2. Buy vowel
					
					if(scoreRound < 30) {
						System.out.println(LOWSCORE + scoreRound);
						break;
					}
					else {
						scoreRound -= 30;
						System.out.println(ROUNDSCORE + scoreRound);
					}
										
					do {
						System.out.print(ENTERVOWEL);
						letter = sc.nextLine();
						validatedLetter = Character.isVowel(letter);
						
					} while(validatedLetter == null);
					
					if(randomSentence.contains(letter)) {						
						newletterinSentence = Character.newletter(letter, randomSentence, emptyRandomSentence, newletterinSentence);
						System.out.println(newletterinSentence);
					}
					else {
						System.out.println(NOTIS);
					}
					
					break;
					
			
				case 3: // 3. Solve panel
					winnerORloser(randomSentence);
				return;
			
				default:
					System.out.println(OPTION4);
				break;
			}
			
		}
	}
	
public void winnerORloser(String randomSentence) {
		
		String validateSentence;
		
		System.out.println(COMPARESENTENCE);
		validateSentence = sc.nextLine();
	
		if(randomSentence.equals(validateSentence)) {
			System.out.println(WINNER);
			
		}
		else{
			System.out.println(LOSER);
			
		}
		
	}
		
}

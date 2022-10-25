package es.poo.lucky_roulette;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private static final String LUCKYROULETTE = "LUCKY ROULETTE BY SAMUEL LAJARA";
	private static final String SEPARATOR     = "-------------------------------";
	private static final String SPACE         = "";
	private static final String OPTION1       = "1. Sign in";
	private static final String OPTION2       = "2. Log in";
	private static final String OPTION3       = "3. Exit";
	private static final String OPTION4       = "4. test";
	private static final String DEFAULT       = "Wrong Number";
	private static final String ALIAS 		  = "Alias: ";
	private static final String PASSWORD      = "Password: ";
	private static final String PASSWORDMIN   = "Atleast 6 Characters";
	private static final String NAME 		  = "Name: ";
	private static final String DATE 		  = "Date: ";
	private static final String NOTNULL  	  = "Not Null";
	private static final String ROUND         = "Rounds: ";
	private static final String LEVEL         = "Level: (rookie / medium / expert)";
	private static final String CHECKNUMBER   = "You haven't entered a number. Try again: ";
	
	
	private static Scanner scanIn = new Scanner(System.in);
	private static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(LUCKYROULETTE);
		System.out.println(SEPARATOR);
		System.out.println(SPACE);
		
		Player player = new Player(); // CREATE OBJECT
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
		
		int option = 0;
		int ROUNDS = 0;
		boolean b = true;
		String LEVEL = null;
		
	
		do {
		
				System.out.println(OPTION1);
				System.out.println(OPTION2);
				System.out.println(OPTION3);	
				System.out.println(OPTION4);
				
				try {
					option = SC.nextInt();
				}catch(InputMismatchException e) {
					System.out.println(CHECKNUMBER);
					SC.nextLine();
				}
												
				switch(option) {
				
				case 1: // SIGN IN
					signInPlayer(player);
				break;
					
				case 2: // LOG IN
					logInPlayer(player);
				break;
					
				case 3: // EXIT 
					System.exit(0);
				break;
					
				case 4: // TEST
					gameData(round);
					LEVEL = round.getLevel();
					ROUNDS = round.getRoundNumber();
					game.startGame(LEVEL, ROUNDS);	
					
				break;
					
				default:
					System.out.println(DEFAULT);
				break;
				} // SWITCH END	
			
		}while(b);

		scanIn.close();	
	}
	
	private static String screen(String str) {
		
		System.out.println(str);
		return(scanIn.nextLine());
	}

	private static void signInPlayer(Player player) { // COLLECT THE VALUE
	
		
		do{ // ALIAS 
			player.setAlias(screen(ALIAS));
			if(player.getAlias().compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}
		}while(player.getAlias().compareTo(SPACE) == 0);
		
		do{ // PASSWORD 
			player.setPassword(screen(PASSWORD));
			if(player.getPassword().compareTo(SPACE) <= 5) {
				System.out.println(PASSWORDMIN);
			}
		}while(player.getPassword().compareTo(SPACE) <= 5);
		
		player.setName(screen(NAME)); // NAME 
		
		do{ // DATE  BIRTH 
			player.setDateBirth(screen(DATE));	
			
			if(player.getDateBirth().compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}			
		}while(player.getDateBirth().compareTo(SPACE) == 0); 
		
	}

	
	private static void gameData(Round round) { // COLLECT THE VALUE
		
		round.setRoundNumber(Integer.parseInt(screen(ROUND)));	 // NUMBER ROUNDS
		round.setLevel(screen(LEVEL)); // LEVEL
	}
	
	private static void logInPlayer(Player player) { 
				
		System.out.println("Alias " + player.getAlias());
		System.out.println("Password " + player.getPassword());
		
	}
		
	

}

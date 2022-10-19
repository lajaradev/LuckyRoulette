import java.util.Scanner;

public class Main {
	
	private static final String LUCKYROULETTE = "LUCKY ROULETTE BY SAMUEL LAJARA";
	private static final String SEPARATOR     = "-------------------------------";
	private static final String SPACE         = "";
	private static final String OPTION1       = "1. Play as a guest";
	private static final String OPTION2       = "2. Sign in";
	private static final String OPTION3       = "3. Log in";
	private static final String OPTION4       = "4. Exit";
	private static final String DEFAULT       = "Wrong Number";
	private static final String ALIAS 		  = "Alias: ";
	private static final String PASSWORD      = "Password: ";
	private static final String PASSWORDMIN   = "Atleast 6 Characters";
	private static final String NAME 		  = "Name: ";
	private static final String DATE 		  = "Date: ";
	private static final String NOTNULL  	  = "Not Null";
	private static final String ROUND         = "Rounds: ";
	private static final String LEVEL         = "Level: (rookie / medium / expert)";
	
	
	private static Scanner scanIn = new Scanner(System.in);
	private static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(LUCKYROULETTE);
		System.out.println(SEPARATOR);
		System.out.println(SPACE);
		
		Player player = new Player();
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
		
		int option = 0;
		int ROUNDS = 0;
		boolean b = true;
		String LEVEL = null;
		
		while(b) {
			
			System.out.println(OPTION1);
			System.out.println(OPTION2);
			System.out.println(OPTION3);	
			System.out.println(OPTION4);
			
			option = SC.nextInt();
			
		/*	if(validateNumber(option) != 0 ) {
				System.out.println("NUMERO CORRECTO");
			}
			else {
				System.out.println("INCORRECTO");
			}*/
			
			switch(option) {
				
				case 1: // PLAY AS A GUEST
					LEVEL = "rookie";
					ROUNDS = 3;
					game.startGame(LEVEL, ROUNDS);	
				break;
				
				case 2: // SIGN IN
					playerData(player, round);
					LEVEL = round.getLevel();
					ROUNDS = round.getRoundNumber();
					game.startGame(LEVEL, ROUNDS);	
				break;
				
				case 3: // LOG IN
					System.out.println("3. Log in");	
				break;
				
				case 4: // EXIT 
					System.exit(0);
				break;
				
				default:
					System.out.println(DEFAULT);
				break;
			}
		}	
		
		scanIn.close();	
	}
	
	private static String screen(String str) {
		
		System.out.println(str);
		return(scanIn.nextLine());
	}

	private static void playerData(Player player, Round round) { // COLLECT THE VALUE
	
		// ALIAS 
		do{
			player.setAlias(screen(ALIAS));
			if(player.getAlias().compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}
		}while(player.getAlias().compareTo(SPACE) == 0);
		
		// PASSWORD 
		do{
			player.setPassword(screen(PASSWORD));
			if(player.getPassword().compareTo(SPACE) <= 5) {
				System.out.println(PASSWORDMIN);
			}
		}while(player.getPassword().compareTo(SPACE) <= 5);
		
		// NAME 
		player.setName(screen(NAME));
		
		// DATE  BIRTH 
		do{
			player.setDateBirth(screen(DATE));	
			
			if(player.getDateBirth().compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}			
		}while(player.getDateBirth().compareTo(SPACE) == 0); 
		
		// ROUNDS
		round.setRoundNumber(Integer.parseInt(screen(ROUND)));	
		
		// LEVEL
		round.setLevel(screen(LEVEL));
		
	}
	
	public static int validateNumber(int option) {
		
		if( option == 1 || option == 2 ||  option == 3 || option == 4 )  {
			return option;
		}
		else {
			return 0;
		}
		
	}
		
	

}

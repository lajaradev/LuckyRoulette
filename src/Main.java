import java.util.Scanner;

public class Main {
	
	private static final String MYNAME = "SAMUEL LAJARA";
	private static final String ALIAS = "Alias: ";
	private static final String PASSWORD = "Password: ";
	private static final String PASSWORDMIN = "Atleast 6 Characters";
	private static final String NAME = "Name: ";
	private static final String DATE = "Date: ";
	private static final String NOTNULL = "Not Null";
	private static final String ROUND =  "Rounds: ";
	private static final String LEVEL = "Level: (easy / medium / expert)";
	private static final String SPACE =  "";
	
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(MYNAME);
		
		Player player = new Player();
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
	
		playerData(player, round);
		
		String LEVEL = round.getLevel();
		
		game.startGame(LEVEL);	
		
		scanIn.close();	
	}
	
	private static String screen(String str) {
		
		System.out.println(str);
		return(scanIn.nextLine());
	}

	private static void playerData(Player player, Round round) { // COLLECT THE VALUE
	/*	
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
		
		*/
		// LEVEL
		round.setLevel(screen(LEVEL));
		
	}
	

		
	

}

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	
	private static String NAME = "SAMUEL LAJARA";
	
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(NAME);
		
		Player player = new Player();
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
		
	
		//sentence.showFile();
		
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
		
		// ALIAS 
		do{
			player.setAlias(screen("Alias: "));
			if(player.getAlias().compareTo("") == 0) {
				System.out.println("Not null");
			}
		}while(player.getAlias().compareTo("") == 0);
		
		// PASSWORD 
		do{
			player.setPassword(screen("Password: "));
			if(player.getPassword().compareTo("") <= 5) {
				System.out.println("Atleast 6 Characters");
			}
		}while(player.getPassword().compareTo("") <= 5);
		
		// NAME 
		player.setName(screen("Name: "));
		
		// DATE  BIRTH 
		LocalDate today = LocalDate.now();
		do{
			player.setDateBirth(screen("Date: "));	
			
			if(player.getDateBirth().compareTo("") == 0) {
				System.out.println("Not null");
			}			
		}while(player.getDateBirth().compareTo("") == 0); 
		
	
		
		/* ROUNDS */
		round.setRoundNumber(Integer.parseInt(screen("Rounds: ")));
		
		
		/* LEVEL */
		round.setLevel(screen("Level: "));
		
	}
	

		
	

}

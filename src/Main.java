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
		
		player.setAlias(screen("Alias: "));
		player.setPassword(screen("Password: "));
		player.setName(screen("Name: "));
		player.setDateBirth(screen("Date: "));	
		
		round.setRoundNumber(Integer.parseInt(screen("Rounds: ")));
		round.setLevel(screen("Level: "));
		
	}
		
	

}

import java.util.Scanner;

public class Main {
	
	private static String NAME = "SAMUEL LAJARA";
	
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println(NAME);
		
		Player player = new Player();
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
		Sentence sentence = new Sentence();
	
		sentence.showFile();
		
	//	playerData(player, round);
		
		//game.startGame();	
		
		scanIn.close();	
	}
	
	private static String get(String str) {
		
		System.out.println(str);
		return(scanIn.nextLine());
	}

	private static void playerData(Player player, Round round) {
		
		player.setAlias(get("Alias: "));
		player.setPassword(get("Password: "));
		player.setName(get("Name: "));
		player.setDateBirth(get("Date: "));	
		
		round.setRoundNumber(Integer.parseInt(get("Rounds: ")));
		
	}
		
	

}

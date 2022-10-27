package es.poo.lucky_roulette;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private static final String LUCKYROULETTE = "LUCKY ROULETTE BY SAMUEL LAJARA";
	private static final String SEPARATOR     = "-------------------------------\n";
	private static final String SPACE         = "";
	private static final String OPTION1       = "1. Sign in";
	private static final String OPTION2       = "2. Log in";
	private static final String OPTION3       = "3. Exit";
	private static final String DEFAULT       = "Wrong Number";
	private static final String ALIAS 		  = "Alias: ";
	private static final String PASSWORD      = "Password: ";
	private static final String PASSWORDMIN   = "Atleast 6 Characters";
	private static final String NAME 		  = "Name: ";
	private static final String NOTNULL  	  = "Not Null";
	private static final String ROUND         = "Rounds: ";
	private static final String LEVEL         = "Level: (rookie / medium / expert)";
	private static final String CHECKNUMBER   = "You haven't entered a number. Try again: ";
	private static final String INFPLAYER	  = "SHOW INFORMATION PLAYER\n";
	private static final String ERRODATE	  = "The birthday date cannot be greater than the current date";
	private static final String INCORRECTDATA = "Incorrect Data";
	private static final String YEAR	 	  = "YEAR: (yyyy)";
	private static final String MONTH	      = "MONTH: (mm)";
	private static final String DAY			  = "DAY: (d)";
	private static final String DATEBIRTH	  = "DateBith: ";
	private static final String TENYEAROLD	  = "you are under 10 years old: ";
	
	private static Scanner scanIn = new Scanner(System.in);
	private static Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println(LUCKYROULETTE);
		System.out.println(SEPARATOR);
		
		Player player = new Player(null, null, null, null); // CREATE OBJECT
		Round round = new Round();
		LuckyRouletteGame game = new LuckyRouletteGame();
		
		ArrayList <Player> listPlayer = new ArrayList <Player>();
		listPlayer.add(new Player("guest", "guest", null, null));
		
		int option = 0;
		int ROUNDS = 0;
		int correct;
		boolean b = true;
		String LEVEL = null;
	
		do {
		
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
				
				case 1: // SIGN IN
					signInPlayer(player, listPlayer);
				break;
					
				case 2: // LOG IN
					correct = logInPlayer(player, listPlayer);	
					if(correct == 0) {
						gameData(round);
						LEVEL = round.getLevel();
						ROUNDS = round.getRoundNumber();
						game.startGame(LEVEL, ROUNDS);
					}
				break;
					
				case 3: // EXIT 
					System.exit(0);
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

	private static void signInPlayer(Player player, ArrayList <Player> listPlayer) { // COLLECT THE VALUE
	
		
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
		
		
		// DATE  BIRTH 	
		long currentdate, birthdate;
		do {
			Calendar current = currentDate();
			player.setDateBirth(birthDate());
			
			currentdate = current.getTimeInMillis();
			birthdate = player.getDateBirth().getTimeInMillis();
			
			if(currentdate < birthdate) {
				System.out.println(ERRODATE);
			}
			
		}while(birthdate > currentdate);
	
		listPlayer.add(new Player(player.getAlias(), player.getPassword(), player.getName(), player.getDateBirth()));
		
	}

	private static void gameData(Round round) { // COLLECT THE VALUE
		
		round.setRoundNumber(Integer.parseInt(screen(ROUND)));	 // NUMBER ROUNDS
		round.setLevel(screen(LEVEL)); // LEVEL
	}
	
	private static void showPlayer(Player player, ArrayList <Player> listPlayer) {
		
		System.out.println(INFPLAYER);
		for(Player p: listPlayer) {
			System.out.println(ALIAS 	 + p.getAlias());
			System.out.println(PASSWORD  + p.getPassword());
			System.out.println(NAME 	 + p.getName());
			System.out.println(SEPARATOR);
		}
	}
	
	private static int logInPlayer(Player player, ArrayList <Player> listPlayer) { 
		
		//showPlayer(player, listPlayer);
		String alias, password;
		
		System.out.println(ALIAS);
		alias = scanIn.nextLine();
		System.out.println(PASSWORD);
		password = scanIn.nextLine();
		
		long currentdate10 = checkAge(player, listPlayer); 
		
		for(Player p: listPlayer) {
			if(alias.equals(p.getAlias()) && password.equals(p.getPassword())) {
				if(currentdate10 < p.getDateBirth().getTimeInMillis()) {
					return 0;
				}
				else {
					System.out.println(TENYEAROLD);
				}
			}
			else {
				System.out.println(INCORRECTDATA);
			}
		}
		
		return 1;		
	}
	
	public static long checkAge(Player player, ArrayList <Player> listPlayer) {
		
		Calendar current = currentDate();
		
		current.add(Calendar.YEAR, -10);
		long currentdate10 = current.getTimeInMillis();
		
		return currentdate10;
		
	}
	
	public static Calendar currentDate(){
		
		Calendar calendar = Calendar.getInstance();
		
		int day	  = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH);
		int year  = calendar.get(Calendar.YEAR);
		
		calendar.set(year, month, day);
		
		//System.out.println(day + "/" + month + "/" + year);
		return calendar;
		
	}
	
	public static Calendar birthDate(){
		
		Calendar calendar = Calendar.getInstance();
		int year, month, day = 0;
		
		do {
			try {
				year  = Integer.parseInt(screen(YEAR));
				month = Integer.parseInt(screen(MONTH));
				day	  = Integer.parseInt(screen(DAY));
				
				calendar.set(year, month, day);
				//System.out.println(day + "/" + month + "/" + year);
			}
			catch(NumberFormatException e) {  
				System.out.println(CHECKNUMBER);
				SC.nextLine();
			}
		} while(day == 0);

		return calendar;
		
	}
	
	
}

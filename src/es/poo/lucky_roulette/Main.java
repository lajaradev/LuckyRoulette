package es.poo.lucky_roulette;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private static final String LUCKYROULETTE = "LUCKY ROULETTE BY SAMUEL LAJARA";
	private static final String SEPARATOR     = "-------------------------------\n";
	private static final String SPACE         = "";
	private static final String MAINMENU       = "1. Sign in\n2. Log in\n3. Exit";
	private static final String DEFAULT       = "Wrong Number";
	private static final String ALIAS 		  = "Alias:";
	private static final String PASSWORD      = "Password:";
	private static final String PASSWORDMIN   = "Atleast 6 Characters";
	private static final String NAME 		  = "Name:";
	private static final String NOTNULL  	  = "Not Null";
	private static final String CHECKNUMBER   = "You haven't entered a number. Try again: ";
	private static final String STARTGAME	  = "Do you want to start a game?";
	private static final String AFFIRMA	 	  = "Yes or No";
	private static final String INCORRECTDATA = "Incorrect Data";
	private static final String YEAR	 	  = "YEAR: (yyyy)";
	private static final String MONTH	      = "MONTH: (mm)";
	private static final String DAY			  = "DAY: (d)";
	private static final String DATEBIRTH	  = "DateBith: ";
	private static final String TENYEAROLD	  = "you are under 10 years old: ";
	private static final String YES	 	  		= "yes";
	
	private static Scanner scanIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Player player = new Player();
		player.setGuest(player);
		
		ArrayList <Player> listPlayer = DataBase.giveMeListPlayer();
				
		System.out.println(LUCKYROULETTE);
		System.out.println(SEPARATOR);
				
		int option = 0;
		int rounds = 0;
		int correct;
		boolean b = true;
		String LEVEL = null; 
		String affirmation;
	
		do {
				System.out.println(MAINMENU);
				
				try {
					option = Integer.parseInt(scanIn.nextLine());
				}catch(InputMismatchException e) {
					System.out.println(CHECKNUMBER);
					scanIn.nextLine();
				}
												
				switch(option) {
				
				case 1: // SIGN IN
					signInPlayer();
				break;
					
				case 2: // LOG IN
					if(logInPlayer() != null) {
						System.out.println(STARTGAME);
						affirmation  = screen(AFFIRMA);
						if(affirmation.compareTo(YES) == 0) {
							LuckyRouletteGame game = new LuckyRouletteGame();
							game.startGame();						
						}
					}
				break;
					
				case 3: // EXIT 
					System.exit(0);
				break;
				
				case 4: // EXIT 
					DataBase.showPlayer(listPlayer);
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

	private static void signInPlayer() { // COLLECT THE VALUE
	
		String strAlias, strPassword, strName;
		Calendar current, birth;
		long currentDate, birthDate;
		
		do{ // ALIAS 
			strAlias = screen(ALIAS);
			if(strAlias.compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}
		}while(strAlias.compareTo(SPACE) == 0);
				
		do{ // PASSWORD 
			strPassword = screen(PASSWORD);
			if(strPassword.compareTo(SPACE) <= 5) {
				System.out.println(PASSWORDMIN);
			}
		}while(strPassword.compareTo(SPACE) <= 5);
		
		strName =(screen(NAME)); // NAME 
		
		// DATE  BIRTH 	
		/*do {
			current = currentDate();
			birth = birthDate();
			
			currentDate = current.getTimeInMillis();
			birthDate = birth.getTimeInMillis();
			
			if(currentDate < birthDate) {
				System.out.println(ERRODATE);
			}
			
		}while(birthDate > currentDate);*/
			
		Player player = new Player();
		player.setAlias(strAlias);
		player.setPassword(strPassword);
		player.setName(strName);
		DataBase.addPlayer(player);
		 
	}
	
	private static Player logInPlayer() { 
		
		String strAlias, strPassword;
		
		strAlias = screen(ALIAS);
		strPassword = screen(PASSWORD);
	
		if(DataBase.playerExists(strAlias, strPassword) != null) {
			return DataBase.playerExists(strAlias, strPassword);
		}
		return null;
	}
	
	public static long checkAge(Player player, ArrayList <Player> listPlayer) {
		
		Calendar current = currentDate();
		DateFormat formateador= new SimpleDateFormat("dd/M/yyyyy");
		current.add(Calendar.YEAR, -10);
		long currentdate10 = current.getTimeInMillis();
		System.out.println(formateador.format(current.getTime()));
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
				scanIn.nextLine();
			}
		} while(day == 0);

		return calendar;
		
	}
}
	
	
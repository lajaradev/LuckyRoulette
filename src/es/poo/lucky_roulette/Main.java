package es.poo.lucky_roulette;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	private static final String AFFIRMA	 	  = "yes or no";
	private static final String UNDERYEARS 	  = "Under 10 years old";
	private static final String YEAR	 	  = "YEAR: (yyyy)";
	private static final String MONTH	      = "MONTH: (mm)";
	private static final String DAY			  = "DAY: (dd)";
	private static final String ERRORDATE2	  = "The date can't be later than the current date";
	private static final String YES	 	  	  = "yes";
	
	private static Scanner scanIn = new Scanner(System.in);
	
	public static void main(String[] args) {		
		
		ArrayList <Player> listPlayer = DataBase.giveMeListPlayer();
				
		int option = 0;
		boolean b = true;
		
		String affirmation;
		
		System.out.println(LUCKYROULETTE);
		System.out.println(SEPARATOR);
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
					Player player = logInPlayer();
					if(player != null) {
						System.out.println(STARTGAME);
						affirmation  = screen(AFFIRMA);
						if(affirmation.compareTo(YES) == 0 && checkAge(player)) {
							LuckyRouletteGame game = new LuckyRouletteGame();
							game.startGame();						
						}
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
	
	/* Method to register a new player.
	 * Request the data and validate it.
	 * Then add the data to an array in another class
	 * */
	private static void signInPlayer() { // COLLECT THE VALUE
	
		String strAlias, strPassword, strName, strBirth;
		
		strAlias    = validateAlias();
		strPassword = validatePassword(); // PASSWORD 
		strName 	= (screen(NAME)); // NAME 
		strBirth 	= validateBirthDate(); // DATE  BIRTH 	
		
		Player player = new Player();
		player.setAlias(strAlias);
		player.setPassword(strPassword);
		player.setName(strName);
		player.setBirthDate(strBirth);
		DataBase.addPlayer(player);
		 
	}
	
	/* Validate that the alias is not empty */
	private static String validateAlias() {
		
		String strAlias;
		
		do{ // ALIAS 
			strAlias = screen(ALIAS);
			if(strAlias.compareTo(SPACE) == 0) {
				System.out.println(NOTNULL);
			}
		}while(strAlias.compareTo(SPACE) == 0);
		
		return strAlias ;
	}
	/* Validate that the password has more than 5 characters */
	private static String validatePassword() {
		
		String strPassword;
		
		do{ // PASSWORD 
			strPassword = screen(PASSWORD);
			if(strPassword.compareTo(SPACE) <= 5) {
				System.out.println(PASSWORDMIN);
			}
		}while(strPassword.compareTo(SPACE) <= 5);
		
		return strPassword ;
	}
	
	/* Validate that the year is between 1900 and 2022
	 * Validate that the month is between 1 and 12
	 * Validate that the day is between 1 and 31
	 * 
	 * And check that the date entered is not greater than the current one
	 * */
	public static String validateBirthDate(){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		Date dateBirth;
		Date currentDate;
		
		String strCalendar;
		
		int year  = 0;
		int month = 0;
		int day   = 0;
		int maxDay;
		
		boolean b = true;
		
		do {
		
			do { // YEAR 
				try { 
					year  = Integer.parseInt(screen(YEAR));
				}
				catch(NumberFormatException e) {  
					System.out.println(CHECKNUMBER);
					scanIn.nextLine();
				}
			} while(year <= 1900 || year > calendar.get(Calendar.YEAR));
			
			do { // MONTH
				try {
					month = Integer.parseInt(screen(MONTH));
				}
				catch(NumberFormatException e) {  
					System.out.println(CHECKNUMBER);
					scanIn.nextLine();
				}
			} while(month <= 0 || month >= 13);
			
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				maxDay = 32;
			}
			else if(month == 2) {
				maxDay = 29;
			}
			else {
				maxDay = 31;
			}
			
			do { // DAY
				try {
					day = Integer.parseInt(screen(DAY));
				}
				catch(NumberFormatException e) {  
					System.out.println(CHECKNUMBER);
					scanIn.nextLine();
				}
			} while(day <= 0 || day >= maxDay);
			
			calendar.set(year, month - 1, day);
			dateBirth = calendar.getTime();	
			currentDate = currentDate().getTime();	
			
			if(currentDate.compareTo(dateBirth) >= 0) {
				strCalendar = sdf.format(dateBirth);
				return strCalendar;
			}
			
			System.out.println(ERRORDATE2);
		
		}while(b);
		
		return null;
		
	}
	
	/* Take the data that is entered on the screen and ask the class if it has this player 
	 * The player returns
	 * */
	private static Player logInPlayer() { 
		
		String strAlias, strPassword;
		
		strAlias = screen(ALIAS);
		strPassword = screen(PASSWORD);
	
		if(DataBase.playerExists(strAlias, strPassword) != null) {
			return DataBase.playerExists(strAlias, strPassword);
		}
		return null;
	}
	
	private static Calendar currentDate(){
		
		Calendar calendar = Calendar.getInstance();	
		return calendar;
		
	}
	
	/* Check that it is older than 10 years */
	public static boolean checkAge(Player player) {
		
		Calendar current = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date dateAge, dateBirth;	
		String strDateBirth;
		
		current.add(Calendar.YEAR, -10); // to the current date we remove 10 years
		
		dateAge = current.getTime(); // Convert it to type Date
		
		strDateBirth = player.getBirthDate(); // Take the birthday of the player
		
		try {
			dateBirth = sdf.parse(strDateBirth); // Convert it to type Date (It was String)
			if(dateBirth.after(dateAge)) {  // if the birthday is after the calculated date
				System.out.println(UNDERYEARS); // You can not play
				return false;
			}
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		return true;
		
	}
}
	
	
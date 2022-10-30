package es.poo.lucky_roulette;

import java.util.ArrayList;

public class DataBase {
	
	private static final String INFPLAYER	  = "SHOW INFORMATION PLAYER\n";
	private static final String ALIAS 		  = "Alias: ";
	private static final String PASSWORD      = "Password: ";
	private static final String NAME 		  = "Name: ";
	private static final String BIRTH 		  = "Birth Date: ";
	private static final String SEPARATOR     = "-------------------------------\n";
	private static final String ALIASEXISTS   = "This alias already exists";
	private static final String PLAYEREXISTS  = "There is no player with this combination\n";
		
	private static ArrayList <Player> listPlayer = new ArrayList <Player>();
	
	public static void setGuest() { // GET THE VALUE OF THE ALIAS
		Player guest = new Player();
		guest.setAlias("guest");
		guest.setPassword("guest");
		listPlayer.add(guest);
	}
	
	// ADD PLAYER
	public static void addPlayer(Player player) {
		
		if(aliasExists(player.getAlias()) == null) { 
			listPlayer.add(player);
		}
		else {
			System.out.println(ALIASEXISTS);
		}
		
	}
	
	// ALIAS EXIST
	public static Player aliasExists(String alias) {
		
		for(int i = 0; i < listPlayer.size(); i ++) {
			if(listPlayer.get(i).getAlias().compareTo(alias) == 0) {
				return listPlayer.get(i);
			}	
		}
		return null;
		
	}
	
	// PLAYER EXISTS
	public static Player playerExists(String alias, String password) {
		
		for(int i = 0; i < listPlayer.size(); i ++) {
			if ((listPlayer.get(i).getAlias().compareTo(alias) == 0) && (listPlayer.get(i).getPassword().compareTo(password) == 0) ){
				//System.out.println("The player is: " + listPlayer.get(i).getAlias());
				return listPlayer.get(i);
			}
		}
		System.out.println(PLAYEREXISTS);
		return null;	
	 	
	}
	
	// GIVE ME LIST PLAYERS
	public static ArrayList <Player> giveMeListPlayer(){
		setGuest();
		return listPlayer;
	}
	
	// SHOW LIST PLAYERS
	public static void showPlayer(ArrayList <Player> listPlayer) {
		
		System.out.println(INFPLAYER);
		for(Player p: listPlayer) {
			System.out.println(ALIAS 	 + p.getAlias());
			System.out.println(PASSWORD  + p.getPassword());
			System.out.println(NAME 	 + p.getName());
			System.out.println(BIRTH 	 + p.getBirthDate());
			System.out.println(SEPARATOR);
		}
	}
	

	

}

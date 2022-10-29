package es.poo.lucky_roulette;
import java.util.Calendar;

public class Player {
	
		private String alias, password, name;
		private Calendar birthDate;
				
		public void setGuest(Player player) { // GET THE VALUE OF THE ALIAS
			player.setAlias("guest");
			player.setPassword("guest");
			DataBase.addPlayer(player);
		}
				
		public String getAlias() { // SHOW ALIAS
			return alias;
		}
		
		public void setAlias(String alias) { // GET THE VALUE OF THE ALIAS
			this.alias = alias;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Calendar getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Calendar birthDate) {
			this.birthDate = birthDate;
		}


	
}

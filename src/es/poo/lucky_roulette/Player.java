package es.poo.lucky_roulette;
import java.util.Calendar;

public class Player {
	
		private String alias, password, name;
		private Calendar dateBirth;
		
		
		public Player(String alias, String password, String name, Calendar dateBirth) {
			this.alias = alias;
			this.password = password;
			this.name = name;
			this.dateBirth = dateBirth;
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

		public Calendar getDateBirth() {
			return dateBirth;
		}

		public void setDateBirth(Calendar dateBirth) {
			this.dateBirth = dateBirth;
		}


	
}

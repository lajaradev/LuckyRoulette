package es.poo.lucky_roulette;
import java.util.Calendar;

public class Player {
	
		private String alias, password, name, birthDate;
				
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

		public String getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		
	
}

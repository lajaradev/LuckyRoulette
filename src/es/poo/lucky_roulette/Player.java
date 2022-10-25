package es.poo.lucky_roulette;
public class Player {
	
		private String alias, password, name, dateBirth;
		
		public Player() {
			this.alias = "invitado";
			this.password = "invitado";
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

		public String getDateBirth() {
			return dateBirth;
		}

		public void setDateBirth(String dateBirth) {
			this.dateBirth = dateBirth;
		}


	
}

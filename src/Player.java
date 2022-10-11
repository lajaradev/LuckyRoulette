
public class Player {
	
		private String alias, password, name, dateBirth;

		
		public static String validateAlias(String alias) {
			
				if (alias.equals("")) {
					System.out.println("Alias Empty\n");
				}
				else {
					return alias;
				}
				return alias;
		}
				
			
		
		/* MOSTRAMOS EL ALIAS */
		public String getAlias() {
			return alias;
		}
		/* RECOGEMOS EL VALOR DEL ALIAS */
		public void setAlias(String alias) {
			validateAlias(alias);	
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

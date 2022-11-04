package es.poo.lucky_roulette;

public class Thrower {
	
	/* This method returns a random score */
	public static int throwScore() {
		
		int score = 0;
		int number = 0;
		
		number = (int)(Math.random()*5+1);
		
		switch(number) {
			case 1:
				score = 10;
			break;
			
			case 2:
				score = 20;
			break;
			
			case 3:
				score = 30;
			break;
			
			case 4:
				score = 40;
			break;
			
			default:
				score = 0;
			break;
			
		}
		
		return score;
		
	}
}

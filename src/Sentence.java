import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sentence {
	
	private String sentence;
	private int level;
	
	
	
	private static ArrayList < Sentence > listSentence = new ArrayList <Sentence>();
	
	
	public static String giveMeSentence(String LEVEL) {
		
		String randomSentence = null;
		int number = (int)(Math.random()*3+1);
		System.out.println("Number: " + number);
		
		if(LEVEL.equals("expert")) {
			System.out.println("Expert Mode\n");
			if(number == 1) {
				randomSentence = "1.EXPERT.You only fail when you stop trying";
			}
			else if(number == 2) {
				randomSentence = "2.EXPERT.You only fail when you stop trying";
			}
			else {
				randomSentence = "3.EXPERT.You only fail when you stop trying";
			}		
			
		}
		else if(LEVEL.equals("medium")) {
			System.out.println("Medium Mode\n");
			if(number == 1) {
				randomSentence = "1.MEDIUM.You only fail when you stop trying";
			}
			else if(number == 2) {
				randomSentence = "2.MEDIUM.You only fail when you stop trying";
			}
			else {
				randomSentence = "3.MEDIUM.You only fail when you stop trying";
			}
		}
		
		else{ 
			System.out.println("Rookie Mode\n");
			
			if(number == 1) {
				randomSentence = "1.EASY.You only fail when you stop trying";
			}
			else if(number == 2) {
				randomSentence = "2.EASY.You only fail when you stop trying";
			}
			else {
				randomSentence = "3.EASY.You only fail when you stop trying";
			}
			
		}
			
		return randomSentence;
	}
	
	
	
	
	
	public static void showFile() {
		
		try {
			File file = new File("C:\\Users\\lajar\\OneDrive\\Escritorio\\INFORMATICA\\POO2022\\LuckyRoulette\\src\\sentence.txt");
			FileInputStream output = new FileInputStream(file);
			
			if(output != null) {
				InputStreamReader aux = new InputStreamReader(output);
				BufferedReader aux2 = new BufferedReader(aux);
				String aux3 = "";
				
				while((aux3 = aux2.readLine()) != null) {
					System.out.println(aux3);
				}
				aux.close();
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
}

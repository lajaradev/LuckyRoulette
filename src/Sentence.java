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

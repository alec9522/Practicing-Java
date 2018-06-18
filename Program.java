import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Program {


	public static void main(String[] args) throws FileNotFoundException {

		final int fileHeaderSize= 49;
		float maxTemp = (float) -500.0;
		float minTemp = (float) 500.0;
		float tempMax;
		float tempMin;
		float totalSnow =  (float) 0.0;
		String next;

		//Define Scanner with delimiter ","
		Scanner scanner = new Scanner(new File("/Users/alec9522/Documents/workspace/Java Test Cakemail/java-test-master/src/main/resources/eng-daily-01012018-12312018.csv"));
		scanner.useDelimiter(",");

		//Move the scanner to the start of the data 
		for(int i = 0; i < fileHeaderSize; i++){
			scanner.next();
		}

		//Skip to Max Temperature
		for(int i = 0; i < 5; i++){
			scanner.next().replace('"', '\0');
		}

		while((next = scanner.next().replaceAll("\"", "")).isEmpty() != true){

			// Get the Maximum temperature and if it is a new record save it in maxTemp
			tempMax = Float.parseFloat(next); 
			if (tempMax > maxTemp) {
				maxTemp = tempMax;
			}	

			//Skip to Min Temperature
			scanner.next();

			// Get the Minimum temperature and if it is a new record save it in minTemp
			tempMin = Float.parseFloat(scanner.next().replace('"', '\0')); 
			if (tempMin < minTemp) {
				minTemp = tempMin;
			}

			//Skip to Total Snow (cm)
			for(int i = 0; i < 9; i++){
				scanner.next().replace('"', '\0');
			}

			// Increment totalSnow with the Total Snow of that Day
			Float snow = Float.parseFloat(scanner.next().replace('"', '\0'));
			totalSnow += snow; 
			totalSnow = (float)(Math.round(totalSnow*100.0)/100.0);			

			//Skip to next Element
			for(int i = 0; i < 13; i++){
				scanner.next().replace('"', '\0');
			}		
		}

		// Close Scanner
		scanner.close();

		System.out.println("Min Temp: " + minTemp);
		System.out.println("Max Temp: " + maxTemp);
		System.out.println("Total Snow: " + totalSnow);

	}

}


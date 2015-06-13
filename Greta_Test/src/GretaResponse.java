
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GretaResponse {

	GretaConnector gretaConnector;

	public void executeArea(String filename) {
		gretaConnector = new GretaConnector();
		//uncomment this try catch later
		try {

			File targetFile;
			String temp;
			Scanner sc;

			
			//modify this line for the path and filename
			targetFile = new File(filename);


			//just uncomment this part after
			sc = new Scanner(targetFile);

			temp = sc.useDelimiter("\\A").next();
			gretaConnector.process(temp, "Greta.Data.BML");

			sc.close();



		} catch (FileNotFoundException ex) {
			ex.printStackTrace();    
		}
	}



}

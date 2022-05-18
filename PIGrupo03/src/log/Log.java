package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fileHandler;
		
		try {
			fileHandler = new FileHandler("\\src\\log\\MyLogFile.txt");
			logger.addHandler(fileHandler);
			
			SimpleFormatter simpleFormater = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormater);
			logger.info("teste");
			
		}
		catch(SecurityException e) {
			logger.info("Exception" + e.getMessage());
			e.printStackTrace();
			
		} catch (IOException e) {
			 logger.info("IO Exception:" + e.getMessage());
	            e.printStackTrace();
		}
		logger.info("Mensagem de log na main");
		
	}
}

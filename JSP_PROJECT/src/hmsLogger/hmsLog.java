package hmsLogger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class hmsLog {//by IT19051208
	public static void  writeLogger(String msg)
	{
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh = null;  
	    
	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:\\Users\\Public\\hms\\hmslogger.log",true);   //file path
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
	        logger.info(msg);

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    
	    fh.close();
	    logger = null;
	    
	}
	
}

package ninzaCRM.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {

	/**
	 * This method will capture current system date and return it to caller 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}
	
	/**
	 * This method will generate random number and return it to caller
	 * @return 
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}
	
	
	
	
	
	
	
	
	
	
}

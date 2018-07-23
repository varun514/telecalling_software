import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

	public static boolean isThisDateValid(){
		String dateToValidate="29/02/2000";
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		
		} catch (ParseException e) {
			
			System.out.println("date is incorrect");
			return false;
		}
		
		return true;
	}
	public static void main(String args[])
	{
		isThisDateValid();
	}
	
}

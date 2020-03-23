package miscellaneous;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateMethod {
	public static void  convertDateFormat_mmddyyHHMMSAMPM_To_YYYYMMDDHHMMSS(String inputDate) {
		SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formatedDate = null;
		try {
			formatedDate = date.format(date1.parse(inputDate)).replaceAll("/", "-");
		} catch (ParseException p) {

		}
		System.out.println(formatedDate); 
	}

	public static void main(String[] args) {
		convertDateFormat_mmddyyHHMMSAMPM_To_YYYYMMDDHHMMSS("09/18/2017 6:01:26 AM");
	}

}

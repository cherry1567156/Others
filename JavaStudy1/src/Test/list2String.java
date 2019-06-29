package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class list2String {
	public static void main(String args[]) {
		/*List<Object> newdata = new ArrayList<Object>();
		newdata.add("201803");
		newdata.add("null");
		newdata.add("M");
		newdata.add("wwwww");
		System.out.println(newdata.toString());*/
		//System.out.println("\\n\\n\\n\\n");
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("1995-05-08");
			Long date1 = date.getTime();
			System.out.print(date1);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}*/
		String id = "1";
		if(id.length() > 0) {
			id = id.substring(0, id.length() - 1);
			System.out.println(id.length());
		}
		System.out.println(id.length());
		
	}
}

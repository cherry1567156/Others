package com.succez.filesystem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("D:\\test1.txt");
		Calendar cal = Calendar.getInstance();
		long time = file.lastModified();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd a hh:mm:ss");
		cal.setTimeInMillis(time);
		System.out.println("修改时间[2] " + formatter.format(cal.getTime()));

	}

}

package com.succez.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JsonTest {
	public static String readJSONData(Request request) {
        StringBuffer json=new StringBuffer();
        String lineString=null;
        try {
        	InputStreamReader inputStreamReader=new InputStreamReader(request.input);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            while ((lineString=reader.readLine())!=null) {
                json.append(lineString);                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }


}

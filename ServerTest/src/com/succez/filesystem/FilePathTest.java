package com.succez.filesystem;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class FilePathTest{
	public static void main(String args[]){
		String path=System.getProperty("user.dir");
		String path1=System.getProperty("user.dir")+"\\src\\com";
		System.out.println(path);
		Gson g=new Gson();
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("filepath", path);
		String json=g.toJson(map);
		System.out.println(json);
		System.out.println(path1);
		System.out.print("root"+path1.substring(path.length()));
	}
}
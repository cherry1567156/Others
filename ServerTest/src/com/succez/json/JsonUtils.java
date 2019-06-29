package com.succez.json;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonUtils {
	public void parseJson01(String jsonData) {
		try {
			//解析json对象首先要生产一个JsonReader对象
			JsonReader reader = new JsonReader(new StringReader(jsonData));
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				while (reader.hasNext()) {
					String tagName = reader.nextName();
					if ("name".equals(tagName)) {
						System.out.println("name--->" + reader.nextString());
					}
					else if ("age".equals(tagName)) {
						System.out.println("age--->" + reader.nextInt());
					}
				}
				reader.endObject();
			}
			reader.endArray();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseJson02(String jsonData) {
		Gson gson = new Gson();
		User user = gson.fromJson(jsonData, User.class);
		System.out.println("name--->" + user.getName());
		System.out.println("age---->" + user.getAge());
	}

	public void parseJson03(String jsonData){
        Type listType = new TypeToken<LinkedList<User>>(){}.getType();
        Gson gson=new Gson();
        LinkedList<User> users=gson.fromJson(jsonData, listType);
        for(User user:users){
            System.out.println("name--->" + user.getName());
            System.out.println("age---->" + user.getAge());
        }
        System.out.println("==================");
        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            System.out.println("name--->" + user.getName());
            System.out.println("age---->" + user.getAge());
        }
    }

	public static void main(String args[])
    {
    	User user01=new User("linjiqin", 24);
        Gson gson=new Gson();
        String obj=gson.toJson(user01);
        System.out.println(obj);
    }
}
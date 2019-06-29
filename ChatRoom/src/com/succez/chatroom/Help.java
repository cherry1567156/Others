package com.succez.chatroom;

import java.util.*;

public class Help {
	public static byte[] serial(Message msg){
		String content = "username=" + msg.getUser();
		content += ":time=" + msg.getTime();
		content += ":length=" + msg.getLength();
		content += ":message=" + msg.getMsg();
		return content.getBytes();
	}

	public static Message deserial(byte[] msg){
		String content = new String(msg).trim();
		Map map = new HashMap();
		StringTokenizer st = new StringTokenizer(content, ":");
		while(st.hasMoreTokens()){
			String field = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(
					field, "="
			);
			String key = st2.nextToken().trim();
			String value = st2.nextToken().trim();
			map.put(key, value);
		}
		Message message = new Message();
		message.setLength(Integer.parseInt((String)map.get("length")));
		message.setMsg((String)map.get("message"));
		message.setTime((String)map.get("time"));
		message.setUser((String)map.get("username"));
		return message;		
	}
}


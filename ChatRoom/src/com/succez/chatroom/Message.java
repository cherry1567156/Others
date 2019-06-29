package com.succez.chatroom;

import java.net.*;
import java.util.*;

public class Message{    
	private String user;      //the user of this message from
    private String msg;      //content of this message
    private String time;		//time of this message
    private String address;  //the address of this message from
    private int length;         //length of this msg
    
    public Message(){}
    
    public Message(String user, String msg){
        this.user = user;
        this.msg = msg;
        this.length = msg.length();
        time = (new GregorianCalendar()).toString();
    }

    public String getMsg() {
        return msg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    } 
    
    public boolean isLocal(){
        String address = null;
    	try {
			address = 
					InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	return (address.trim().equals(this.address.trim()));    	
    }    
}









package com.succez.chatroom;

import java.io.*;
import java.net.*;

public class Sender implements ISender{
	private MulticastSocket ms;
	private InetAddress group;
	private String user;

	public Sender(MulticastSocket ms, InetAddress group, 
			String user) {
		this.ms = ms;
		this.group = group;
		this.user = user;
	}

	public void send(String msg) {
		try {
			Message message = new Message(user, msg);
			byte[] data = Help.serial(message);
			DatagramPacket dp = new DatagramPacket(data, 
					data.length, group,	9998);
			ms.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





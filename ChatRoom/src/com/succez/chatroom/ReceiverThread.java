package com.succez.chatroom;

import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread {
	private IView view;
	private MulticastSocket ms;

	public ReceiverThread(IView view, MulticastSocket ms) {
		this.view = view;
		this.ms = ms;
	}

	public void run() {
		while (true) {
			try {
				byte[] msg = new byte[1800];
				DatagramPacket data = new DatagramPacket(msg, 
						msg.length);
				ms.receive(data);
				String address = 
					data.getAddress().getHostAddress().toString();	
				
				Message message = Help.deserial(data.getData());
				message.setAddress(address);
				view.addMsg(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

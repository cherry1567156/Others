package com.succez.chatroom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements IView {
	private Box chatArea;
	private JTextField msgTxt;
	private Container container;
	private ISender sender = null;

	public View(ISender sender) {
		this.sender = sender;
		container = getContentPane();
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}

	private void initGUI() {
		container.setLayout(new BorderLayout());

		JLabel lbl = new JLabel("Welcome to my chat room");
		container.add(lbl, BorderLayout.NORTH);

		chatArea = new Box(BoxLayout.Y_AXIS);
		chatArea.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(chatArea);

		container.add(scrollPane, BorderLayout.CENTER);

		msgTxt = new JTextField(80);
		container.add(msgTxt, BorderLayout.SOUTH);

		msgTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String content = msgTxt.getText();
				if (content == null || content.length() == 0) {
					return;
				}
				sender.send(content);
				msgTxt.setText("");
			}
		});
	}
	
	public void addMsg(Message message){
		String user = message.getUser();
		String address = message.getAddress();
		String content = message.getMsg();
		String msg = user + ":( " + address + ") " + content + "\n";
	 
		JLabel lbl = new JLabel();
		if (message.isLocal()) {
			lbl.setText("<html><body><font Color=red>" + msg
					+ "</font></body></html>");
		} else {
			lbl.setText("<html><body><font Color=green>" + msg
					+ "</font></body></html>");
		}
		chatArea.add(lbl, 0);
		this.validate();
	}

}






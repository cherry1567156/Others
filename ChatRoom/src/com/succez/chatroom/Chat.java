package com.succez.chatroom;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class Chat extends JDialog {
	private JButton startBtn;
	private JButton stopBtn;
	private Container container;
	private JTextField userName;
	private JTextField host;

	public Chat() {
		container = getContentPane();
		container.setLayout(new GridLayout(2, 1));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));

		JPanel panel11 = new JPanel();
		JPanel panel12 = new JPanel();
		panel.add(panel11);
		panel.add(panel12);

		JLabel userLbl = new JLabel("User Name: ");
		JLabel hostLbl = new JLabel("Chat Host: ");
		userName = new JTextField(10);
		host = new JTextField(10);

		userLbl.setSize(20, 20);
		hostLbl.setSize(20, 20);
		userName.setSize(20, 40);
		host.setSize(20, 40);

		userName.setText("guest");
		host.setText("239.255.255.255");
		panel11.add(userLbl);
		panel11.add(userName);
		panel12.add(hostLbl);
		panel12.add(host);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		startBtn = new JButton("start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				connect();
			}
		});

		panel2.add(startBtn);
		stopBtn = new JButton("stop");
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		panel2.add(stopBtn);

		container.add(panel);
		container.add(panel2);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	private void connect() {
		setVisible(false);
		View view = null;
		ReceiverThread rt = null;
		InetAddress group = null;
		MulticastSocket ms = null;
		try {
			group = InetAddress.getByName(host.getText());
			ms = new MulticastSocket(9998);
			ms.joinGroup(group);
			ISender sender = new Sender(ms, group, 
					userName.getText());
			view = new View(sender);
			rt = new ReceiverThread(view, ms);

			view.setVisible(true);
			rt.start();
		} catch (Exception e) {
			try {
				JOptionPane.showMessageDialog(null,
						"The Server you provided can not be connected",
						"alert", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ee) {
			}
			setVisible(true);
		}
	}

	public static void main(String[] args) {
		(new Chat()).setVisible(true);
	}
}








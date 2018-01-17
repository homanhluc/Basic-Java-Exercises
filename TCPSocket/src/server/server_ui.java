package server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_ui {

	private JFrame frame;
	JTextArea txtaMessage = new JTextArea();
	JTextArea txtaContent = new JTextArea();

	static ServerSocket socketServer;
	static Socket s;
	static DataInputStream in;
	static DataOutputStream ou;
	static Thread thServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server_ui window = new server_ui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public server_ui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Server", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(330, 11, 232, 41);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnReady = new JButton("Ready");
		panel_1.add(btnReady);

		JButton btnDisconnect = new JButton("Disconnect");
		panel_1.add(btnDisconnect);

		JLabel lbStatus = new JLabel("Not ready");
		lbStatus.setBounds(10, 28, 296, 14);
		panel.add(lbStatus);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Content", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.CYAN));
		panel_2.setBounds(10, 63, 552, 122);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 21, 532, 90);
		panel_2.add(scrollPane);

		txtaContent.setWrapStyleWord(true);
		txtaContent.setLineWrap(true);
		scrollPane.setViewportView(txtaContent);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 184, 373, 67);
		panel.add(panel_3);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Message", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.MAGENTA));
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 21, 353, 35);
		panel_3.add(scrollPane_1);

		scrollPane_1.setViewportView(txtaMessage);

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(393, 210, 89, 23);
		panel.add(btnSend);
		frame.getContentPane().setLayout(groupLayout);
		// ----------------------------------------main
		// code------------------------------------------------------------
		btnDisconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					in.close();
					ou.close();
					socketServer.close();

					lbStatus.setText("Disconnect");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnReady.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socketServer = new ServerSocket(8888);
					s = socketServer.accept();
					lbStatus.setText("Client connected");

					in = new DataInputStream(s.getInputStream());
					ou = new DataOutputStream(s.getOutputStream());

					getClientChat();
				} catch (Exception a) {
					System.out.println(a);
				}

			}
		});
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = txtaMessage.getText();
				if (text != "") {
					try {
						ou.writeUTF(text);
						txtaContent.append("You: " + text + "\n");
						txtaMessage.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

	}

	private void getClientChat() {
		thServer = new Thread(new Runnable() {

			@Override
			public void run() {
				// xu li nhan noi dung
				try {
					String content;
					while ((content = in.readUTF()) != null) {
						txtaContent.append("Client: " + content + "\n");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		thServer.start();
	}
}

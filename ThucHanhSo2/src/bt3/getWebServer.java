package bt3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class getWebServer {

	private JFrame frame;
	private JTextField txtUrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getWebServer window = new getWebServer();
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
	public getWebServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "L\u1EA5y th\u00F4ng tin t\u1EEB web server", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 274);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp URL");
		lblNewLabel.setBounds(20, 25, 78, 14);
		panel.add(lblNewLabel);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(103, 22, 206, 20);
		panel.add(txtUrl);
		txtUrl.setColumns(25);
		
		JButton btnGet = new JButton("Get");
		btnGet.setBounds(314, 21, 64, 23);
		panel.add(btnGet);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 82, 343, 167);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setLineWrap(true);
		txtContent.setWrapStyleWord(true);
		scrollPane.setViewportView(txtContent);
		txtContent.setColumns(40);
		txtContent.setRows(8);
		
		JLabel sa = new JLabel("N\u1ED9i dung");
		sa.setBounds(35, 57, 47, 14);
		panel.add(sa);
		//------------------------------main code-----------------------------
		
		btnGet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					URL url = new URL(txtUrl.getText());
					URLConnection urlc = url.openConnection();
					InputStream inStream = urlc.getInputStream( );
					Scanner inp = new Scanner (inStream);
					String data  = ""; 
					while ( true ) {
						data = data + inp.nextLine() ; 
						txtContent.setText(data);
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}
}

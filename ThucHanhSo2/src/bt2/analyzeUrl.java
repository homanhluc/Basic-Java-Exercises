package bt2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class analyzeUrl {

	private JFrame frame;
	private JTextField txtUrl;
	private JTextField txtProtocol;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					analyzeUrl window = new analyzeUrl();
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
	public analyzeUrl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 258);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ph\u00E2n t\u00EDch m\u1ED9t URL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp URL");
		lblNewLabel.setBounds(30, 34, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProtocol = new JLabel("Protocol");
		lblProtocol.setBounds(30, 67, 58, 14);
		panel.add(lblProtocol);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(30, 92, 76, 14);
		panel.add(lblHost);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(30, 123, 76, 14);
		panel.add(lblPort);
		
		JLabel lblPath = new JLabel("Path");
		lblPath.setBounds(30, 150, 76, 14);
		panel.add(lblPath);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(96, 31, 172, 20);
		panel.add(txtUrl);
		txtUrl.setColumns(10);
		
		txtProtocol = new JTextField();
		txtProtocol.setColumns(10);
		txtProtocol.setBounds(96, 59, 138, 20);
		panel.add(txtProtocol);
		
		txtHost = new JTextField();
		txtHost.setColumns(10);
		txtHost.setBounds(96, 89, 138, 20);
		panel.add(txtHost);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(96, 117, 138, 20);
		panel.add(txtPort);
		
		txtPath = new JTextField();
		txtPath.setColumns(10);
		txtPath.setBounds(96, 147, 138, 20);
		panel.add(txtPath);
		
		JButton btnAnalyze = new JButton("Analyze");
		btnAnalyze.setBounds(278, 30, 71, 23);
		panel.add(btnAnalyze);
		frame.getContentPane().setLayout(groupLayout);
		//----------------Code main------------------
		
		btnAnalyze.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					URL u = new URL(txtUrl.getText());
					txtProtocol.setText(u.getProtocol());
					txtHost.setText(u.getHost());
					txtPath.setText(u.getPath());
					txtPort.setText(u.getPort()+"");
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
}

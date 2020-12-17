package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPasswordOTP extends JFrame {

	  int OTP;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordOTP frame = new ForgotPasswordOTP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPasswordOTP() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Aadhar Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(26, 66, 238, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterOtp = new JLabel("Enter OTP ");
		lblEnterOtp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterOtp.setBounds(26, 221, 238, 43);
		contentPane.add(lblEnterOtp);
		
		textField = new JTextField();
		textField.setBounds(308, 70, 213, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(308, 225, 213, 43);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Send OTP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				try {
					 Random rand = new Random();
	   			     OTP = rand.nextInt(999999);
	   			     
	   			     
					// Construct data
					String apiKey = "apikey=" + "7pCkEMBBj48-KikH61awJUjXaBKGnfP3FcDOXJnjgZ";
					String message = "&message=" + "Your OTP is"+ OTP;
					String sender = "&sender=" + "Mahesh";
					String numbers = "&numbers=" + "9326602354";
					
					
					// Send data
					HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/").openConnection();
					String data = apiKey +  message + sender + numbers ;
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
					conn.getOutputStream().write(data.getBytes("UTF-8"));
					final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					final StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = rd.readLine()) != null) {
						stringBuffer.append(line);
					}
					rd.close();
					JOptionPane.showMessageDialog(null, "OTP SUCCESSFULLY SENT");
					//return stringBuffer.toString();
				} catch (Exception e1) {
					System.out.println("Error SMS "+e1);
					//return "Error "+e;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(346, 147, 175, 43);
		contentPane.add(btnNewButton);
		
		JButton btnVerifyOtp = new JButton("Verify OTP");
		btnVerifyOtp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerifyOtp.setBounds(346, 300, 175, 43);
		contentPane.add(btnVerifyOtp);
	}

}

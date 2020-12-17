package travel_agency;
import travel_agency.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Color;

public class forgot_password extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgot_password frame = new forgot_password();
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
	public forgot_password() {
		
		
		try {
		
		     
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
	        PreparedStatement p1 = con.prepareStatement("select user_aadhar from user_1 where user_name =? ");
			
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 381);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(12, 0, 388, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Aadhar Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 137, 228, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Username");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(12, 76, 179, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 587, 2);
		contentPane.add(separator);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(243, 76, 292, 27);
		contentPane.add(tf1);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(243, 138, 292, 27);
		contentPane.add(tf2);
		setResizable(false);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int count=0;
					ResultSet rs ;
					p1.setString(1, tf1.getText());
					rs = p1.executeQuery();
					if(rs.next()) {
						
						count++;
					}
					if(count==0) {
						JOptionPane.showMessageDialog(null, "User doesn't exists");
						
					}
					else if(rs.getLong("user_aadhar") == Long.parseLong(tf2.getText())) {
						
						create_new_password cp = new create_new_password();
						create_new_password.y = Long.parseLong(tf2.getText());
						setVisible(false);
						create_new_password.main(null);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Username and aadhar doesn't match");
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});
		btnNewButton.setBounds(384, 280, 141, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 587, 353);
		ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\2.jpeg");
	     Image img = imgIcon.getImage();
	     Image ScaleImg = img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(), img.SCALE_SMOOTH);
	     ImageIcon ScaledImage = new ImageIcon(ScaleImg);
	     lblNewLabel_2.setIcon(ScaledImage);
		contentPane.add(lblNewLabel_2);
		
		
		addWindowListener(new WindowAdapter(){
			public void actionPerformed(ActionEvent e2) {
				try {
					
					
					p1.close();
					
					con.close();
					System.exit(0);
				}catch(Exception e4) {
					System.out.println(e4);
				}
				
			}
		});
		
	    }catch(Exception e) {
	    	
	    }
	}
}

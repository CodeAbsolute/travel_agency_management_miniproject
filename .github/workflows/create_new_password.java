
package travel_agency;
import travel_agency.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.event.ActionEvent;

public class create_new_password extends JFrame {

	private JPanel contentPane;
	private JPasswordField pf2;

	static Long y ; 
	private JPasswordField pf1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create_new_password frame = new create_new_password();
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
	public create_new_password() {
		
		try {
            
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
	       PreparedStatement ps1 = con.prepareStatement("update user_1 set pass = ? where user_aadhar = ?");
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Create New Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(21, 0, 307, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 77, 212, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm New Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(23, 138, 224, 30);
		contentPane.add(lblNewLabel_1_1);
		
		pf2 = new JPasswordField();
		pf2.setBounds(285, 142, 240, 27);
		contentPane.add(pf2);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 571, 2);
		contentPane.add(separator);
		
		
		pf1 = new JPasswordField();
		pf1.setBounds(285, 80, 240, 27);
		contentPane.add(pf1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				
				String p1 = new String(pf1.getText());
				String p2 = new String(pf2.getText());
				
				if(p1.equals(p2)) {
					ps1.setString(1, p1);
					ps1.setLong(2, y);
					
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Password Updated Successfully");
					
					Login l = new Login();
					setVisible(false);
					Login.main(null);
				}else {
					JOptionPane.showMessageDialog(null, "Password doesn't match!!! Try Again");
				}
				
				
				}catch(Exception k) {
				
					System.out.println(k);
			}
			
			
			
			}
		});
		
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(21, 217, 142, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 581, 400);
		ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\3.jpeg");
	     Image img = imgIcon.getImage();
	     Image ScaleImg = img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(), img.SCALE_SMOOTH);
	     ImageIcon ScaledImage = new ImageIcon(ScaleImg);
	     lblNewLabel_2.setIcon(ScaledImage);
		contentPane.add(lblNewLabel_2);
		
		
		
		addWindowListener(new WindowAdapter(){
			public void actionPerformed(ActionEvent e2) {
				try {
					
					
					ps1.close();
					
					con.close();
					System.exit(0);
				}catch(Exception e4) {
					System.out.println(e4);
				}
				
			}
		});
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}

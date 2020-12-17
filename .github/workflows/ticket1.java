package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class ticket1 extends JFrame {

	private JPanel contentPane;
	static long pnr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticket1 frame = new ticket1();
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
	public ticket1() {

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
		PreparedStatement p1 = con.prepareStatement("select * from booking_details where pnr =? ");
		PreparedStatement p2 = con.prepareStatement("select * from customer where cust_id = ?");
		
		p1.setLong(1, pnr);
		ResultSet rs = p1.executeQuery();
		ResultSet rs2;
		if(pnr!=0) {
			rs.next();
			p2.setInt(1, rs.getInt("cust_id"));
			 rs2 = p2.executeQuery();
		}else {
			p2.setInt(1, 0);
			 rs2 = p2.executeQuery();
		}
		
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JTextArea ta = new JTextArea();
		ta.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		ta.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		ta.setBounds(22, 31, 435, 486);
		contentPane.add(ta);
		ta.setEditable(false);
		
		if(rs2.next()) {
			ta.setText("TRAVEL AGENCY MANAGEMENT\n");
		ta.setText(ta.getText() + "\n  Customer ID : " + rs2.getInt("cust_id"));
		ta.setText(ta.getText() + "\n First Name:"   + rs2.getString("cust_fname"));
		ta.setText(ta.getText() + "\n Last Name:"    + rs2.getString("cust_lname"));
		ta.setText(ta.getText() + "\n Aadhar no : " + rs2.getString("cust_aadhar"));
		
		ta.setText(ta.getText() + "\n PNR No.: " + rs.getLong("pnr"));
		ta.setText(ta.getText() + "\n Date of Travel: " + rs.getString("date_of_travel"));
		ta.setText(ta.getText() + "\n From  : " + rs.getString("origin"));
		ta.setText(ta.getText() + "\n To  : " + rs.getString("destination"));
		ta.setText(ta.getText() + "\n Ticket Fare: " + rs.getInt("total_fare"));
		}
		
		
		JButton btnNewButton = new JButton("Print Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				ta.print();
			}catch(Exception e2) {
				System.out.println(e2);
			}
			
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(148, 541, 189, 46);
		contentPane.add(btnNewButton);
		
		
		
		try {
			
			addWindowListener(new WindowAdapter() {
				public void  actionPerformed(ActionEvent e){
					try {
						p1.close();
						p2.close();
						con.close();
						
						System.exit(0);
					}catch(Exception ex1) {
						System.out.println(ex1);
					}
					
				}
			});
			}catch(Exception m) {
				System.out.println(m);
			}
		
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}

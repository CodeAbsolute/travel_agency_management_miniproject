package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class Insert extends JFrame {

	private JPanel contentPane;
	static String x;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf5;
	private JTextField tf7;
	private JTextField tf9;
	private JTextField tf2;
	private JTextField tf4;
	private JTextField tf6;
	private JTextField tf8;
	private JTextField tf10;

	/**
	 * Launch the application.
	 */
	static Insert frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Insert();
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
	public Insert() {
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
	     PreparedStatement p1 =con.prepareStatement("insert into user_1(user_name, pass, designation, first_name, last_name,contact_no, address, email_id) values(?,?,?,?,?,?,?,?)");
         PreparedStatement p2 =con.prepareStatement("insert into vehicle(vehicle_id, vehicle_name, vehicle_type, vehicle_seats,fare_per_km) values(?,?,?,?,?)");
	     PreparedStatement p3 =con.prepareStatement("insert into route(route_id,origin,destination,distance) values (?,?,?,?)");
	     PreparedStatement p4 =con.prepareStatement("insert into modes(modename, mode_status) values(?,?)");
	     PreparedStatement p5 =con.prepareStatement("insert into places(place_id, place) values(?,?)");
	     
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lbl1 = new JLabel("label1");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl1.setBounds(51, 124, 144, 37);
		//contentPane.add(lbl1);
		
		JLabel lbl3 = new JLabel("label3");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl3.setBounds(51, 200, 144, 37);
		//contentPane.add(lbl3);
		
		tf1 = new JTextField();
		tf1.setBounds(234, 126, 210, 37);
		//contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lbl2 = new JLabel("label2");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl2.setBounds(567, 126, 144, 37);
		//contentPane.add(lbl2);
		
		JLabel lbl5 = new JLabel("label5");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl5.setBounds(51, 267, 144, 37);
		//contentPane.add(lbl5);
		
		JLabel lbl7 = new JLabel("label7");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl7.setBounds(51, 338, 144, 37);
		//contentPane.add(lbl7);
		
		
		
		JLabel lbl4 = new JLabel("label4");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl4.setBounds(567, 200, 144, 37);
		//contentPane.add(lbl4);
		
		JLabel lbl6 = new JLabel("label6");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl6.setBounds(567, 267, 144, 37);
		//contentPane.add(lbl6);
		
		JLabel lbl8 = new JLabel("label8");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl8.setBounds(567, 338, 144, 37);
		//contentPane.add(lbl8);
		
//		JLabel lbl10 = new JLabel("Your data is Successfully Inserted");
//		lbl10.setBackground(Color.WHITE);
//		lbl10.setForeground(Color.GREEN);
//		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		lbl10.setBounds(567, 414, 483, 156);
//		//contentPane.add(lbl10);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(234, 200, 210, 37);
		//contentPane.add(tf3);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(234, 278, 210, 37);
		//contentPane.add(tf5);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		tf7.setBounds(234, 338, 210, 37);
		//contentPane.add(tf7);
		
		
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(752, 126, 210, 37);
		//contentPane.add(tf2);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(752, 200, 210, 37);
		//contentPane.add(tf4);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(752, 267, 210, 37);
		//contentPane.add(tf6);
		
		tf8 = new JTextField();
		tf8.setColumns(10);
		tf8.setBounds(752, 338, 210, 37);
		//contentPane.add(tf8);
		
		
		
		
		if(x=="Vehicles") {
			
			lbl1.setText("Vehicle Id");
			lbl2.setText("Vehicle Name");
			lbl3.setText("Vehicle Type");
			lbl4.setText("Vehicle Seats");
			
			lbl6.setText("Fare per km");
			
			
			contentPane.add(lbl1);
			contentPane.add(lbl2);
			contentPane.add(lbl3);
			contentPane.add(lbl4);
			
			contentPane.add(lbl6);
			
			
			contentPane.add(tf1);
			contentPane.add(tf2);
			contentPane.add(tf3);
			contentPane.add(tf4);
			
			contentPane.add(tf6);
			
			
		}else if(x=="Routes") {
			
			lbl1.setText("Route Id");
			lbl2.setText("Origin");
			lbl3.setText("Destination");
			lbl4.setText("Distance");
			
			
			
			contentPane.add(lbl1);
			contentPane.add(lbl2);
			contentPane.add(lbl3);
			contentPane.add(lbl4);
			
			
			contentPane.add(tf1);
			contentPane.add(tf2);
			contentPane.add(tf3);
			contentPane.add(tf4);
			
		}
		else if(x=="Places"){
			
			lbl1.setText("Place Id");
			lbl2.setText("Place Name");
			
			
			contentPane.add(lbl1);
			contentPane.add(lbl2);
			
			
			contentPane.add(tf1);
			contentPane.add(tf2);
			
			
		}else if(x == "Modes"){
			lbl1.setText("Mode Name");
			lbl2.setText("Mode Status");
			
			contentPane.add(lbl1);
			contentPane.add(lbl2);
			
			contentPane.add(tf1);
			contentPane.add(tf2);
			
			
		}else if(x == "Users") {
			
			lbl1.setText("Username");
			lbl2.setText("Password");
			lbl3.setText("Designation");
			lbl4.setText("First Name");
			lbl5.setText("Last Name");
			lbl6.setText("Contact No.");
			lbl7.setText("Address");
			lbl8.setText("Email id");
			
		
			contentPane.add(lbl1);
			contentPane.add(lbl2);
			contentPane.add(lbl3);
			contentPane.add(lbl4);
			contentPane.add(lbl5);
			contentPane.add(lbl6);
			contentPane.add(lbl7);
			contentPane.add(lbl8);
			
			contentPane.add(tf1);
			contentPane.add(tf2);
			contentPane.add(tf3);
			contentPane.add(tf4);
			contentPane.add(tf5);
			contentPane.add(tf6);
			contentPane.add(tf7);
			contentPane.add(tf8);
			
	  }else {
			
	        }
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					if(x=="Users") {
						p1.setString(1, tf1.getText());
						p1.setString(2, tf2.getText());
						p1.setString(3, tf3.getText());
						p1.setString(4, tf4.getText());
						p1.setString(5, tf5.getText());
						p1.setLong(6, Integer.parseInt(tf6.getText()));
						p1.setString(7, tf7.getText());
						p1.setString(8, tf8.getText());
						
						p1.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your data is Successfully Inserted");
				}
				
					if(x=="Vehicles") {
						p2.setString(1, tf1.getText());
						p2.setString(2, tf2.getText());
						p2.setString(3, tf3.getText());
						p2.setInt(4, Integer.parseInt(tf4.getText()));
						
						p2.setInt(5, Integer.parseInt(tf6.getText()));
						
						p2.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your data is Successfully Inserted");
				}
					if(x=="Routes") {
						p3.setString(1, tf1.getText());
						p3.setString(2, tf2.getText());
						p3.setString(3, tf3.getText());
						p3.setDouble(4, Double.parseDouble(tf4.getText()));
						
						
						
						p3.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your data is Successfully Inserted");
				}
					if(x=="Modes") {
						p4.setString(1, tf1.getText());
						p4.setString(2, tf2.getText());
						
					    p4.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your data is Successfully Inserted");
				}
					if(x=="Places") {
						p5.setString(1, tf1.getText());
						p5.setString(2, tf2.getText());
						//p5.setString(3, tf3.getText());
					    p5.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your data is Successfully Inserted");
				}
					
				}catch(Exception ex) {
					
					System.out.println(ex);
				JOptionPane.showMessageDialog(null, "Unsuccessfull insertion");
				
				
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(297, 491, 168, 38);
		contentPane.add(btnNewButton);
		
		
		addWindowListener(new WindowAdapter(){
			public void actionPerformed(ActionEvent e2) {
				try {
					
					
					p1.close();
					p2.close();
					p3.close();
					p4.close();
					p5.close();
					con.close();
					System.exit(0);
				}catch(Exception e4) {
					System.out.println(e4);
				}
				
			}
		});
	}catch(Exception e) {
		System.out.println(e);
	}	}
}

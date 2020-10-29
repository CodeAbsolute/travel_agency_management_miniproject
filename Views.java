package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.*;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Views extends JFrame {

	static String x;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	 static Views frame;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					 frame = new Views();
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
	public Views() {
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
		PreparedStatement p1 = con.prepareStatement("select * from route where route_id= ?");
		PreparedStatement p2 = con.prepareStatement("select * from route");
		
		PreparedStatement p3 = con.prepareStatement("select * from modes where mode_id= ?");
		PreparedStatement p4 = con.prepareStatement("select * from modes ");
		
		PreparedStatement p5 = con.prepareStatement("select * from vehicle where vehicle_id= ?");
		PreparedStatement p6 = con.prepareStatement("select * from vehicle");
		
		PreparedStatement p7 = con.prepareStatement("select * from user_1 where user_id= ?");
		PreparedStatement p8 = con.prepareStatement("select * from user_1");

		PreparedStatement p9 = con.prepareStatement("select * from booking_details where booking_id= ?");
		PreparedStatement p10 = con.prepareStatement("select * from booking_details");

		PreparedStatement p11 = con.prepareStatement("select * from places where place_id= ?");
		PreparedStatement p12 = con.prepareStatement("select * from places");
		

		PreparedStatement p13 = con.prepareStatement("select * from customer where cust_id= ?");
		PreparedStatement p14 = con.prepareStatement("select * from customer");
		
		setBounds(100, 100, 984, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(595, 125, 218, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel labelView = new JLabel("VIEWS");
		labelView.setFont(new Font("Times New Roman", Font.BOLD, 40));
		labelView.setHorizontalAlignment(SwingConstants.CENTER);
		labelView.setBounds(20, 102, 441, 164);
		contentPane.add(labelView);
		
		JRadioButton rbtnId = new JRadioButton("ID");
		rbtnId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rbtnId.setBounds(639, 193, 174, 34);
		contentPane.add(rbtnId);
		
		JRadioButton rbtnAll = new JRadioButton("ALL");
		rbtnAll.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rbtnAll.setBounds(835, 193, 73, 34);
		contentPane.add(rbtnAll);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnAll);
		bg.add(rbtnId);
		if(x=="Vehicles") {
			rbtnId.setText("Vehicle Id");
			labelView.setText(x);
		}else if(x=="Routes") {
			rbtnId.setText("Route Id");
			labelView.setText(x);
		}
		else if(x=="Places"){
			rbtnId.setText("Place Id");
			labelView.setText(x);
		}else if(x == "Modes"){
			rbtnId.setText("Mode Id");
			labelView.setText(x);
		}else if(x == "Bookings") {
			rbtnId.setText("Booking Id");
			labelView.setText(x);
		}else if(x == "Users") {
			rbtnId.setText("User Id");
			labelView.setText(x);
		}else if(x == "Customers"){
			rbtnId.setText("Customer Id");
			labelView.setText(x);
			
		}else {
			
		}
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
				if(x=="Routes") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							String routeid= textField.getText();
							p1.setString(1, routeid);
							rs = p1.executeQuery();
						
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p2.executeQuery();
						
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					
					if(x=="Modes") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							int modeid= Integer.parseInt(textField.getText());
							p3.setInt(1, modeid);
							
							rs = p3.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p4.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					if(x=="Vehicles") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							String vehicleid= textField.getText();
							p5.setString(1, vehicleid);
							rs = p5.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							
							 
						}else {
							rs = p6.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					if(x=="Users") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							int userid= Integer.parseInt(textField.getText());
							p7.setInt(1, userid);
							rs = p7.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p8.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					if(x=="Bookings") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							
							int booking_id = Integer.parseInt(textField.getText());
							p9.setInt(1, booking_id);
							rs = p9.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p10.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					if(x=="Places") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							String placeid= textField.getText();
							p11.setString(1, placeid);
							rs = p11.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p12.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
					if(x=="Customers") {
						ResultSet rs;
						if(rbtnId.isSelected()) {
							String custid= textField.getText();
							p13.setString(1, custid);
							rs = p13.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 
						}else {
							rs = p14.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}
					}
					
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(835, 122, 104, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 308, 910, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		
		JLabel lblNewLabel = new JLabel("TRAVEL AGENCY MANAGEMENT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 950, 82);
		contentPane.add(lblNewLabel);
		
		
		
		try {
		
		addWindowListener(new WindowAdapter() {
			public void  actionPerformed(ActionEvent e){
				try {
					p1.close();
					p2.close();
					p3.close();
					p4.close();
					p5.close();
					p6.close();
					p7.close();
					p8.close();
					p9.close();
					p10.close();
					p11.close();
					p12.close();
					p13.close();
					p14.close();
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

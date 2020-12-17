package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.sql.Connection.*;
import java.sql.Date;
import java.text.*;
import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class Agent extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField contact;
	private JTextField aadhar;
	private JTextField email;
	private JTextField total_fare;

	/**
	 * Launch the application.
	 */
	static String x;
	static int y;
	private JButton btnNewButton_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agent frame = new Agent();
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
	public Agent() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
		PreparedStatement p1 = con.prepareStatement("select * from modes");
		PreparedStatement p2 = con.prepareStatement("select * from vehicle where mode_name = ? and vehicle_status ='active'");
		
		PreparedStatement p3 = con.prepareStatement("select place from places where place_status = 'active' ");
		PreparedStatement p4 = con.prepareStatement("select place from places where place_status ='active' and place != ? ");
		
		
		PreparedStatement p5 = con.prepareStatement("insert into customer( cust_fname, cust_lname,cust_contact,cust_address, cust_aadhar,cust_email) values(?, ?, ?, ?, ?, ?)");
		PreparedStatement p6 = con.prepareStatement("insert into booking_details(date_of_travel,origin,destination,total_fare,cust_id, agent_id,vehicle_id) values (?,?,?,?,?,?,?)");
		
		PreparedStatement p7 = con.prepareStatement("select cust_id, cust_aadhar from customer");
		
		
		PreparedStatement p8 = con.prepareStatement("select fare_per_km, vehicle_id from vehicle where vehicle_name = ?");
		PreparedStatement p9 = con.prepareStatement("select route_id,distance,route_status from route where origin=? and destination = ? ");
		
		PreparedStatement p10 = con.prepareStatement("select pnr from booking_details where date_of_travel = ? and cust_id =?");
		PreparedStatement p11 = con.prepareStatement("update vehicle_avail set seats_avail = seats_avail -1 where vehicle_id =? and travel_date =? and route_id =?");
		
		PreparedStatement p12 = con.prepareStatement("select seats_avail from vehicle_avail where travel_date =? and vehicle_id =?");
		
		setTitle("AGENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 951, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Routes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View Routes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Views v = new Views();
				Views.x = "Routes";
				Views.main(null);
				
			
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Places");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View Places");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				Views v = new Views();
				Views.x = "Places";
				Views.main(null);
			
			
			
			
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Vehicles");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("View Vehicles");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Views v = new Views();
				Views.x = "Vehicles";
				Views.main(null);
			
			
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Ticket Cancelling");
		mnNewMenu_3.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
			
				
				Ticket t = new Ticket();
				Ticket.main(null);
				
				
			
			
			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("Booking Details");
		mnNewMenu_4.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
			
			Views v = new Views();
			Views.x="Bookings";
			Views.main(null);
			
			
			}
		});
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_4);
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_5 = new JMenu("Logout");
		mnNewMenu_5.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
			
			Login l=new Login();
			
			Login.main(null);
			setVisible(false);
			
			
			}
		});
		menuBar.add(mnNewMenu_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 433, 557);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Details:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 10, 229, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 51, 119, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 102, 119, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact no.");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(20, 154, 119, 22);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(20, 219, 119, 22);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Aadhar no.");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(20, 321, 119, 22);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email Id");
		lblNewLabel_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4_1.setBounds(20, 372, 119, 28);
		panel.add(lblNewLabel_1_4_1);
		
		fname = new JTextField();
		fname.setBounds(149, 51, 229, 28);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(149, 102, 229, 28);
		panel.add(lname);
		
		contact = new JTextField();
//		JLabel lblcontact = new JLabel("");
//		lblcontact.setForeground(Color.RED);
//		lblcontact.setBounds(149, 182, 229, 22);
//		panel.add(lblcontact);
//		
//		
//		contact.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//			try {
//				int k = Integer.parseInt(contact.getText());
//				lblcontact.setText(" ");
//				
//			}catch(NumberFormatException e2){
//				lblcontact.setText("Invalid Number");
//			}
//			
//			
//			}
//		});
		contact.setColumns(10);
		contact.setBounds(149, 158, 229, 23);
		panel.add(contact);
		
		JTextArea address = new JTextArea();
		address.setBounds(149, 219, 229, 67);
		panel.add(address);
		
		aadhar = new JTextField();
		aadhar.setColumns(10);
		aadhar.setBounds(149, 320, 229, 23);
		panel.add(aadhar);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(149, 374, 229, 23);
		panel.add(email);
		
		panel.setOpaque(false);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(453, 32, 475, 557);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		
		JLabel lblJourneyDetails = new JLabel("Journey Details:");
		lblJourneyDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblJourneyDetails.setBackground(SystemColor.menu);
		lblJourneyDetails.setBounds(10, 10, 229, 22);
		panel_1.add(lblJourneyDetails);
		
		JLabel lblNewLabel_1_5 = new JLabel("From");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(10, 51, 119, 25);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("To");
		lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5_1.setBounds(10, 106, 119, 25);
		panel_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Mode");
		lblNewLabel_1_5_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5_2.setBounds(10, 162, 119, 25);
		panel_1.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Vehicle");
		lblNewLabel_1_5_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5_3.setBounds(10, 220, 119, 25);
		panel_1.add(lblNewLabel_1_5_3);
		
		JComboBox desbox = new JComboBox();
		desbox.setBounds(177, 110, 229, 21);
		panel_1.add(desbox);
		
		JComboBox modebox = new JComboBox();
		
		modebox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		//modebox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Airways", "Roadways"}));
		modebox.setBounds(177, 166, 229, 21);
		panel_1.add(modebox);
		
		
		
		JLabel lblNewLabel_1_5_3_1 = new JLabel("Date");
		lblNewLabel_1_5_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5_3_1.setBounds(10, 282, 119, 25);
		panel_1.add(lblNewLabel_1_5_3_1);
		
		JComboBox orbox = new JComboBox();
		JDateChooser date = new JDateChooser();;
		
		orbox.setBounds(177, 55, 229, 21);
		panel_1.add(orbox);
		
		
		
		
		date.getCalendarButton().setHorizontalAlignment(SwingConstants.LEADING);
		date.setBounds(177, 288, 229, 19);
		panel_1.add(date);
		date.setDateFormatString("yyyy-MM-dd");
		
		total_fare = new JTextField();
		total_fare.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		total_fare.setBounds(182, 344, 178, 28);
		panel_1.add(total_fare);
		total_fare.setColumns(10);
		total_fare.setEditable(false);
		
		JLabel lblNewLabel_1_5_3_1_1 = new JLabel("Total Fare");
		lblNewLabel_1_5_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5_3_1_1.setBounds(10, 347, 129, 25);
		panel_1.add(lblNewLabel_1_5_3_1_1);
		
		ResultSet r; 
		r = p3.executeQuery();
				
		while(r.next()) {
			String item1 = r.getString("place");
			orbox.addItem(item1);
    	}
		orbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					ResultSet r2;
					String selectedItem1 = orbox.getSelectedItem().toString();
					p4.setString(1, selectedItem1);
					
					r2 = p4.executeQuery();
					desbox.removeAllItems();
					while(r2.next()) {
						String item2 = r2.getString("place");
						
						desbox.addItem(item2);
					}
					
					
				}catch(Exception e5) {
					System.out.println(e5);
				}
		}
		});
	
		JComboBox vehiclebox = new JComboBox();
		vehiclebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet a;
					int fpk =0;
					double dist=0.0 ;
					String status = new String();
					
					p8.setString(1,vehiclebox.getSelectedItem().toString());
					a = p8.executeQuery();
					a.next();
					fpk = a.getInt("fare_per_km");
					
					p9.setString(1,orbox.getSelectedItem().toString());
					p9.setString(2,desbox.getSelectedItem().toString());
					
					a = p9.executeQuery();
					
					
					
					if(a.next()) {
						

						dist = a.getDouble("distance");
						status = a.getString("route_status");
						if(status.equals("active")) {
							total_fare.setText(String.valueOf(fpk*dist));
						}else {
						throw new IOException();	
						}
					}
					else {
						throw new IOException();	
					}
					
					
					
				}catch(IOException p) {
					
					JOptionPane.showMessageDialog(null, "Route does not exist");
				}catch(Exception k){
//					k.printStackTrace();
					System.out.println(k);
				}
			
			
			}
		});
		vehiclebox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		//vehiclebox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		vehiclebox.setBounds(177, 224, 229, 21);
		panel_1.add(vehiclebox);
		
		
		
		ResultSet rs; 
		rs = p1.executeQuery();
		
		
		while(rs.next()) {
			String item = rs.getString("modename");
			modebox.addItem(item);
		}
		modebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
			{
				ResultSet rs2;
				String selectedItem = modebox.getSelectedItem().toString();
				p2.setString(1, selectedItem);
				
				rs2 = p2.executeQuery();
				vehiclebox.removeAllItems();
				while(rs2.next()) {
					String item2 = rs2.getString("vehicle_name");
					
					vehiclebox.addItem(item2);
				}
				
				
			}catch(Exception e1) {
				System.out.println(e1);
			}
			
			}
		});
		
		
		
		JButton book_ticket = new JButton("Book Ticket");
		book_ticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rs;
				rs = p7.executeQuery();
				
				int cust_id = 0;
//				
				long i = Long.parseLong(contact.getText());
				
				long j = Long.parseLong(aadhar.getText());
				String em = " ";
				String fn = " ";
				
				String ln = " ";
				
				String ad = " ";
				
				
				while(rs.next()) {
					
					if(j==rs.getLong("cust_aadhar")) {
						cust_id = rs.getInt("cust_id");
						break;
					}
				}
				if(cust_id == 0) {
					
					
					ad = address.getText();
					fn =fname.getText();
					em = email.getText();
					ln =lname.getText();
					
					
					p5.setString(1, fn);
					p5.setString(2,ln);
					p5.setLong(3,i);
					p5.setString(4,ad);
					p5.setLong(5,j);
					p5.setString(6, em);
					
					p5.executeUpdate();
					rs = p7.executeQuery();
					
					while(rs.next()) {
						
						if(j==rs.getLong("cust_aadhar")) {
							cust_id = rs.getInt("cust_id");
							break;
						}
					}
				}
				
				
				int fpk =0;
				double dist=0.0 ;
				String route_id= null;
				String vehicle_id ;
				
				p8.setString(1,vehiclebox.getSelectedItem().toString());
				rs = p8.executeQuery();
				rs.next();
				fpk = rs.getInt("fare_per_km");
				vehicle_id = rs.getString("vehicle_id");
				
				p9.setString(1,orbox.getSelectedItem().toString());
				p9.setString(2,desbox.getSelectedItem().toString());
				rs = p9.executeQuery();
				
				rs.next();
				dist = rs.getDouble("distance");
				route_id = rs.getString("route_id");
				
				p12.setString(2, vehicle_id);
				p12.setString(1,((JTextField)date.getDateEditor().getUiComponent()).getText());
				rs =p12.executeQuery();
				rs.next();
				if(rs.getInt("seats_avail")>0) {
					p6.setString(1,((JTextField)date.getDateEditor().getUiComponent()).getText());
					p6.setString(2,orbox.getSelectedItem().toString());
					p6.setString(3,desbox.getSelectedItem().toString());
					p6.setDouble(4,(fpk*dist));
					p6.setInt(5,cust_id);
					p6.setInt(6, y);
					p6.setString(7, vehicle_id);
					p6.executeUpdate();
					
					p11.setString(1, vehicle_id);
					p11.setString(2,((JTextField)date.getDateEditor().getUiComponent()).getText());
					p11.setString(3, route_id);
					p11.executeUpdate();
					p10.setString(1,((JTextField)date.getDateEditor().getUiComponent()).getText());
					p10.setInt(2,cust_id);
					
					JOptionPane.showMessageDialog(null, "Ticket booking successfull ");
					
					ResultSet rs3 =p10.executeQuery();
					rs3.next();
					long l = rs3.getLong("pnr");
					ticket1 t1 = new ticket1();
					ticket1.pnr =l;
					ticket1.main(null);
					//panel_1.add(btnNewButton_1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Seats Unavailable");
				}
				
				
				
				
			}catch(Exception n) {
				
				JOptionPane.showMessageDialog(null, "Ticket booking unsuccessfull ");
				//System.out.println(n);
				
			}
				
			}
		});
		book_ticket.setFont(new Font("Times New Roman", Font.BOLD, 20));
		book_ticket.setBounds(251, 410, 173, 43);
		panel_1.add(book_ticket);
		
		JLabel lblNewLabel_2 = new JLabel("Rs.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(361, 344, 31, 28);
		panel_1.add(lblNewLabel_2);
		
		 JLabel lblNewLabel_3 = new JLabel("New label");
		 lblNewLabel_3.setBounds(0, 23, 951, 576);
		 ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\8.jpg");
	     Image img = imgIcon.getImage();
	     Image ScaleImg = img.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight(), img.SCALE_SMOOTH);
	     ImageIcon ScaledImage = new ImageIcon(ScaleImg);
	     lblNewLabel_3.setIcon(ScaledImage);
	     contentPane.add(lblNewLabel_3);
		
		
		
		btnNewButton_1 = new JButton("Generate ticket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
				}catch(Exception k) {
					System.out.println(k);
				}
				
			
			
			
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(227, 475, 197, 37);
		//panel_1.add(btnNewButton_1);
		
		
		
		
		
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
		
		
		setResizable(false);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

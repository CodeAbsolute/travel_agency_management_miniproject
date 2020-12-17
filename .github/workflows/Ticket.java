package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Ticket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
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
	public Ticket() {
		
		
		try {
			
			
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
        
        PreparedStatement p1 = con.prepareStatement("update booking_details set ticket_status = 'Cancelled' where ticket_status = 'valid' and pnr = ? ");
        
		PreparedStatement p2 = con.prepareStatement("select  cust_id, cust_fname, cust_lname, origin, destination, date_of_travel from customer inner join  booking_details using (cust_id) where booking_details.pnr = ?");
		
		PreparedStatement p3 = con.prepareStatement("select  vehicle_id,date_of_travel,origin,destination from booking_details where pnr =?");
		
		PreparedStatement p5 = con.prepareStatement("select route_id from route where origin = ? and destination =?");
		
		PreparedStatement p4 = con.prepareStatement("update vehicle_avail set seats_avail = seats_avail +1 where vehicle_id =? and travel_date =? and route_id =?");
		
		
		
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ticket Cancelling");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 455, 86);
		contentPane.add(lblNewLabel);
		setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PNRno.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 132, 164, 39);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(189, 132, 274, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton Search = new JButton("");
		Search.setSelectedIcon(new ImageIcon("E:\\SEM 3\\miniproject\\ICONS\\Search_icon.jpg"));
		Search.setIcon(new ImageIcon("E:\\SEM 3\\miniproject\\ICONS\\Search_icon.jpg"));
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			
				p2.setString(1, textField.getText());
				ResultSet rs2 = p2.executeQuery();
				
				
				
				//scrollPane.setRowHeaderView(table);
				
				
				//contentPane.add(table);
				table.setModel(DbUtils.resultSetToTableModel(rs2));
			
			
			
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			}
		});
		Search.setBounds(475, 132, 42, 42);
		contentPane.add(Search);
		
		JButton btnNewButton = new JButton("Cancel Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					p1.setLong(1, Long.parseLong(textField.getText()));
					String route_id = null;
					int x = 0;
					x = p1.executeUpdate();
					
					if(x!=0) {
						
						p3.setString(1, textField.getText());
						
						ResultSet rs3 = p3.executeQuery();
						ResultSet rs4;
						rs3.next();
						p5.setString(1, rs3.getString("origin"));
						p5.setString(2, rs3.getString("destination"));
						rs4 = p5.executeQuery();
						rs4.next();
					    p4.setString(1, rs3.getString("vehicle_id"));
//						p4.setDate(2,date1);
					    p4.setString(2, rs3.getString("date_of_travel"));
					    p4.setString(3, rs4.getString("route_id"));
						p4.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Ticket Cancelling Successfull");
					}else {
						//JOptionPane.showMessageDialog(null, "Enter Correct Pnr no.");
						JOptionPane.showMessageDialog(null, "Ticket Cancelling unsuccessfull");
					}
			
			}catch(Exception e1) {
				
				System.out.println(e1);
				
			}
			
			
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(248, 297, 186, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_label = new JScrollPane();
		scrollPane_label.setBounds(10, 181, 495, 23);
		contentPane.add(scrollPane_label);
		
		table_1 = new JTable();
		scrollPane_label.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Customer ID", "First Name", "Last Name", "Origin", "Destination", "Travel Date"
				}
			));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		table.setBounds(10, 204, 495, 16);
		contentPane.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 542, 403);
		 ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\2.jpeg");
	     Image img = imgIcon.getImage();
	     Image ScaleImg = img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(), img.SCALE_SMOOTH);
	     ImageIcon ScaledImage = new ImageIcon(ScaleImg);
	     lblNewLabel_2.setIcon(ScaledImage);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		
		
		try {
			
			addWindowListener(new WindowAdapter() {
				public void  actionPerformed(ActionEvent e2){
					try {
						p1.close();
						p2.close();
						p3.close();
						p4.close();
						p5.close();
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

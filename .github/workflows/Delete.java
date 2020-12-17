package travel_agency;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
public class Delete extends JFrame {

	static String x;
	private JPanel contentPane;
	private JTextField tf1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
			PreparedStatement p1 = con.prepareStatement("update user_1 set user_status = 'inactive' where user_id =?");
			PreparedStatement p2 = con.prepareStatement("update route set route_status = 'inactive' where route_id =?");
			PreparedStatement p3 = con.prepareStatement("update vehicle set vehicle_status = 'inactive' where vehicle_id =?");
			PreparedStatement p4 = con.prepareStatement("update places set place_status = 'inactive' where place_id =?");
			PreparedStatement p5 = con.prepareStatement("update modes set mode_status = 'inactive' where mode_id =?");
		
			
			PreparedStatement p6 = con.prepareStatement("select * from route where route_status = 'active'");
			PreparedStatement p7 = con.prepareStatement("select * from modes where mode_status = 'active' ");
			PreparedStatement p8 = con.prepareStatement("select * from vehicle where vehicle_status = 'active'");
			PreparedStatement p9 = con.prepareStatement("select * from user_1 where user_status = 'active'");
			PreparedStatement p10 = con.prepareStatement("select * from places where place_status = 'active'");
			
			PreparedStatement p11 = con.prepareStatement("update route set route_status = 'inactive' where origin =? or destination = ?");
			PreparedStatement p12 = con.prepareStatement("select place from places where place_id = ?");
			PreparedStatement p13 = con.prepareStatement("delete from vehicle_avail where route_id = ?");
			
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(226, 207, 171, 32);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		
		setResizable(false);

		JLabel lblNewLabel = new JLabel("TRAVEL AGENCY MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 773, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lbl = new JLabel("DELETE ");
		lbl.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lbl.setToolTipText("");
		lbl.setBounds(27, 126, 756, 43);
		contentPane.add(lbl);
		
		JLabel lbl1 = new JLabel("Enter ID");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl1.setBounds(29, 208, 169, 28);
		contentPane.add(lbl1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 276, 743, 219);
		//contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		JButton btn = new JButton("Delete");
		btn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					ResultSet rs;
					int count =0;
				if(x == "Users") {
					p1.setInt(1, Integer.parseInt(tf1.getText()));
					 count = p1.executeUpdate();
					 rs = p9.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Routes") {
					p2.setString(1, tf1.getText());
					count = p2.executeUpdate();
					
					p13.setString(1,tf1.getText());
					 p13.executeUpdate();
					 rs = p6.executeQuery();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Vehicles") {
					p3.setString(1, tf1.getText());
					count =p3.executeUpdate();
					 rs = p8.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Places") {
					ResultSet r;
					String y;
					p12.setString(1, tf1.getText());
					
					p4.setString(1, tf1.getText());
					count = p4.executeUpdate();
					
					 rs = p10.executeQuery();
					 
					 r = p12.executeQuery();
					 r.next();
					 y= r.getString("place");
					 p11.setString(1, y);
					 p11.setString(2,y);
					 p11.executeUpdate();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Modes") {
					p5.setInt(1, Integer.parseInt(tf1.getText()));
					count =p5.executeUpdate();
					 rs = p7.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				if(count>0)
				JOptionPane.showMessageDialog(null, " Data is Successfully Deleted");
				else
					throw new IOException();
				}catch(Exception n) {
					
					JOptionPane.showMessageDialog(null, " Deletion Unsuccessfull");
					
				}
			
			
			}
		});
		btn.setBounds(441, 206, 108, 32);
		contentPane.add(btn);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				try {
					contentPane.add(scrollPane);
					ResultSet rs;
				if(x == "Users") {
			
					 rs = p9.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Routes") {
					
					 rs = p6.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Vehicles") {
					
					 rs = p8.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}else if(x == "Places") {
					rs = p10.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
				}else if(x == "Modes") {
					
					
					 rs = p7.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}}catch(Exception e3) {
					
			}}});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(562, 206, 76, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 793, 520);
		
		contentPane.add(lblNewLabel_1);
		ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\11.jpg");
	     Image img = imgIcon.getImage();
	     Image ScaleImg = img.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(), img.SCALE_SMOOTH);
	     ImageIcon ScaledImage = new ImageIcon(ScaleImg);
	     lblNewLabel_1.setIcon(ScaledImage);
		
		if(x == "Users") {
			lbl.setText("Delete User");
			lbl1.setText("Enter User Id");
			
		}else if(x == "Routes") {
			lbl.setText("Delete Route");
			lbl1.setText("Enter Route Id");
			
		}else if(x == "Vehicles") {
			lbl.setText("Delete Vehicle");
			lbl1.setText("Enter Vehicle Id");
			
		}else if(x == "Places") {
			
			
			lbl.setText("Delete Place");
			lbl1.setText("Enter Place Id");
		}else if(x == "Modes") {
			lbl.setText("Delete Mode");
			lbl1.setText("Enter Mode Id");
		}else {
			
		}
		
		addWindowListener(new WindowAdapter(){
			public void actionPerformed(ActionEvent e2) {
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
					
					con.close();
					System.exit(0);
				}catch(Exception e4) {
					System.out.println(e4);
				}
				
			}
		});
	
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}

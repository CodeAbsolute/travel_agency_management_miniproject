package travel_agency;
import travel_agency.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class Admin extends JFrame {

 private JPanel contentPane;

 /**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Admin frame=new Admin();
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
public Admin() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 762, 490);
contentPane = new JPanel();
contentPane.setBackground(Color.WHITE);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JMenuBar menuBar = new JMenuBar();
menuBar.setBackground(UIManager.getColor("MenuBar.shadow"));
menuBar.setBounds(0, 0, 748, 42);
contentPane.add(menuBar);
JMenu mnNewMenu = new JMenu("Users");
menuBar.add(mnNewMenu);
JMenuItem mntmNewMenuItem = new JMenuItem("Create User");
mnNewMenu.add(mntmNewMenuItem);
JSeparator separator = new JSeparator();
mnNewMenu.add(separator);
JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete User");
mnNewMenu.add(mntmNewMenuItem_1);
JMenu mnRoute = new JMenu("Route");
menuBar.add(mnRoute);
JMenuItem mntmAddRoute = new JMenuItem("Add Route");
mnRoute.add(mntmAddRoute);
JSeparator separator_2 = new JSeparator();
mnRoute.add(separator_2);
JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Delete Route");
mnRoute.add(mntmNewMenuItem_1_1);
JMenu mnVehicle = new JMenu("Vehicle");
menuBar.add(mnVehicle);
JMenuItem mntmAddVehicle = new JMenuItem("Add Vehicle");
mnVehicle.add(mntmAddVehicle);
JSeparator separator_3 = new JSeparator();
mnVehicle.add(separator_3);
JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Delete Vehicle");
mnVehicle.add(mntmNewMenuItem_1_1_1);
JMenu mnModesOfTransportation = new JMenu("Modes of Transportation");
menuBar.add(mnModesOfTransportation);
JMenuItem mntmAddMode = new JMenuItem("Add Mode");
mnModesOfTransportation.add(mntmAddMode);
JSeparator separator_4 = new JSeparator();
mnModesOfTransportation.add(separator_4);
JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Delete Mode");
mnModesOfTransportation.add(mntmNewMenuItem_1_1_1_1);


JButton btnNewButton = new JButton("View Routes");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	Views v1 = new Views();
	Views.x = "Routes";
	v1.main(null);
	
}
});

btnNewButton.setBounds(27, 140, 145, 34);
contentPane.add(btnNewButton);
JButton btnNewButton_1 = new JButton("View Vehicles");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	Views v1 = new Views();
	Views.x = "Vehicles";
	v1.main(null);
	
}
});
btnNewButton_1.setBounds(265, 358, 145, 34);
contentPane.add(btnNewButton_1);
JButton btnNewButton_1_1 = new JButton("View Modes");
btnNewButton_1_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Views v1 = new Views();
		Views.x = "Modes";
		v1.main(null);
	
	}
});
btnNewButton_1_1.setBounds(117, 260, 145, 34);
contentPane.add(btnNewButton_1_1);
JButton btnNewButton_1_2 = new JButton("Booking Logs");
btnNewButton_1_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	Views v1 = new Views();
	Views.x = "Bookings";
	v1.main(null);
}
});
btnNewButton_1_2.setBounds(509, 140, 145, 34);
contentPane.add(btnNewButton_1_2);
JButton btnNewButton_1_3 = new JButton("Edit Charges");
btnNewButton_1_3.setBounds(418, 260, 145, 34);
contentPane.add(btnNewButton_1_3);

JButton btnViewPlaces = new JButton("View Places");
btnViewPlaces.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Views v1 = new Views();
		Views.x = "Places";
		v1.main(null);
		
	}
});
btnViewPlaces.setBounds(265, 114, 145, 34);
contentPane.add(btnViewPlaces);
JButton btnUser = new JButton("View Users");
btnUser.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Views v1 = new Views();
		Views.x = "Users";
		v1.main(null);
	}
});
btnUser.setBounds(239, 195, 145, 34);
contentPane.add(btnUser);
JButton btnCustomer = new JButton("View Customers");
btnCustomer.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Views v1 = new Views();
		Views.x = "Customers";
		v1.main(null);
	}
});
btnCustomer.setBounds(75, 327, 145, 34);
contentPane.add(btnCustomer);
}
}
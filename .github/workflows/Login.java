package travel_agency;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

 

    /**
     * Launch the application.
     */
    
    static Login frame ;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame=new Login();
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
    public  Login() {
        
        try {
            
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
        Statement st=con.createStatement();
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 753, 474);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel title = new JLabel("TRAVEL AGENCY MANAGEMENT");
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(100, 22, 520, 65);
        contentPane.add(title);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblusername.setHorizontalAlignment(SwingConstants.CENTER);
        lblusername.setBounds(145, 122, 117, 44);
        contentPane.add(lblusername);
        
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField.setBounds(308, 129, 249, 35);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPassword.setBounds(145, 189, 117, 44);
        contentPane.add(lblPassword);
        
        
        passwordField = new JPasswordField();
      
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordField.setBounds(308, 196, 249, 34);
        contentPane.add(passwordField);
        
        JRadioButton rbtnadmin = new JRadioButton("Admin");
        rbtnadmin.setForeground(new Color(0, 0, 0));
        rbtnadmin.setBackground(new Color(255, 255, 255));
        rbtnadmin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rbtnadmin.setBounds(308, 282, 109, 23);
        contentPane.add(rbtnadmin);
        
        JRadioButton rbtnagent = new JRadioButton("Agent");
        rbtnagent.setBackground(new Color(255, 255, 255));
        rbtnagent.setForeground(new Color(0, 0, 0));
        rbtnagent.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rbtnagent.setBounds(448, 282, 109, 23);
        contentPane.add(rbtnagent);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbtnagent);
        bg.add(rbtnadmin);
        
        JButton btnlogin = new JButton("LOGIN");
        btnlogin.setForeground(Color.WHITE);
        btnlogin.setBackground(Color.BLACK);
     
        btnlogin.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	
            	 
                try {
                	ResultSet rs = st.executeQuery( "select user_name,pass,designation,user_status,user_id from user_1");
                    String user_name= textField.getText();
                    String password= new String(passwordField.getPassword());
                    String designation ;
                    
                    String user_name1="";
                    String password1="",designation1="",status="";
                    
                    int count = 0;
                    if(rbtnadmin.isSelected())
                    {
                      designation="admin";
                    }
                    
                    else
                    {
                        designation="agent";
                    }
                    
                    
                    while(rs.next())
                    {
                       user_name1 = rs.getString("user_name");
                       password1 = rs.getString("pass");
                       designation1 = rs.getString("designation");
                       status = rs.getString("user_status");
                       
                       if(user_name.equals(user_name1) && password.equals(password1) && designation.equals(designation1) && status.equals("active"))
                       {
                           
                           count++;
                           break;
                           
                       }
                       
                       else
                       {
                    	 
                       }
                    }
                    
                   
                      
                       if(count==1)
                       {
                    	   
                           frame.setVisible(false);
                           if(designation.equals("admin"))
                           {
                                Admin ad=new Admin();
                                Admin.y = rs.getInt("user_id");
                                setVisible(false);
                                Admin.main(null);
                                
                           }
                           
                           else
                           {
                        	   
                             Agent ag = new Agent();
                             Agent.y = rs.getInt("user_id");
                             Agent.main(null);
                             
                           }
                           
                          
                           
                       }
                       else {
                    	   JOptionPane.showMessageDialog(null, "Invalid Login Credentials!!");
                    	 
                    	   
                       }
                       
                       
                   }
                   
                   catch(Exception ex)
                   {
                       System.out.println(ex);
                   }
                   
            	 }
          
           });
        
       
        
       
           
           btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 17));
           btnlogin.setBounds(156, 330, 117, 44);
           contentPane.add(btnlogin);
           
           JCheckBox chckbxNewCheckBox = new JCheckBox("show password");
           chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
           chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
           chckbxNewCheckBox.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
           		if(chckbxNewCheckBox.isSelected()) {
           			passwordField.setEchoChar((char)0);
           		}else {
           			passwordField.setEchoChar('*');
           		}
           	}
           });
           chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
           chckbxNewCheckBox.setBounds(308, 247, 134, 21);
           contentPane.add(chckbxNewCheckBox);
            
        setResizable(false);
           
           JButton btnNewButton = new JButton("Forgot Password?");
           btnNewButton.setForeground(Color.WHITE);
           btnNewButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		
           		forgot_password fp = new forgot_password();
           		forgot_password.main(null);
           	}
           });
           btnNewButton.setBackground(Color.BLACK);
           btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
           btnNewButton.setBounds(323, 339, 207, 28);
           contentPane.add(btnNewButton);
           
           JLabel lblNewLabel = new JLabel("New label");
           lblNewLabel.setBounds(0, 0, 749, 446);
           ImageIcon imgIcon = new ImageIcon("C:\\Users\\mahes\\Downloads\\1.jpeg");
           Image img = imgIcon.getImage();
           Image ScaleImg = img.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), img.SCALE_SMOOTH);
           ImageIcon ScaledImage = new ImageIcon(ScaleImg);
           lblNewLabel.setIcon(ScaledImage);
           
           contentPane.add(lblNewLabel);
           
           JLabel label = new JLabel("New label");
           label.setBounds(115, 252, 45, 13);
           contentPane.add(label);
           
           
           
           
           addWindowListener(new WindowAdapter(){
   			public void actionPerformed(ActionEvent e2) {
   				try {
   					st.close();
   		           con.close();
   				}catch(Exception e4) {
   					System.out.println(e4);
   				}
   				
   			}
   		});
           
         
        }
           
           catch(Exception e)
           {
               System.out.println(e);    
           }
        
        
        
       }
   }
        
        
        
        
        
        
        
        
        
        
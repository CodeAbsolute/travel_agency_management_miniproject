package travel_agency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ticket_update {

	public static void main(String[] args) {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
		     PreparedStatement p1 =con.prepareStatement("call ticket_update()");
		     p1.executeQuery();
		     p1.close();
		     con.close();
		
		     
		
		     
		
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}

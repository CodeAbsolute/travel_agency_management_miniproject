package travel_agency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cron_seat_avail {

	public static void main(String[] args) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_agency_management","root","1234");
		     PreparedStatement p1 = con.prepareStatement("call daywise_seat_availability(?, ?, ?,?)");
			
		     PreparedStatement p2 = con.prepareStatement("select vehicle_id, vehicle_seats from vehicle where vehicle_status ='active'");
		     PreparedStatement p3 = con.prepareStatement("select route_id from route where route_status = 'active'");
		     int x,y;
		     ResultSet rs ,rs1;
		     x=30;
		    	 rs1 = p2.executeQuery();
		    	 while(rs1.next()) {
		    		 
		    		 rs =p3.executeQuery();
			    	 while(rs.next()) {
			    		 p1.setString(1, rs1.getString("vehicle_id"));
			    		 p1.setInt(2, rs1.getInt("vehicle_seats"));
			    		 p1.setInt(3, x);
			    		 p1.setString(4, rs.getString("route_id"));
			    		 p1.executeQuery();
			    	 }
		    	
		    	 }
		     
		     
		     
		     p1.close();
		     p2.close();
		     p3.close();
			 con.close();
			  
		}catch(Exception e) {
			System.out.println(e);
			
		}

	}

}

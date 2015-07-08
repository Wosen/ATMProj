package atmPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import atmPackage.DBConnection;


public class DBatm {
	
	 public String readblnc(int pinNmbr){   
		 int balance = 0;
		 try{			 
			 Connection con = DBConnection.getConnection();
			 Statement st = con.createStatement();		    
			 ResultSet rs = st.executeQuery("SELECT pinNbr, balance FROM atmtable WHERE pinNbr = '"+pinNmbr+"'");			 
			 
			 if(rs.next()){				 
				 balance = rs.getInt("balance");
				 return balance + "";				 
			 }	 
			 
			 rs.close();
			 st.close();
			 con.close();
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources		    
		 }//end try	
		return null;		 
	}		 
	 
	 public void updateBlnc(int pinNmbr , int blncAmnt){   
		 try{			 
			 Connection con = DBConnection.getConnection();
			 Statement st = con.createStatement();			 
			 String sql = "update atmtable set balance='"+blncAmnt+"' where pinNbr = '"+pinNmbr+"'";						 		
			 st.executeUpdate(sql);			 			 
			 
			 st.close();
			 con.close();
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources		    
		 }//end try			 
	}
}

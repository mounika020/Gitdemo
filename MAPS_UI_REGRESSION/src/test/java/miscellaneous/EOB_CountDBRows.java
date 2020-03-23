package miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EOB_CountDBRows {
	
	static String userName = "maps_read";
	static String password = "z4qasputHu";
	static String url = "jdbc:sqlserver://10.178.61.241:1433;databaseName=DBSET1624;database=MAPS";
	
	public static void CountRows_EOBPlanRuleException(int option, int rowCnt) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
		int count=0;
		int RC = rowCnt;
		System.out.println (option);
	   // String query = "select * from [group] where GroupNumber=" +option+ "";
	    String query = "select count(*)  from dbo.EOBplanruleexception";
	    System.out.println (query);
	      ResultSet result = stmt.executeQuery(query);
	      try{
	    	  while (result.next()) {
	            		           
	            count++;
  
	          } 
	    	  System.out.println("No.of Rows :" + count);
	      } catch (SQLException ex) {
			        System.out.println(ex);
			      }


	           
	          if (RC == count){
				System.out.println("Pass");
			}
				else	{
					System.out.println("Fail");
			}
	          result.close();
	      }  
	      



}

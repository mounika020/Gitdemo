package miscellaneous;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pageObjects.EOBPage;
import utilities.Constants;

public class EOB_DBConnection {
	
	static String userName = "maps_read";
	static String password = "z4qasputHu";
	static String url = "jdbc:sqlserver://10.178.61.240:1433;databaseName=DBSET1624;database=MAPS";
	
	public static int CountRows_EOBPlanRuleException() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
//need to change the below query to join query
		String query = "select * from eobPlanRuleException";
	    System.out.println (query);
	      ResultSet result = stmt.executeQuery(query);
	      int count=0;
	      while (result.next()){
              count = result.getInt(1);
          }
          System.out.println("Number of rows in Database:"+count);
          return count;
      }
	
	




}	                
        
	
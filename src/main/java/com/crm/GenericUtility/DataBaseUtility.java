package com.crm.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	 Driver driver;
	Connection con=null;
	
	public void connectToDB() throws SQLException
	{
	     driver = new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUsername, IpathConstants.dbpassword);
		
		
	}
		
	public String executeQueryAndGetData(String query,int columnNo,String Expdata) throws SQLException	
	{
		 ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnNo);
		    if(data.equalsIgnoreCase(Expdata))
		    {
		    	flag=true;
		    	break;
		    	
		    }
	    }
	   if(flag==true) //or if(flag)
	   {
		   System.out.println("--Data is verified--");
		   return Expdata;
	   }
	   else 
	   {
		   System.out.println("Data is not present");
		  return "";
	   }
	}
	   
	   
	   public void closeDB() throws SQLException
	   {
		   con.close();
	   }
	

}

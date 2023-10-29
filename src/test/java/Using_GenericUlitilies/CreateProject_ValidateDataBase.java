package Using_GenericUlitilies;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_Api;
import com.crm.GenericUtility.EndPointLibrary;
import com.crm.GenericUtility.RestAssuredLibrary;

import Pojo.Pojoclass_createProject;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProject_ValidateDataBase extends BaseClass_Api {

	@Test
	public void createProj() throws SQLException
	{
		//step1: create pre requisites
		Pojoclass_createProject pcp = new Pojoclass_createProject("Sonu", "tyss", "Ongoing", 6);
		
		//step2 : send the request
		Response resp=given().spec(reqst).body(pcp)
		  .when().post(EndPointLibrary.createProject);
		  
		  //step:3 capture project Id
		        String expData=rLib.getJsonData(resp, "projectId");
		        System.out.println(expData);
		        
		        //step:4 validate the id in database
		        String query="select* from project;";
		        String actData= dLib.executeQueryAndGetData(query, 1, expData);
		        Assert.assertEquals(expData, actData);
		        System.out.println("Test case Pass");
		        
		        resp.then().log().all();
		        
		        
		        		
		        
		        
	}
	
}

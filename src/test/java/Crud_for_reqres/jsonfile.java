package Crud_for_reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class jsonfile {

	    @Test
	    public void getResponseAndWriteToJsonFile() {
	        // Set the base URL for your API
	        RestAssured.baseURI = "https://reqres.in"; // Replace with your API URL

	        // Send a GET request
	        Response response = RestAssured.get("/api/users/2"); // Replace with your endpoint

	        // Extract the response body as a string
	        String responseBody = response.getBody().prettyPrint();

	        // Specify the file path for the JSON file
	        String filePath = "response.json"; // Replace with your desired file path

	        try {
	            // Create a file and write the response body to it
	            File file = new File(filePath);
	            FileWriter fileWriter = new FileWriter(file);
	            fileWriter.write(responseBody);
	            fileWriter.close();

	            System.out.println("Response has been written to " + filePath);
	        } catch (IOException e) {
	           e.printStackTrace();
	        	
	        }
	    }
	    
	@Test
	public void case1() throws IOException
	{
		Response res = when().get("https://reqres.in/api/users/2");
		 String body = res.getBody().prettyPrint();
		 FileWriter writer=new FileWriter(new File(".//responsebody.json"));
		 writer.write(body);
		 writer.flush();
		 writer.close();
			
	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}

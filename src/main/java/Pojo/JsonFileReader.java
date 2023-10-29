package Pojo;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileReader {

	public static JSONObject readdatafromJsonfile(String filepath)
	{
		       
		       JSONParser parser =new JSONParser();
		      try {
		    	  Object obj =parser.parse(new FileReader(filepath));
		    	  return(JSONObject) obj;
		      }
		      catch(Exception e)
		      {
		    	  e.printStackTrace();
		    	  return null; 
		      }
	}
	
	
	
	
	
	
	
	
}

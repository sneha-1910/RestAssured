package com.crm.GenericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {
  
	public String getJsonData(Response resp,String path)
	{
		String jsonData=resp.jsonPath().get(path);
		return jsonData;
	}
}

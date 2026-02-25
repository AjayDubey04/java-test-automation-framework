package com.rest.api.automation.practice;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequriestPractice {



	public static void main(String[] args) throws IOException {


		createContentByPostRequriest();

	}


	public static void createContentByPostRequriest() throws IOException {
		
		String str="JsData\\DataObj.json";
		Path pathObj=Paths.get(str);
		byte[] filePath=Files.readAllBytes(pathObj);
		String strFile=new String(filePath);
		
		
		String random=RandomStringUtils.randomAlphanumeric(5); 
		JSONObject jsObj=new JSONObject(strFile);
		JSONArray jsArr=jsObj.getJSONArray("properties");
		JSONObject jsArrObj=jsArr.getJSONObject(2);
		jsArrObj.put("value",random+"@gmail.com");
		
		Response res=RestAssured.given().baseUri("https://evsautomation.agilecrm.com")
		.auth().basic("createrajay229@btech.com", "Ajay@66#")
		.contentType(ContentType.JSON).body(jsObj.toString())
		.when().accept(ContentType.JSON).post("/dev/api/contacts");
		
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asPrettyString());
		
	}
	

}

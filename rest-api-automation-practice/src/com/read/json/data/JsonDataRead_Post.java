package com.read.json.data;

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

public class JsonDataRead_Post {

	public static void main(String[] args) throws IOException {
		
		JsonDataRead_Post obj=new JsonDataRead_Post();
		obj.postRequest();

	}
	
	
	
	public void postRequest() throws IOException {
		
		Path pathObj=Paths.get("Post_Payload\\Creatingcontact.txt");
		byte [] byteFileObj=Files.readAllBytes(pathObj);
		String str =new String(byteFileObj);
		
		JSONObject jsObj=new JSONObject(str);
		JSONArray jsArr=jsObj.getJSONArray("properties");
		
           // For First Name //
		JSONObject jsArrObj_0=jsArr.getJSONObject(0);
		System.out.println("Before Changing ==>> "+jsArrObj_0.getString("value"));
		
		String randomObj_0=RandomStringUtils.randomAlphabetic(5);
		System.out.println(randomObj_0);
		JSONObject jsChangeObj_0=jsArrObj_0.put("value", randomObj_0);
		System.out.println("Ofter Changing ==>> "+jsChangeObj_0.getString("value"));
		
		
		  // For Last Name //
		JSONObject jsArrObj_1=jsArr.getJSONObject(1);
		System.out.println("Before Changing ==>> "+jsArrObj_1.getString("value"));
		
		String randomObj_1=RandomStringUtils.randomAlphabetic(5);
		System.out.println(randomObj_1);
		JSONObject jsChangeObj_1=jsArrObj_1.put("value", randomObj_1);
		System.out.println("Ofter Changing ==>> "+jsChangeObj_1.getString("value"));
		
		
		  // For Email_ID //
		JSONObject jsArrObj=jsArr.getJSONObject(2);
		System.out.println("Before Changing ==>> "+jsArrObj.getString("value"));
		
		String randomObj=RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@gmail.com";
		System.out.println(randomObj);
		JSONObject jsChangeObj=jsArrObj.put("value", randomObj);
		System.out.println("Ofter Changing ==>> "+jsChangeObj.getString("value"));
		
		
		JSONObject jsArrObj_4=jsArr.getJSONObject(4);
		System.out.println("Before Changing ==>> "+jsArrObj_4.getString("value"));
		
		String randomObj_4="786"+RandomStringUtils.randomNumeric(7);
		System.out.println(randomObj_4);
		JSONObject jsChangeObj_4=jsArrObj.put("value", randomObj_4);
		System.out.println("Ofter Changing ==>> "+jsChangeObj_4.getString("value"));
		
		
		Response res=RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.request().body(jsObj.toString()).contentType(ContentType.JSON)
		.when().post("https://evsautomation.agilecrm.com/dev/api/contacts");
		
		
		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println(res.asPrettyString());
		
		
		
	}
}

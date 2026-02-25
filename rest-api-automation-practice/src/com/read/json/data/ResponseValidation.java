package com.read.json.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseValidation {

	public static void main(String[] args) throws IOException   {

		ResponseValidation obj=new ResponseValidation();
		obj.verifyResponseData();

	}

	public void verifyResponseData() throws IOException {

		// convet path objext into byte String object //
		Path pathObj=Paths.get("Json_Paylod\\JSONData.json");
		byte[] filePath=Files.readAllBytes(pathObj);
		String str=new String(filePath);
		// convet path objext into byte String object //


		JSONObject jsObj=new JSONObject(str);
		JSONArray jsArr=jsObj.getJSONArray("properties");

		JSONObject FirstNameObj=jsArr.getJSONObject(0);
		String randomFirstName=RandomStringUtils.randomAlphabetic(5);	
		JSONObject updateFirstName=FirstNameObj.put("value", randomFirstName);
		String expectedFirstName=updateFirstName.getString("value");


		JSONObject LastNameObj=jsArr.getJSONObject(1);
		String randomLastName=RandomStringUtils.randomAlphabetic(5);	
		JSONObject updateLastName=LastNameObj.put("value", randomLastName);
		String expectedLastName=updateLastName.getString("value");


		JSONObject EmailObj=jsArr.getJSONObject(2);
		String randomEmail=RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@gmail.com";	
		JSONObject updateEmail=EmailObj.put("value", randomEmail);
		String expectedEmail=updateEmail.getString("value");
		
		// perform Post Request //
		Response rsPost=RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.request().body(jsObj.toString()).contentType(ContentType.JSON)
		.when().post("https://evsautomation.agilecrm.com/dev/api/contacts");
		// perform Post Request //
		
		System.out.println("Post Request Status Code "+rsPost.getStatusCode());
		System.out.println("Post Request Response Time "+rsPost.getTime());
		
		rsPost.then().statusCode(200);
		
	
		// verify the Post Response Contact_ID //
		JSONObject verifyPost_ID=new JSONObject(rsPost.asPrettyString());
		System.out.println(verifyPost_ID.getLong("id"));

		Long acual_ID=verifyPost_ID.getLong("id");	
		if(16==acual_ID) {
			System.out.println("id contains 16 digit ");
		}else {
			System.out.println("id does not contain 16 digit ");
		}

		Long verifyLongDataType=acual_ID.valueOf(acual_ID);
		if(verifyLongDataType==acual_ID){
			System.out.println("id type is Long type");
		}else {
			System.out.println("id type is not Long type");
		}
		// verify the Post Response Contact_ID //
		


		// Perform Get Requrest //
		Response rsGet=RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.accept(ContentType.JSON).pathParam("id", verifyLongDataType)
		.when().get("https://evsautomation.agilecrm.com/dev/api/contacts/{id}");
		// Perform Get Requrest //


		System.out.println("Get Request Status Code "+rsGet.getStatusCode());
		System.out.println("Get Request Response time "+rsGet.getTime());
		String get_response_payload=rsGet.asPrettyString();
		System.out.println(get_response_payload);

		rsGet.then().statusCode(200);
		long expected_get_request_time=5000;
		rsGet.then().time(Matchers.lessThanOrEqualTo(expected_get_request_time));


		JSONObject verifyGetResponse=new JSONObject(get_response_payload);
		JSONArray jsResponsArray=verifyGetResponse.getJSONArray("properties");
		
		JSONObject  jsFirstName=jsResponsArray.getJSONObject(0);
		String acualFirstName=jsFirstName.getString("value");
		if(expectedFirstName.equalsIgnoreCase(acualFirstName)) {
			System.out.println("Expected FirstName Same As Actual FirstName So TC is Passed");
		}else {
			System.out.println("Expected FirstName is Not Same As Actual FirstName So TC is Failed");
		}
		

		JSONObject jsLastName=jsResponsArray.getJSONObject(1);
		String actualLastName=jsLastName.getString("value");
		if(expectedLastName.equalsIgnoreCase(actualLastName)) {
			System.out.println("Expected LastName Same As Actual LastName So TC is Passed");
		}else {
			System.out.println("Expected LastName is Not Same As Actual LastName So TC is Failed");
		}
		

		JSONObject jsEmailObj=jsResponsArray.getJSONObject(2);
		String acualeEmail=jsEmailObj.getString("value");	
		if(expectedEmail.equalsIgnoreCase(acualeEmail)) {
			System.out.println("Expected Email Same As Actual Email So TC is Passed");
		}else {
			System.out.println("Expected Email is Not Same As Actual Email So TC is Failed");
		}
		
		
		
		


	}

}

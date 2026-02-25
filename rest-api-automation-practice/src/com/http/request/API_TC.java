package com.http.request;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_TC {


	private String UserName="createrajay229@btech.com";
	private String Password="Ajay@66#";


	public static void main(String[] args) throws Exception {

		API_TC obj=new API_TC();
		obj.verify_APi_TC001();


	}



	public void verify_APi_TC001() throws Exception {

		System.out.println("====== Post Http Request has Started ======");

		String location="Post_Payload\\Creatingcontact.txt";
		Path pathObj=Paths.get(location);
		byte[] byteObj=Files.readAllBytes(pathObj);
		String strObj=new String(byteObj);

		JSONObject post_jsObj=new JSONObject(strObj);
		JSONArray post_request_jsArrObj=post_jsObj.getJSONArray("properties");

		String post_rsqFirstName=RandomStringUtils.randomAlphanumeric(5);
		JSONObject firstJsonArrObj=post_request_jsArrObj.getJSONObject(0);
		firstJsonArrObj.put("value", post_rsqFirstName);

		String post_rsqLastName=RandomStringUtils.randomAlphanumeric(5);
		JSONObject secondJsonArrObj=post_request_jsArrObj.getJSONObject(1);
		secondJsonArrObj.put("value", post_rsqLastName);

		String post_rsqEmail="Hello_"+RandomStringUtils.randomAlphanumeric(5)+"@gmail.com";
		JSONObject thirdJsonArrObj=post_request_jsArrObj.getJSONObject(2);
		thirdJsonArrObj.put("value", post_rsqEmail);

		Response post_response_payload=RestAssured.given().auth().basic(UserName, Password)
				.request().body(post_jsObj.toString()).contentType(ContentType.JSON)
				.when().post("https://evsautomation.agilecrm.com/dev/api/contacts");

		post_response_payload.then().statusCode(200);

		System.out.println("Post Response Code ==> "+post_response_payload.getStatusCode());
		System.out.println("Post Response Time ==> "+post_response_payload.getTime());

		JSONObject post_response_jsObj=new JSONObject(post_response_payload.asPrettyString());

		Long post_content_ID=post_response_jsObj.getLong("id");
		System.out.println("post_content_ID ==> "+post_content_ID);
		if(post_content_ID.toString().length()==16) {
			System.out.println("post_content_ID contains 16 Digits");
		}else {
			System.out.println("post_content_ID Does Not contains 16 Digits");
		}

		Long.valueOf(post_content_ID); 
		System.out.println("post_content_ID is  in form of long dataType");

		JSONArray post_response_jsArrObj=post_jsObj.getJSONArray("properties");
		String post_actualFirstName=post_response_jsArrObj.getJSONObject(0).getString("value");
		if(post_actualFirstName.equalsIgnoreCase(post_rsqFirstName)) {
			System.out.println("Post Expected FirstName Same As Post Actual FirstName");
		}else {
			System.out.println("Post Expected FirstName Not Same As Post Actual FirstName");
		}

		String post_actualLastName=post_response_jsArrObj.getJSONObject(1).getString("value");
		if(post_actualLastName.equalsIgnoreCase(post_rsqLastName)) {
			System.out.println("Post Expected LastName Same As Post Actual LastName");
		}else {
			System.out.println("Post Expected LastName Not Same As Post Actual LastName");
		} 

		String post_actualEmail=post_response_jsArrObj.getJSONObject(2).getString("value");
		if(post_actualEmail.equalsIgnoreCase(post_rsqEmail)) {
			System.out.println("Post Expected Email Same As Post Actual Email");
		}else {
			System.out.println("Post Expected Email Not Same As Post Actual Email");
		} 

		System.out.println("====== Post Http Request has Closed ====== \n");



		System.out.println("====== Get Http Request has Started  ======");

		Response getResponsePayload=RestAssured.given().auth().basic(UserName, Password)
				.accept(ContentType.JSON).pathParam("id",post_content_ID)
				.when().get("https://evsautomation.agilecrm.com/dev/api/contacts/{id}");

		getResponsePayload.then().statusCode(200);

		System.out.println("Get Response Code ==> "+getResponsePayload.getStatusCode());
		System.out.println("Get Response Time ==> "+getResponsePayload.getTime());

		String getResponseBody=getResponsePayload.asPrettyString();
		//		System.out.println(getResponseBody);

		JSONObject get_response_jsObj=new JSONObject(getResponseBody);
		JSONArray get_response_jsArrObj=get_response_jsObj.getJSONArray("properties");

		JSONObject get_FirstNameJsObj=get_response_jsArrObj.getJSONObject(0);
		String get_actualFirstName=get_FirstNameJsObj.getString("value");
		if(get_actualFirstName.equalsIgnoreCase(post_actualFirstName)) {
			System.out.println("Post Actual FirstName Same As Get Actual FirstName");
		}else {
			System.out.println("Post Actual FirstName Not Same As Get Actual FirstName");
		}


		JSONObject get_LastNameJsObj=get_response_jsArrObj.getJSONObject(1);
		String get_actualLastName=get_LastNameJsObj.getString("value");
		if(get_actualLastName.equalsIgnoreCase(post_actualLastName)) {
			System.out.println("Post Actual LastName Same As Get Actual LastName");
		}else {
			System.out.println("Post Actual LastName Not Same As Get Actual LastName");
		}


		JSONObject get_EmailJsObj=get_response_jsArrObj.getJSONObject(2);
		String get_actualEmail=get_EmailJsObj.getString("value");
		if(get_actualEmail.equalsIgnoreCase(post_actualEmail)) {
			System.out.println("Post Actual Email Same As Get Actual Email");
		}else {
			System.out.println("Post Actual Email Not Same As Get Actual Email");
		}


		System.out.println("====== Get Http Request has Closed ====== \n");


		System.out.println("====== Put Http Request has Started ======");

		String put_location="Post_Payload\\putPayload.json";
		Path put_path_Obj=Paths.get(put_location);
		byte[] put_byte_Obj=Files.readAllBytes(put_path_Obj);
		String put_str_Obj=new String(put_byte_Obj);

		JSONObject put_jsObj=new JSONObject(put_str_Obj);
		put_jsObj.put("id", post_content_ID);

		JSONArray put_RequestjsArrObj=put_jsObj.getJSONArray("properties");

		JSONObject put_firstNameJsObj=put_RequestjsArrObj.getJSONObject(0);
		put_firstNameJsObj.put("value", "Hello");
		String put_expectedFirstName=put_firstNameJsObj.getString("value");

		JSONObject put_lastNameJsObj=put_RequestjsArrObj.getJSONObject(1);
		put_lastNameJsObj.put("value", "EVS");
		String put_expectedLastName=put_firstNameJsObj.getString("value");

		String put_update_randomEmail="hii_"+RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		JSONObject put_emailJsObj=put_RequestjsArrObj.getJSONObject(2);
		put_emailJsObj.put("value", put_update_randomEmail);
		String put_expectedEmail=put_firstNameJsObj.getString("value");

		Response put_payload=RestAssured.given().auth().basic(UserName, Password)
				.request().body(put_jsObj.toString()).contentType(ContentType.JSON)
				.when().put("https://evsautomation.agilecrm.com/dev/api/contacts/edit-properties");

		put_payload.then().statusCode(200);

		System.out.println("Put Response Code ==> "+put_payload.getStatusCode());
		System.out.println("Put Response Time ==> "+put_payload.getTime());

		JSONObject put_ResponseJsObj=new JSONObject(put_payload.asPrettyString());
		JSONArray put_response_jsArrObj=put_ResponseJsObj.getJSONArray("properties");

		String put_actualFirstName=put_response_jsArrObj.getJSONObject(0).getString("value");
		if(put_actualFirstName.equalsIgnoreCase(put_expectedFirstName)) {
			System.out.println("put Actual FirstName Same As put Expected FirstName  ");
		}else {
			System.out.println("put Actual FirstName Not Same As put Expected FirstName  ");
		}

		String put_actualLastName=put_response_jsArrObj.getJSONObject(1).getString("value");
		if(put_actualLastName.equalsIgnoreCase(put_expectedLastName)) {
			System.out.println("put Actual LastName Same As put Expected LastName  ");
		}else {
			System.out.println("put Actual LastName Not Same As put Expected LastName  ");
		}

		String put_actualEmai=put_response_jsArrObj.getJSONObject(2).getString("value");
		if(put_actualEmai.equalsIgnoreCase(put_expectedEmail)) {
			System.out.println("put Actual Email Same As put Expected Email  ");
		}else {
			System.out.println("put Actual Email Not Same As put Expected Email  ");
		}

		System.out.println("====== Put Http Request has Closed ====== \n");


		Response get_put_ResponsePayload=RestAssured.given().auth().basic(UserName, Password)
				.accept(ContentType.JSON).pathParam("id",post_content_ID)
				.when().get("https://evsautomation.agilecrm.com/dev/api/contacts/{id}");

		get_put_ResponsePayload.then().statusCode(200);

		System.out.println("Get Response Code ==> "+get_put_ResponsePayload.getStatusCode());
		System.out.println("Get Response Time ==> "+get_put_ResponsePayload.getTime());

		String get_put_ResponseBody=get_put_ResponsePayload.asPrettyString();
		//				System.out.println(getResponseBody);

		JSONObject get_put_response_jsObj=new JSONObject(get_put_ResponseBody);
		JSONArray get_put_response_jsArrObj=get_put_response_jsObj.getJSONArray("properties");

		JSONObject get_put_FirstNameJsObj=get_put_response_jsArrObj.getJSONObject(0);
		String get_put_actualFirstName=get_put_FirstNameJsObj.getString("value");
		if(get_put_actualFirstName.equalsIgnoreCase(put_actualFirstName)) {
			System.out.println("Put Actual FirstName Same As Get_put Actual FirstName");
		}else {
			System.out.println("Put Actual FirstName Not Same As Get_put Actual FirstName");
		}


		JSONObject get_put_LastNameJsObj=get_put_response_jsArrObj.getJSONObject(1);
		String get_put_actualLastName=get_put_LastNameJsObj.getString("value");
		if(get_put_actualLastName.equalsIgnoreCase(post_actualLastName)) {
			System.out.println("Put Actual FirstName Same As Get_put Actual LastName");
		}else {
			System.out.println("Put Actual LastName Not Same As Get_put Actual LastName");
		}


		JSONObject get_put_EmailJsObj=get_put_response_jsArrObj.getJSONObject(2);
		String get_put_actualEmail=get_put_EmailJsObj.getString("value");
		if(get_put_actualEmail.equalsIgnoreCase(put_actualEmai)) {
			System.out.println("put Actual Email Same As Get_put Actual Email");
		}else {
			System.out.println("put Actual Email Not Same As Get_put Actual Email");
		}


		System.out.println("====== Get Http Request has Closed ====== \n");


	}

}

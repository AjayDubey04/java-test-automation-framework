package com.rest.api.automation.practice;




import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequriestPractice {

	private static String userName="createrajay229@btech.com";
	private static String password="Ajay@66#";
	private static String baseUri="https://evsautomation.agilecrm.com";

	public static void main(String[] args) {

//		performGetRequestAndReadResponeBody();
		getContentByID();

	}



	public static void performGetRequestAndReadResponeBody() {


		Response res=RestAssured.given().auth().basic(userName, password)
		.baseUri(baseUri).accept(ContentType.JSON).queryParam("page_size", "2")		
		.when().get("/dev/api/contacts"); // do not use ? here
		// we can also give this in below
         // get("https://evsautomation.agilecrm.com/dev/api/contacts?page_size=2")
		
		res.then().statusCode(200);

		System.out.println("Response Time --> "+res.getTime());
		System.out.println("Response Code --> "+res.getStatusCode());

		String responeBody=res.getBody().asPrettyString();
		//		System.out.println(responeBody);

		JSONArray jsArray=new JSONArray(responeBody);
		JSONObject jsObject=jsArray.getJSONObject(0);

		Long id=jsObject.getLong("id");
		System.out.println("ID -- >"+id);

		JSONObject viewed=jsObject.getJSONObject("viewed");
		Long oneviewed=viewed.getLong("viewer_id");
		System.out.println("Viewer_ID --> "+oneviewed);
		System.out.println("Viewed_ "+viewed);

		JSONArray jsArrSecond=jsObject.getJSONArray("tags");
		String one=jsArrSecond.getString(0);
		System.out.println("One ==> "+one);
		System.out.println("Tags --> "+jsArrSecond);

		JSONArray jsArrthird=jsObject.getJSONArray("tagsWithTime");
		JSONObject jsArrthirdJsobj=jsArrthird.getJSONObject(0);
		System.out.println("Tag Name --> "+jsArrthirdJsobj.getString("tag"));

		JSONArray thirdArrobj=jsObject.getJSONArray("properties");
		JSONObject jsObj=thirdArrobj.getJSONObject(0);
		System.out.println("First_Name -->> "+jsObj.getString("value"));
	}
	
	
	
	public static void getContentByID() {
		
		Response res=RestAssured.given().baseUri(baseUri)
		.basePath("dev/api/contacts/{id}").auth().basic(userName,password)
		.accept(ContentType.JSON).pathParam("id", "4650767293415424")
		.when().get();
		
		res.then().statusCode(200);
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
		
		
		
	}
	
	
	

}

package com.http.request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest {

	public static final String USERNAME="createrajay229@btech.com";
	public static final String PASSWORD="Ajay@66#";
	public static final String BASEURL="https://evsautomation.agilecrm.com";



	public void listByGetRequest() {
		
//		 RestAssured.given(). auth().basic(USERNAME,PASSWORD).accept(ContentType.JSON)
//		 .when().get(BASEURL+"/dev/api/contacts?page_size=2");

//		 Use of query parameters 
		Response res=RestAssured.given().auth().basic(USERNAME, PASSWORD)
		.accept(ContentType.JSON).queryParam("page_size", "2")
		.when().get(BASEURL+"/dev/api/contacts");

		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println("Response Type "+res.getTime());
		System.out.println(res.asPrettyString());

	}
	
	
	
	public void getRequestByID() {
		
		RestAssured.baseURI="https://evsautomation.agilecrm.com";
		Response res=RestAssured.given().auth().basic(USERNAME, PASSWORD).accept(ContentType.JSON)
		.when().get("/dev/api/contacts/4708338580652032");
		
//		 use of path parameters 
//		 RestAssured.given().auth().basic(USERNAME, PASSWORD)
//		.pathParam("id", "4708338580652032").accept(ContentType.JSON)
//		.when().get(BASEURL+"/dev/api/contacts/{id}");
		

		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println("Response Type "+res.getTime());
		System.out.println(res.asPrettyString());
		
	}
	
	
	public void getRequestByEmail() { 
		
		
		Response res=RestAssured.given().auth().basic(USERNAME, PASSWORD)
		.baseUri(BASEURL)
		.pathParam("email", "dubey.ji12@yes.com").accept(ContentType.JSON)
		.when().get("/dev/api/contacts/search/email/{email}");	
		
		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println("Response Type "+res.getTime());
		System.out.println(res.asPrettyString());
		
	}
	
	public void basicURL() {
		
		RestAssured.baseURI="https://evsautomation.agilecrm.com/dev/api/contacts/4708338580652032";
		Response res=RestAssured.given().auth().basic(USERNAME, PASSWORD).accept(ContentType.JSON)
		.when().get();
		
		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println("Response Type "+res.getTime());
		System.out.println(res.asPrettyString());
	}
	
	
	public void getTaskByID() {
		
		
	Response rsp=RestAssured.given().baseUri(BASEURL).auth().basic(USERNAME, PASSWORD)
		.pathParam("id", "6360222764695552").accept(ContentType.JSON)
		.when().get("/dev/api/contacts/{id}/tasks/sort");
		
	System.out.println("Statuc code "+rsp.getStatusCode());
	System.out.println("Respone Time "+rsp.getTime());
	System.out.println(rsp.asPrettyString());
	
	
		
	}
	
	public void  getDealByID() {
		
		RestAssured.baseURI=BASEURL;
		
		Response rsp=RestAssured.given().auth().basic(USERNAME, PASSWORD)
		.pathParam("id", "4646552699469824").accept(ContentType.JSON)
		.when().get("/dev/api/contacts/{id}/deals");
		
		
		System.out.println("Statuc code "+rsp.getStatusCode());
		System.out.println("Respone Time "+rsp.getTime());
		System.out.println(rsp.asPrettyString());
		
	}

}

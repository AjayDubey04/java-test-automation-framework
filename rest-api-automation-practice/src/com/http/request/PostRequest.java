package com.http.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	
	
	public static final String USERNAME="createrajay229@btech.com";
	public static final String PASSWORD="Ajay@66#";
	public static final String BASEURL="https://evsautomation.agilecrm.com";
	
		
	
	public void createContact() throws FileNotFoundException {

		File fobj=new File("Payload\\Creatingcontact.txt");
		InputStream file=new FileInputStream(fobj);


		Response res=RestAssured.given().auth().basic(USERNAME, PASSWORD)
		.request().body(file).contentType(ContentType.JSON)
		.when().post(BASEURL+"/dev/api/contacts");
		
		res.then().statusCode(400);

		System.out.println("Response Code "+res.getStatusCode());
		System.out.println("Response Time "+res.getTime());
		System.out.println("Content-type "+res.getContentType());
		System.out.println(res.asPrettyString());

	}
	
	
	public void addTicket() {
		
		File addticketPayload=new File("");
		
		Response resAdd=RestAssured.given().auth().basic(USERNAME,PASSWORD).baseUri(BASEURL)
		.request().body(addticketPayload).contentType(ContentType.JSON)
		.when().post("/dev/api/tickets/new-ticket");
		
		System.out.println("Rsponse Body "+resAdd.getStatusCode());
		System.out.println("Rsponse Time "+resAdd.getTime());
		System.out.println(resAdd.asPrettyString());
		
		
		
	}
	
	public void createDealByEmailID() throws FileNotFoundException {
		

		InputStream dealObj=new FileInputStream("");
		
	RestAssured.baseURI=BASEURL;
	
	Response rspDeal=RestAssured.given().auth().basic(USERNAME, PASSWORD)
	.request().body(dealObj).contentType(ContentType.JSON).pathParams("EmailID","samson@walt.ltd")
	.when().post("/dev/api/opportunity/email/{EmailID}");
	
	System.out.println("Response Time "+rspDeal.getTime());
	System.out.println("Response Body "+rspDeal.getStatusCode());
	System.out.println(rspDeal.asPrettyString());
			
		
	}
	
	
  public  void addTagByEmailID() throws FileNotFoundException {
	
	  File addTagObj=new File("");
	  InputStream filePath=new FileInputStream(addTagObj);
	  
	Response rspTag= RestAssured.given().auth().basic(USERNAME, PASSWORD)
	 .request().body(filePath).contentType(ContentType.JSON)
	 .pathParam("EmailId","samson@walt.ltd")
	   .when().post(BASEURL+"/dev/api/contacts/{EmailId}/tags/add");
	  
	  
	System.out.println("Respone Time "+rspTag.getTime());
	  System.out.println("Respone Code "+rspTag.getStatusCode());
	  System.out.println(rspTag.asPrettyString());
	
}
  
   

}

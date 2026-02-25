package com.http.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiWork {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 *  post(); getByID();  GetByEmail();  delete();
		 *  
		 */
	}

	public  void post() throws FileNotFoundException {

		File fobj = new File("Payload\\Creatingcontact.txt");
		InputStream file = new FileInputStream(fobj);

		Response rsp = RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.request().body(file).contentType(ContentType.JSON)
		.when().post("https://evsautomation.agilecrm.com/dev/api/contacts");

		System.out.println("Status Code " + rsp.getStatusCode());
		System.out.println("Response Time " + rsp.getTime());
		System.out.println(rsp.getBody().asPrettyString());

		rsp.then().statusCode(200);

	}

	public  void putRequest() throws FileNotFoundException {
		
		File fobj = new File("Payload\\Creatingcontact.txt");
		InputStream file = new FileInputStream(fobj);
		
		Response rsp=RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.request().body(file).contentType(ContentType.JSON)
		.when().put("https://evsautomation.agilecrm.com/dev/api/contacts/edit-properties");
		
		
		System.out.println("Status Code " + rsp.getStatusCode());
		System.out.println("Response Time " + rsp.getTime());
		System.out.println(rsp.getBody().asPrettyString());

		rsp.then().statusCode(200);
		
		long time=5000;
		rsp.then().time(Matchers.greaterThan(time),TimeUnit.MILLISECONDS);

		
		

	}

	public  void getByID() {

		RestAssured.baseURI = "https://evsautomation.agilecrm.com";

		Response rsp = RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.accept(ContentType.JSON)
		.when().get("/dev/api/contacts/6639406493794304");

		System.out.println("Status Code " + rsp.getStatusCode());
		System.out.println("Response Time " + rsp.getTime());
		System.out.println(rsp.getBody().asPrettyString());
		
		rsp.then().statusCode(200);
		
		long expTime = 300;
		rsp.then().time(Matchers.lessThan(expTime), TimeUnit.MILLISECONDS);

	}

	public  void GetByEmail() {

		Response rsp = RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.baseUri("https://evsautomation.agilecrm.com").accept(ContentType.JSON).contentType(ContentType.JSON)
		.when().get("/dev/api/contacts/search/email/roshan.yadav10@yop.com");

		System.out.println("Status Code " + rsp.getStatusCode());
		System.out.println("Response Time " + rsp.getTime());
		System.out.println(rsp.getBody().asPrettyString());

		rsp.then().statusCode(200);
		
		long expTime = 300;
		rsp.then().time(Matchers.lessThanOrEqualTo(expTime), TimeUnit.MILLISECONDS);

	}

	public  void delete() {

		Response rsp = RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.baseUri("https://evsautomation.agilecrm.com").contentType(ContentType.JSON).when()
	   .delete("/dev/api/contacts/6639406493794304");

		System.out.println("Status Code " + rsp.getStatusCode());
		System.out.println("Response Time " + rsp.getTime());
		
		
       rsp.then().statusCode(204);
		
		long expTime = 300;
		rsp.then().time(Matchers.greaterThanOrEqualTo(expTime), TimeUnit.MILLISECONDS);
		

	}

}

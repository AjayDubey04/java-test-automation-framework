package com.http.request;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {


	public static final String USERNAME="createrajay229@btech.com";
	public static final String PASSWORD="Ajay@66#";
	public static final String BASEURL="https://evsautomation.agilecrm.com";



	public void deleteSingleContact() {

		Response Robj=RestAssured.given().auth().basic(USERNAME,PASSWORD)
		.when().delete(BASEURL+"/dev/api/contacts/5493281585954816");
		
		Robj.then().statusCode(204);


		System.out.println("Response Code "+Robj.getStatusCode());
		System.out.println("Response Time "+Robj.getTime());
		System.out.println("Content-type "+Robj.getContentType());
		System.out.println(Robj.asPrettyString());	

	}

	public void deleteDeal() {



	}


	public void deleteSpecificNote() {



	}

	public void deleteTask() {



	}

	public void deleteEvent() {



	}

}

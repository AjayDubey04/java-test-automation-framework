package com.rest.api.automation.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeteleRequriestPractice {

	public static void main(String[] args) {

		deleteContectByID();
		
	}
	
	public static void deleteContectByID() {
		
		
	Response res=RestAssured.given().baseUri("https://evsautomation.agilecrm.com")
		.auth().basic("createrajay229@btech.com", "Ajay@66#")
		.pathParam("ID", "5296053044969472")
		.when().delete("/dev/api/contacts/{ID}");
		
		
		res.then().statusCode(204);
		
		System.out.println("Passed");
		System.out.println("Statuc Code ==>> "+res.getStatusCode());
	}

}

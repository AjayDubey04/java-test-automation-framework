package com.http.request;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {


	public void updateLeadScoreByID() throws FileNotFoundException {


		InputStream file= new FileInputStream("JsData\\PutDataObj.json");

		Response res=RestAssured.given().auth().basic("createrajay229@btech.com", "Ajay@66#")
		.request().body(file).contentType(ContentType.JSON)
		.when().put("https://evsautomation.agilecrm.com/dev/api/contacts/edit/lead-score");

		res.then().statusCode(200);
		System.out.println("passed");



	}


	public void updateProperty() {



	}

	public void updateStarByID() {



	}

	public void updateTagByID() {



	}

}

package com.rest.api.runner;

import java.io.FileNotFoundException;

import com.http.request.ApiWork;
import com.http.request.DeleteRequest;
import com.http.request.GetRequest;
import com.http.request.PostRequest;
import com.http.request.PutRequest;

public class RunnerMethods {

	public static void main(String[] args) throws FileNotFoundException {

//		ApiWork workObj=new ApiWork();
//		workObj.post();
//		workObj.putRequest();
//		workObj.GetByEmail();
//		workObj.delete();
//
//		PostRequest postObj=new PostRequest();
//		postObj.createContact();
//		
//		GetRequest getObj=new GetRequest();
//		getObj.getDealByID();	
		
		PutRequest putObj=new PutRequest();
		putObj.updateLeadScoreByID();
		
//		DeleteRequest deleteObj=new DeleteRequest();
//		deleteObj.deleteSingleContact();	
		

	}

}

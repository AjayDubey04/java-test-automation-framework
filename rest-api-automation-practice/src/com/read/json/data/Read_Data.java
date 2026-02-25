package com.read.json.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class Read_Data {


	public static void main(String[] args) throws IOException {

		Read_Data readDataObj=new Read_Data();
//		readDataObj.dtaRead();
		readDataObj.dtaRead_1();
		
		
	}




	public void dtaRead() throws IOException {

		String jsonPath="Json_Paylod\\JSON.txt";

		Path pathObj=Paths.get(jsonPath);
		System.out.println(pathObj);

		byte[] fileObj=Files.readAllBytes(pathObj);
		String str=new String(fileObj);

		JSONObject jsObj=new JSONObject(str);
		System.out.println(jsObj.getString("FirstName"));
		System.out.println(jsObj.getString("LastName"));
		System.out.println(jsObj.getInt("age"));
		System.out.println(jsObj.getString("gender"));

		JSONArray jsArr=jsObj.getJSONArray("subjects");
		for (int i = 0; i<jsArr.length(); i++) {
			//			System.out.println(jsArr.get(0));
			System.out.println(jsArr.getString(i));	
		}





	}


	public void dtaRead_1() throws IOException {

		String JsonDataFile="Json_Paylod\\JSONData.json";
		Path pathJsonData=Paths.get(JsonDataFile);
		byte[] jsonByteData=Files.readAllBytes(pathJsonData);
		String strJsonData=new String(jsonByteData);

		JSONObject jsObject=new JSONObject(strJsonData);
		System.out.println("id = "+jsObject.getLong("id"));
		System.out.println("type = "+jsObject.getString("type"));
		System.out.println("created_time = "+jsObject.getLong("created_time"));
		System.out.println("updated_time = "+jsObject.getLong("updated_time"));

		JSONObject jsSubObj_1=jsObject.getJSONObject("viewed");
		System.out.println("viewed_time = "+jsSubObj_1.getLong("viewed_time"));
		System.out.println("viewer_id = "+jsSubObj_1.getLong("viewer_id"));


		System.out.println("star_value = "+jsObject.getInt("star_value"));
		System.out.println("lead_score = "+jsObject.getInt("lead_score"));


		JSONArray  jsSubArr=jsObject.getJSONArray("tags");
		System.out.println(jsSubArr);


		JSONArray  jsSubArr_1=jsObject.getJSONArray("tagsWithTime");
		JSONObject jsSubObj_2=jsSubArr_1.getJSONObject(0);
		System.out.println(jsSubObj_2.get("tag"));

		JSONObject jsSubObj_3=jsSubArr_1.getJSONObject(1);
		System.out.println(jsSubObj_3.get("tag"));


		JSONArray  jsSubArr_2=jsObject.getJSONArray("properties");
		JSONObject propertiesSubArr=jsSubArr_2.getJSONObject(0);
		System.out.println(propertiesSubArr.getString("value"));



	}



}

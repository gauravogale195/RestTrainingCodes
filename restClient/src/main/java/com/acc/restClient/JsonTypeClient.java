package com.acc.restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

;

public class JsonTypeClient {
	
	//private static final String ENTRY_URL = "https://jsonplaceholder.typicode.com/posts";


	public static void main(String[] args) {


		Client client = ClientBuilder.newClient();
		WebTarget baseTarget =client.target("http://localhost:8081/companyBasicNew/webapi/");
		WebTarget deptsTarget = baseTarget.path("department");
		WebTarget singleDeptTarget = deptsTarget.path("{dname}");
		
		Department dept = new Department(10, "Dept6",7,"anil");
		
		Response postResponse = deptsTarget.request().post(Entity.json(dept));
		
		if(postResponse.getStatus() !=201) {
			System.out.println("Error");
		}
		Department deptRes = postResponse.readEntity(Department.class);
		System.out.println(deptRes);
		
		/*
		 * Response response = postTargetBase.request().get();
		 * System.out.println(response);
		 * 
		 * //GET ALL POSTS String posts =
		 * postTargetBase.request(MediaType.APPLICATION_JSON).get(String.class);
		 * //System.out.println("All Post="+posts);
		 * 
		 * //get single post WebTarget singlePostTarget =
		 * postTargetBase.path("{postid}"); String post1 =
		 * singlePostTarget.resolveTemplate("postid",
		 * 1).request(MediaType.APPLICATION_JSON).get(String.class);
		 * //System.out.println("Post ID 1="+post1);
		 */		
	}

}

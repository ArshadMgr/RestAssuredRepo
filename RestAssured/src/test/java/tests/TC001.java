

package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class TC001 {
	
	//@Test
	public void test_1() {
		
		Response  response= RestAssured.get("https://acsapistag.securetech-consultancy.com/api/v1/dashboard/getonpremisescount");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
	}

	@Test
	public void Approach1() {
		
		 RestAssured.baseURI = "https://acsapistag.securetech-consultancy.com";
	        RequestSpecification request = RestAssured.given();
	 
	        Response response = request.when().get("/api/v1/dashboard/getonpremisescount");

	        response.then().statusCode(200);
	       
	       	
	}
	
	
	@Test
	public void Approach2() {
		
		baseURI = "https://acsapistag.securetech-consultancy.com";
		
		given().get("/api/v1/dashboard/getonpremisescount"). 
		then().statusCode(200).body("guardsOnPremisesCount", equalTo(2)).log().all();
		
		
	       
	       	
	}
	
	
	

	}//end of class

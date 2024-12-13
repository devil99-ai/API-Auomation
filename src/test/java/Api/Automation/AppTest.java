package Api.Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest 

{
	
	@Test
	public void fetchAllEmployeeData() {
		String url ="https://dummy.restapiexample.com";
		String endpoint="/api/v1/employees";
		RestAssured.baseURI = url;
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.get(endpoint);
		System.out.println("Response:");
		System.out.println(res.prettyPrint());
	}
	@Test
	public void fetchAllEmployeeDataByID() {
		String url = "https://dummy.restapiexample.com";
		String endpoint = "/api/v1/employee";
		String id ="/719";
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response  res = requestSpecification.get(endpoint+id);
		System.out.println(res.prettyPrint());
		System.out.println(res.statusCode());
		
	}
	@Test
	public void createAnEmployee() {
		String url = "https://dummy.restapiexample.com/";
		String endpoint = "public/api/v1/update/21";
		RestAssured.baseURI=url;
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type","application/json");
		Response  res = requestSpecification.body("	{\"name\":\"souvik sharma\",\"salary\":\"123456\",\"age\":\"25\"}").put(endpoint);
		System.out.println("status code: "+res.statusCode()+"/n"+"Response"+res.prettyPrint());
		
	}
	@Test
	public void deleteEmployee() {
		String url = "https://dummy.restapiexample.com";
		String endpoint ="/api/v1/delete/719";
		RestAssured.baseURI = url;
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.delete(endpoint);
		System.out.println("Status Code: "+res.statusCode());
		System.out.println("Response:b"+res.prettyPrint());
	}
	}

package test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testResonseCode(){
		
		Response resp= RestAssured.get("http://private-anon-60c758a657-daliasurveyproviderapi.apiary-mock.com/surveys/b4a90fb9-0b14-4a85-92c2-f815db5be264/SURVEY_1/target_groups");
		int code = resp.getStatusCode();
		System.out.println("Staus Code is "+ code);
		Assert.assertEquals(code,200);
		
	}
	@Test
	public void testBody(){
		
		Response resp= RestAssured.get("http://private-anon-60c758a657-daliasurveyproviderapi.apiary-mock.com/surveys/b4a90fb9-0b14-4a85-92c2-f815db5be264/SURVEY_1/target_groups");
		String body = resp.asString();
		System.out.println("Body contains"+ body);
		Assert.assertNotEquals(body,"");
		
		
	}
	
	@Test
	public void testSurveyId(){
		
		Response resp= RestAssured.get("http://private-anon-60c758a657-daliasurveyproviderapi.apiary-mock.com/surveys/b4a90fb9-0b14-4a85-92c2-f815db5be264/SURVEY_1/target_groups");
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String id = jsonPathEvaluator.get("survey_id");
		System.out.println("id is"+ id);
		Assert.assertEquals(id,"SURVEY_1");
		
		
	}
	
	

}

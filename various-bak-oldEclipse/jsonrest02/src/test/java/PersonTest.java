

import java.io.IOException;

import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.Assert;

import com.gm.json.Person;

public class PersonTest {

	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	static RestTemplate restTemplate;
	static HttpHeaders headers;
	static JSONObject personJsonObject;
	
    /* Autowired above instead of doing 'new'
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();
    static JSONObject personJsonObject = new JSONObject();
    */
	
	// Initialize test objects
	
	@BeforeClass
	public static void runBeforeAllTestMethods() throws Exception {
	    String createPersonUrl = "http://localhost:8082/spring-rest/createPerson";
	    String updatePersonUrl = "http://localhost:8082/spring-rest/updatePerson";


	    headers.setContentType(MediaType.APPLICATION_JSON);
	    personJsonObject.put("id", 101);
	    personJsonObject.put("name", "Cool Guy");
	}
	
	// Test Case
	
	@Test
	public void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotNull()
	  throws IOException {
		
	    System.out.println( "This is a new JUnit4 test case.");
	    //Assert.fail( "Not yet implemented");
		
	    HttpEntity<String> request =  new HttpEntity<String>(personJsonObject.toString(), headers);
	    String createPersonUrl = "http://localhost:8080/persons/createPerson";
	    
	    String personResultAsJsonStr = restTemplate.postForObject(createPersonUrl, request, String.class);
	    JsonNode root = objectMapper.readTree(personResultAsJsonStr);
	    
	    Assert.assertNotNull(personResultAsJsonStr);
	    Assert.assertNotNull(root);
	    Assert.assertNotNull(root.path("name").asText());
	    
	    Person person = restTemplate.postForObject(createPersonUrl, request, Person.class);

	    //Assert.assertNotNull(person);
	    Assert.assertNull(person);
	    //Assert.assertNotNull(person.getName());
	}
	
	
}

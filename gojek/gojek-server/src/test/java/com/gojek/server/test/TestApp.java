/**
 * 
 */
package com.gojek.server.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author abhineetkumar
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestApp {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello World!");
	}

	@Test
	public void addLocationTest(){
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("latitude", "1.0000000");
		urlVariables.put("longitude", "5.59463452");
		urlVariables.put("accuracy", "0.7");
		urlVariables.put("id", "1");
		this.restTemplate.put("/drivers/{id}/location", null, urlVariables);
	}
	
	@Test
	public void getDriversTest(){
		Map<String, String> urlVariables = new HashMap<>();
		urlVariables.put("latitude", "0.000000");
		urlVariables.put("longitude", "0.000000");
		System.out.println(this.restTemplate.getForEntity("/drivers?latitude={latitude}&longitude={longitude}", String.class, urlVariables).toString());
	}
}

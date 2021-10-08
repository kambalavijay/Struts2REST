package com.concretepage.rest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeRepository {
	private static Map<String,Employee> map = new HashMap<String,Employee>();
	RestTemplate restTemplate = new RestTemplate();
	private static String content = null;
	public EmployeeRepository(){
		// Rest api call
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/ipadrs", String.class);
		content = responseEntity.getBody();
		System.out.println(content);
		// old code
		map.put("111", new Employee(111, "Ram", "ABC"));
		map.put("222", new Employee(222, "Shyam", "EFG"));
		map.put("333", new Employee(333, "Mohan", "XYZ"));
	}
	public Employee getEmployeeById(String id){
		return map.get(id);
	}
	public  Map<String,Employee> findAllEmployee(){
		// connect to datasase
		// connect to server
		return map;
	}

	public String getContent(){
		return content;
	}
}


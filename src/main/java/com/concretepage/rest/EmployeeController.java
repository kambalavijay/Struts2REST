package com.concretepage.rest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import entity.Resource;
import java.awt.PageAttributes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeController implements ModelDriven<Object>{
	private static final long serialVersionUID = 1L;
	private String id;
	private Object model;
	private EmployeeRepository employeeRepository = new EmployeeRepository();
	private String output;
	private static Map<String,Employee> map;
	{
		map = employeeRepository.findAllEmployee();
		output = employeeRepository.getContent();
	}
	public HttpHeaders index() {
		System.out.println(output);
		model = map;
		return new DefaultHttpHeaders("index").disableCaching();
	}

	public String add(){
		Integer empId = Integer.parseInt(id);
		Employee emp = new Employee(empId,"Ramesh", "PQR");
		model = emp;
		return "SUCCESS";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		model = employeeRepository.getEmployeeById(id);
		this.id = id;
	}

	@Override
	public Object getModel() {
		return model;
	}

	public Object show(){
		return model;
	}

} 
package com.dmall.productservice.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class HealthCheckController {

	@Value("${server.env}")
	private String env;
	@Value("${server.port}")
	private String serverPort;
	@Value("${server.address}")
	private String serverAddress;
	@Value("${serverName}")
	private String serverName;
	
	//������ �� ���ư���
	@GetMapping("/hc")
	public ResponseEntity<?> healthCheck() {
		Map<String, String> responseData = new TreeMap<>();
		responseData.put("env", env);
		responseData.put("serverPort", serverPort);
		responseData.put("serverAddress", serverAddress);
		responseData.put("serverName", serverName);
		return ResponseEntity.ok(responseData);
	}
	
	@GetMapping("/env")
	public ResponseEntity<?> getEnv() {
		return ResponseEntity.ok(env);
	}
}

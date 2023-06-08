package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.java_demo_test.service.ifs.RegisterService;
import com.example.java_demo_test.vo.RegisterRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//如果Properities他需要指定對應package才會執行
@SpringBootTest(classes=JavaDemoTestApplication.class)
public class ApiTest {
	
	@Autowired
	private RegisterService registerService;
	
	
	@Test
    void contextLoads() {
		RegisterRequest test=new RegisterRequest(null, null);
		registerService.register(test);
	};
//	
	
	
	@Value("${heartbeat.ms}") //heartbeat.ms:
	private int heartbeat;
	@Test
	public void getProperitiesTest() {
		System.out.println(heartbeat);
	}
	
	
	
	
	
	
	
	
	
	
    @SuppressWarnings("unchecked")
	@Test
	public void getApiTest() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "https://opendata.hccg.gov.tw/API/v3/Rest/OpenData/704FC0B2EE7500E4?take=10&skip=0";
		ResponseEntity<String> res = restTemplate.getForEntity(urlStr, String.class);

		System.out.println(res.getStatusCodeValue()); //enum的編號
		System.out.println(res.getStatusCode());//enum的狀態
		String reBody = res.getBody();
		System.out.println(reBody); // 出來型態為map {} []為矩陣

		List<Map<String, String>> mapList = new ArrayList<>(); //Map<String, String> 他型態"key":"value"
		ObjectMapper objectMapper = new ObjectMapper();

//	     
		try {
			mapList=objectMapper.readValue(reBody, List.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for (Map<String, String> item : mapList) {
//			for (Entry<String, String> map : item.entrySet()) {
//				System.out.println("=========");
//				System.out.println("key:"+ map.getKey());
//				System.out.println("value:"+map.getValue());
//				System.out.println("=========");
//			}
//		}

	}

	@Test
	public void postApiTest() {
		RestTemplate restTemplate = new RestTemplate();
		String urlStr = "http://192.168.8.163:8080/api/register";
		// set header
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON); // 選擇media
		// set request_body
		Map<String, String> map = new HashMap<>();
		map.put("account", "SSSIII");
		map.put("pwd", "ASD999");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String reqStr = objectMapper.writeValueAsString(map);
			HttpEntity<String> requestBody = new HttpEntity<String>(reqStr, header);
			ResponseEntity<String> res = restTemplate.postForEntity(urlStr, requestBody, String.class);
			System.out.println(res.getStatusCodeValue());
			System.out.println(res.getStatusCode());
			String reBody = res.getBody();
			System.out.println(reBody); // 出來型態為map {} []為矩陣
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

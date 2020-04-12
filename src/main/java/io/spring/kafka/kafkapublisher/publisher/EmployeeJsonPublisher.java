package io.spring.kafka.kafkapublisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.spring.kafka.kafkapublisher.entity.Employee;

@Service
public class EmployeeJsonPublisher {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; 
	
	private ObjectMapper objectMapper = new ObjectMapper();

	
	public void sendMessage(Employee employee) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(employee);
		kafkaTemplate.send("t_hello", json);
	}

}

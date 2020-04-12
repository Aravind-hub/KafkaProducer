package io.spring.kafka.kafkapublisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloKafkaPublisher {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendHello(String name) {
		kafkaTemplate.send("t_hello","Hello "+name);
	}

}

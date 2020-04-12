package io.spring.kafka.kafkapublisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class KafkaKeyPublisher {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; 
	
	public void sendData(String key, String data) {
		kafkaTemplate.send("t_multi_partitions", key, data);
	}

}

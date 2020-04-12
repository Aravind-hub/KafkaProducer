package io.spring.kafka.kafkapublisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRatePublisher {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; 
	private int i=0;
	//private Logger log = LoggerFactory.getLogger(FixedRatePublisher.class);
	
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i+=1;
		System.out.println("Value of i is "+i);
		kafkaTemplate.send("t_fixedrate","Fixed rate "+i);
	}

}

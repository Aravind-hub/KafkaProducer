package io.spring.kafka.kafkapublisher;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.spring.kafka.kafkapublisher.publisher.HelloKafkaPublisher;
import io.spring.kafka.kafkapublisher.publisher.KafkaKeyPublisher;
import io.spring.kafka.kafkapublisher.entity.Employee;
import io.spring.kafka.kafkapublisher.publisher.EmployeeJsonPublisher;;


@SpringBootApplication
//@EnableScheduling
public class KafkaPublisherApplication implements CommandLineRunner{

	@Autowired
	private EmployeeJsonPublisher employeeJsonPublisher;
	//private KafkaKeyPublisher kafkaKeyPublisher;
	//private HelloKafkaPublisher helloKafkaPublisher;
	 
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloKafkaPublisher.sendHello("Aravind "+Math.random());
		/*
		 * for(int i=0;i<30;i++) { String key = "key"+(i%4); String data =
		 * "data "+i+" with key "+key; kafkaKeyPublisher.sendData(key, data); }
		 */
		
		for(int i=0;i<5;i++) {
			Employee employee = new Employee("emp."+i,"Employee "+1, LocalDate.now());
			employeeJsonPublisher.sendMessage(employee);
		}
	}

}

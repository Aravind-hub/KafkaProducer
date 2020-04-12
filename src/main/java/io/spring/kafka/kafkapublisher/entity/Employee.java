package io.spring.kafka.kafkapublisher.entity;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.spring.kafka.kafkapublisher.json.CustomLocalDateSerializer;
import io.spring.kafka.kafkapublisher.json.LocalDateAdapter;

public class Employee {
	
	@JsonProperty("EmployeeID")
	private String employeeId;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("BirthDay")
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate birthDate;

	public Employee(String employeeId, String name, LocalDate birthDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}

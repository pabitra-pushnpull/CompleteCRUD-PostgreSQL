package com.connection.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients_demo")
public class ClientModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long client_Id;
	
	@Column(nullable = false)
	private String client_name;
	
	@Column(nullable = false)
	private String location;
	
	@Column(unique = true)
	private String mobile;
	
	//hello

}

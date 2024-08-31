package com.practice.OrderService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
	
	@Id
	private String id;
	private int sequence;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sequence(String id, int sequence) {
		super();
		this.id = id;
		this.sequence = sequence;
	}
	
	
	
	

}

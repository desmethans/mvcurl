package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	protected Client() {		
	}
	public Client(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}

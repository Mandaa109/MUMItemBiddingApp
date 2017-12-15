package mum.edu.cs544.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
	@Id
	@GeneratedValue
	private long id;

 	private String street;
 	
 	@NotEmpty(message="{String.empty.city}")
	private String city;
	
	@Size(min=2, max=15, message="{Size.state}")
 	private String state;
	
	@Size(min=5,max=5)
	private String zipCode;
	
	private String Country;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}

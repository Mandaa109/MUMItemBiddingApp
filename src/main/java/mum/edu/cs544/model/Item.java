package mum.edu.cs544.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Item {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Size(min=5, max=30, message="{Size.item.name.validation}")
	private String itemName;
	
	@NotEmpty(message="{String.item.ownerDescription}")
	private String ownerDescription;
	
	@NotNull(message="{NotNull.item.expectedPrice}")
	private double expectedPrice;
	
	@NotEmpty(message="{String.item.typeOfItem}")
	private String typeOfItem;
	
	@Transient
	private MultipartFile image;
	
	private String imagePath;
	
	//@NotNull
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="owner_id")
	private User owner;
	
	@Valid
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
}

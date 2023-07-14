package in.ineuron.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="q_22")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	private String name;
	private String productOrdered;
	private String address;
	private Double price;
	private Integer noOfOrderPlaced;
	
	public UserDetail() {
		System.out.println("Hibernate internally uses ZERO-PARAM constructor during select query");
	}

	public UserDetail(Long regNo, String name, String productOrdered, String address, Double price,
			Integer noOfOrderPlaced) {
		super();
		this.regNo = regNo;
		this.name = name;
		this.productOrdered = productOrdered;
		this.address = address;
		this.price = price;
		this.noOfOrderPlaced = noOfOrderPlaced;
	}

	public Long getRegNo() {
		return regNo;
	}

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductOrdered() {
		return productOrdered;
	}

	public void setProductOrdered(String productOrdered) {
		this.productOrdered = productOrdered;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNoOfOrderPlaced() {
		return noOfOrderPlaced;
	}

	public void setNoOfOrderPlaced(Integer noOfOrderPlaced) {
		this.noOfOrderPlaced = noOfOrderPlaced;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDetail [regNo=" + regNo + ", name=" + name + ", productOrdered=" + productOrdered + ", address="
				+ address + ", price=" + price + ", noOfOrderPlaced=" + noOfOrderPlaced + "]";
	}


}

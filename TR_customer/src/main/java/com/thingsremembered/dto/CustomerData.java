package com.thingsremembered.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerData {

	private static final long SerialVersionUID = 10l;
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String address;
	private String city;
	private int pincode;

	public CustomerData() {
		super();

	}

	public CustomerData(Long customerId, String firstName, String lastName, String email, String mobile, String address,
			String city, int pincode) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}

	public CustomerData(String firstName, String lastName, String email, String mobile, String address, String city,
			int pincode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}

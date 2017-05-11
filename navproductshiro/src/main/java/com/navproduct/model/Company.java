package com.navproduct.model;

public class Company extends BaseBean {

	private static final long serialVersionUID = 6266518566371757168L;
	
	Integer id;
	String name;
	String email;
	String address;
	String city;
	String state;
	String country;
	String pincode;


	@Override
	public String toString() {
		return "Company [name=" + name + ",id=" + id + ", pincode=" + pincode + "]";
	}
}

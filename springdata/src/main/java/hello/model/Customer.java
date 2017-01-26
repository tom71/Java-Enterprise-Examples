package hello.model;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	public String id;

	public String firstName;
	public String lastName;
	public String city;

	public Customer() {}

	public Customer(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	@Override
	public String toString()
	{
		return "Customer{" +
		       "id='" + id + '\'' +
		       ", firstName='" + firstName + '\'' +
		       ", lastName='" + lastName + '\'' +
		       ", city='" + city + '\'' +
		       '}';
	}
}
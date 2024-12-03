package br.edu.ifpb.es.daw.entities.unidirecional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;

@Entity(name = "Customer_UNI")
@Table(name = "CUSTOMERS", uniqueConstraints = {
		@UniqueConstraint(name = "UC_CUSTOMER__EMAIL", columnNames = { "EMAIL" })
})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "ADDRESS_FK", nullable = false)
	private Address address;

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Customer)) return false;
		Customer customer = (Customer) o;
		return Objects.equals(email, customer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(email);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", address=" + address +
				'}';
	}
}

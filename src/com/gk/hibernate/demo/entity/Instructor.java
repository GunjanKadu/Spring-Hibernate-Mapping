package com.gk.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// annotate the fields wth db column names
@Entity
@Table(name = "instructor")
public class Instructor {

	// define the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	// setup mapping between instructor and instructor details
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "instructor_detail_id")
	private InstructorDetails instructorDetail;

	// create constructors
	public Instructor() {

	}

	public void Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.firstName = lastName;
		this.email = email;
	}

	// generate getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public InstructorDetails getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetails instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	// generate toStrings() method.
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}

}

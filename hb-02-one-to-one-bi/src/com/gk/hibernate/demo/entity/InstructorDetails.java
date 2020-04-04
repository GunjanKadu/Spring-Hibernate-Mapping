package com.gk.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an entity and map to db table
@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {

	// define the fields
	// annotate the fields wth db column names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobbyString;

	// add new field for instructor i.e bidirectional mapping
	// cascade type not using CascadeType.REMOVE because we only want to delete the constructor details
	@OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Instructor instructor;

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	// create constructors
	public InstructorDetails() {

	}

	public InstructorDetails(String youtubeChannel, String hobbyString) {
		this.youtubeChannel = youtubeChannel;
		this.hobbyString = hobbyString;
	}

	// generate getter/setter
	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobbyString() {
		return hobbyString;
	}

	public void setHobbyString(String hobbyString) {
		this.hobbyString = hobbyString;
	}

	public int getId() {
		return id;
	}

	// generate toStrings() method.
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobbyString=" + hobbyString
				+ "]";
	}

}

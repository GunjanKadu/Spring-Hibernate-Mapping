package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Instructor tempInstructor = new Instructor("Gunjan", "Kadu", "Gunjan.Kadu@gmail.com");

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.GunjanKadu.com/youtube",
					"Love to Play Music");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetails);

			// start a transaction
			session.beginTransaction();

			// save the instructor && this will also save the details object due to
			// cascadetype.all
			System.out.println("Saving Instructors: " + tempInstructor);
			session.save(tempInstructor);

			// commit the transaction

			session.getTransaction().commit();

		} finally {
			// TODO: handle finally clause
		}

	}

}

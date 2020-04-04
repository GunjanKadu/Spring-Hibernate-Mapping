package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor details object
			int theId = 299;
			InstructorDetails theInstructorDetails = session.get(InstructorDetails.class, theId);

			// print the instructor detail
			System.out.println("The Instructor Details found is " + theInstructorDetails);

			// print the associated instructor
			System.out.println("The Associated Instructor is " + theInstructorDetails.getInstructor());

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// handle Connection lead issue
			session.close();
			factory.close();
		}

	}

}

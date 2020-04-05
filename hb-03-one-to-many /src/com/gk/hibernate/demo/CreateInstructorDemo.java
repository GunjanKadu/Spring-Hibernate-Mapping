package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@gmail.com");

			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.ArunKaduu.com/youtube",
					"Love to Play video games");

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

			System.out.println("Done");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}

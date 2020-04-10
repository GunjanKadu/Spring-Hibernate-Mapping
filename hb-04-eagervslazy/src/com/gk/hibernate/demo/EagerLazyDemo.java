package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theid = 13;
			Instructor temInstructor = session.get(Instructor.class, theid);

			System.out.println("luv2code: Instructor" + temInstructor);

			// get the course for instructor
			System.out.println("luv2code: Courses: " + temInstructor.getCourses());

			session.getTransaction().commit();
			System.out.println("luv2code: Done");

		} finally {
			session.close();
			factory.close();
		}

	}

}

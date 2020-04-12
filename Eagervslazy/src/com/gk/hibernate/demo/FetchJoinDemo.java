package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class FetchJoinDemo {

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

//			option 2 adding queries with hql
			int theid = 13;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

			// set Parameter on query
			query.setParameter("theInstructorId", theid);

			// execute query and get instructor
			Instructor temInstructor = query.getSingleResult();
			System.out.println("luv2code: Instructor" + temInstructor);

			session.getTransaction().commit();

			session.close();
			// get the course for instructor

			System.out.println("Printing after the session is closed");

			System.out.println("luv2code: Courses: " + temInstructor.getCourses());

			System.out.println("luv2code: Done");

		} finally {
			session.close();
			factory.close();
		}

	}

}

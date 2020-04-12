package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;
import com.gk.hibernate.demo.entity.Review;
import com.gk.hibernate.demo.entity.Student;

public class DeleteReactCoursesForGunjanDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int theId = 10;

			// get the course from the db
			Course temCourse = session.get(Course.class, theId);

			// deleting the courses
			System.out.println("Deleting the Course" + temCourse);
			session.delete(temCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			session.close();
			factory.close();
		}

	}

}

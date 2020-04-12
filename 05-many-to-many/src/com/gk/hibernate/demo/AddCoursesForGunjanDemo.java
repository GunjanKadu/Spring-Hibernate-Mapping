package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;
import com.gk.hibernate.demo.entity.Review;
import com.gk.hibernate.demo.entity.Student;

public class AddCoursesForGunjanDemo {

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

			int theId = 1;

			// get the student gunjan from the database
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("Loaded Student" + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Web Developement Using java");
			Course tempCourse2 = new Course("Front End Developement Using React");
			Course tempCourse3 = new Course("Front End Developement Using Angular");

			// add students to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);

			// save the courses.
			System.out.println("Saving The Courses");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			session.close();
			factory.close();
		}

	}

}

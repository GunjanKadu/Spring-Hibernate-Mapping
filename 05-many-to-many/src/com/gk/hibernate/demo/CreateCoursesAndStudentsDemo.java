package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Course;
import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;
import com.gk.hibernate.demo.entity.Review;
import com.gk.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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

			// create a course
			Course tempCourse = new Course("Pacman - How to score one million point");

			// save the course .... and leverage the cascade all
			System.out.println("Saving the Course");
			session.save(tempCourse);
			System.out.println("Saved the Course" + tempCourse);

			// create the students
			Student tempStudent1 = new Student("Gunjan", "Kadu", "agunjan.kadu@gmail.com");
			Student tempStudent2 = new Student("Gunjan1", "Kadu1", "agunjan1.kadu1@gmail.com");

			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			// save the students
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Students: " + tempCourse.getStudents());

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			session.close();
			factory.close();
		}

	}

}

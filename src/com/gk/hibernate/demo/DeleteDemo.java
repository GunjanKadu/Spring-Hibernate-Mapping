package com.gk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gk.hibernate.demo.entity.Instructor;
import com.gk.hibernate.demo.entity.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key/id
			int id = 1;
			Instructor temInstructor = session.get(Instructor.class, id);

			System.out.println("Found Instructor : " + temInstructor);

			// Delete the Instructor
			if (temInstructor != null) {
				System.out.println("Deleteing the Instrucctor" + temInstructor);

				// Will also delete the associated object i.e instructor detail related to the
				// instructor object
				session.delete(temInstructor);
			}

			// commit the transaction

			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			// TODO: handle finally clause
		}

	}

}

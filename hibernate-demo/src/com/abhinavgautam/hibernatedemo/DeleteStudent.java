package com.abhinavgautam.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Get a student by student id
			int studentId = 5;
			Student student = session.get(Student.class, studentId);

			// Update the student
			session.delete(student);

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

			// NEW CODE
			// Starting a new session
			session = factory.getCurrentSession();

			// Begin transaction
			session.beginTransaction();

			// Update the student where last name is Doe
			session.createQuery("delete Student where lastName='Don'").executeUpdate();

			// Commit Transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}

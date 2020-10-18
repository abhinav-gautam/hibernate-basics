package com.abhinavgautam.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			// Start a transaction
			session.beginTransaction();
			
			// Get the student object
			int studentId = 5;
			Student student = session.get(Student.class, studentId);

			// Commit transaction
			session.getTransaction().commit();
			
			// Print the student
			System.out.println(student);
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}

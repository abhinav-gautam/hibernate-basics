package com.abhinavgautam.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Create student object
			Student student1 = new Student("Sam", "Esmail", "mr.robot@ecorp.com");
			Student student2 = new Student("Elliot", "Alderson", "elliot@ecorp.com");
			Student student3 = new Student("Darleene", "Alderson", "darleene@fsociety.com");
			Student student4 = new Student("Angela", "Moss", "agela@ecorp.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}

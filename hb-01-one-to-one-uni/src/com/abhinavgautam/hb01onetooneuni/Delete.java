package com.abhinavgautam.hb01onetooneuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hb01onetooneuni.entity.Instructor;
import com.abhinavgautam.hb01onetooneuni.entity.InstructorDetail;

public class Delete {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Get instructor by id
			int id = 2;
			Instructor instructor = session.get(Instructor.class, id);
			
			// Delete the instructor if its not null
			if(instructor != null) {
				session.delete(instructor);
			}

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}

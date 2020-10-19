package com.abhinavgautam.hb02onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hb02onetoonebi.entity.Instructor;
import com.abhinavgautam.hb02onetoonebi.entity.InstructorDetail;

public class Create {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Create instructor and instructor details object
			Instructor instructor = new Instructor("Abhinav","Gautam","abhinav@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("AbhinavYT","Programming");
			
			// Associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the instructor object
			// This will also save the details object because of the CascadeType.ALL
			session.save(instructor);

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}

package com.abhinavgautam.hbegarvslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hbegarvslazy.entity.Course;
import com.abhinavgautam.hbegarvslazy.entity.Instructor;
import com.abhinavgautam.hbegarvslazy.entity.InstructorDetail;

public class CreateCourse {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Create instructor and instructor details object
			Instructor instructor = new Instructor("Ansh","Bhawnani","ansh@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("Bitten Tech","Hacking");
			
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
			session.close();
			factory.close();
		}
	}
}

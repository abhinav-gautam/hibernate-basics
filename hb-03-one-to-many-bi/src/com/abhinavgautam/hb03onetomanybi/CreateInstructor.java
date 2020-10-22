package com.abhinavgautam.hb03onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hb03onetomanybi.entity.Course;
import com.abhinavgautam.hb03onetomanybi.entity.Instructor;
import com.abhinavgautam.hb03onetomanybi.entity.InstructorDetail;

public class CreateInstructor {
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
			// Start a transaction
			session.beginTransaction();
			
			// Get the instructor from the database
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			// Create course 
			Course course1 = new Course("Deep Learning");
			Course course2 = new Course("Machine Learning");
			
			// Add course to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// Save the course
			session.save(course1);
			session.save(course2);
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}
}

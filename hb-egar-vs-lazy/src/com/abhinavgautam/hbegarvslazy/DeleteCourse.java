package com.abhinavgautam.hbegarvslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hbegarvslazy.entity.Course;
import com.abhinavgautam.hbegarvslazy.entity.Instructor;
import com.abhinavgautam.hbegarvslazy.entity.InstructorDetail;

public class DeleteCourse {
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
		
			// Get the course from the database
			int id = 1;
			Course course = session.get(Course.class, id);

			// Delete the courseif its not null
			if (course != null) {
				session.delete(course);
			}

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}
}

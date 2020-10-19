package com.abhinavgautam.hb02onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hb02onetoonebi.entity.Instructor;
import com.abhinavgautam.hb02onetoonebi.entity.InstructorDetail;

public class DeleteInstructorDetail {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

//			// Get instructor by id
//			int id = 3;
//			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
//			
//			// Delete the instructor if its not null
//			if(instructorDetail != null) {
//				session.delete(instructorDetail);
//			}

			// Delete instructor detail only
			int id = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			// Delete the instructor if its not null and remove the instructor detail
			// association from the instructor class
			if (instructorDetail != null) {
				instructorDetail.getInstructor().setInstructorDetail(null);
				session.delete(instructorDetail);
			}

			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}

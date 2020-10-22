package com.abhinavgautam.hb03onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhinavgautam.hb03onetomanybi.entity.Course;
import com.abhinavgautam.hb03onetomanybi.entity.Instructor;
import com.abhinavgautam.hb03onetomanybi.entity.InstructorDetail;

public class ReadInstructorCourse {
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
			
			// Get instructor from the database
			Instructor instructor = session.get(Instructor.class, 1);
			
			// Get the courses list from the instructor
			System.out.println("Instructor:"+instructor);
			System.out.println("Courses:"+instructor.getCourses());
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			session.close();
			factory.close();
		}
	}
}

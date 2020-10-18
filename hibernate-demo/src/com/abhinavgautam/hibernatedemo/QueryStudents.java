package com.abhinavgautam.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudents {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Get the list of all students
			System.out.println("List of all students");
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);

			// Get the list of students where lastName is Doe
			System.out.println("\n\nList of all students where lastName is Doe");
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			displayStudents(students);

			// Get the list of students where lastName is Doe and firstName is Angela
			System.out.println("\n\nList of students where lastName is Doe and firstName is Angela");
			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Angela'")
					.getResultList();
			displayStudents(students);

			// Get the list of students where email LIKE gmail.com
			System.out.println("\n\nList of students where email LIKE gmail.com");
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudents(students);

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student stud : students) {
			System.out.println(stud);
		}
	}
}

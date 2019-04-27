package com.ann.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anne.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// now use session object to save and retrieve java object
			
			//create student object
			System.out.println("Create new student object...");
			Student tempStudent = new Student("Mody", "Sakho", "mody@gmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println(tempStudent);
			System.out.println("saving the student....");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			// My new code
			
			// find out the student's: Primary key 
			System.out.println("saved student. Generate id " + tempStudent.getId());
			System.out.println("Done");
			
			// now get a session and start transaction
				session = factory.getCurrentSession();
				session.beginTransaction();
				
			//retrieve student based on id: Primary key
				System.out.println("\nGetting student with id: " + tempStudent.getId());
				Student myStudent = session.get(Student.class, tempStudent.getId());
				System.out.println("Get complete " + myStudent);
				
			//commit the transaction
				session.getTransaction().commit();
			
			
			
			
			
		} finally {
			factory.close();
		}

	}
}

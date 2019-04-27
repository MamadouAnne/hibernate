package com.ann.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anne.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Mamadou", "Anne", "mamadiankha@gmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student....");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}
}

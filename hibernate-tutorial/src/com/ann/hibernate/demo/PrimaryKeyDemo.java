package com.ann.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anne.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// now use session object to save and retrieve java object
			
			//create 3 student object
			System.out.println("Create 3 student object...");
			Student tempStudent1 = new Student("Papa", "Ndiaye", "ndiaye@gmail.com");
			Student tempStudent2 = new Student("Doudou", "Diop", "diop@gmail.com");
			Student tempStudent3 = new Student("Assane", "Kane", "kane@gmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student....");

			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}		
		
}



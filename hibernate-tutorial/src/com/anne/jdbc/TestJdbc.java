package com.anne.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		//Testing the connection 

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
				System.out.println("connecting to database " + jdbcUrl );
				Connection myConn = 
						DriverManager.getConnection(jdbcUrl, user, pass);
				System.out.println("connection successful!!");
		} catch

		(Exception exc) {

			exc.printStackTrace();
		}

	}

}

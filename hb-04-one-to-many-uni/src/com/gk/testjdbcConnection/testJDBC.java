package com.gk.testjdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class testJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
				String user = "hbstudent";
				String pass = "hbstudent";
				// TODO Auto-generated method stub
				try {
					System.out.println("Connecting To DataBase" + jdbcURL);

					Connection myConnection = DriverManager.getConnection(jdbcURL, user, pass);
					System.out.println("Connection Successfull");

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

	}

}

	
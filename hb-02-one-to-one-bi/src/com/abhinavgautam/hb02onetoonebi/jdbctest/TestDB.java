package com.abhinavgautam.hb02onetoonebi.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {

	public static void main(String[] args) {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
			String username = "root";
			String password = "91189";
			
			Connection connection = DriverManager.getConnection(dbUrl,username,password);
			System.out.println("Database Connected");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}

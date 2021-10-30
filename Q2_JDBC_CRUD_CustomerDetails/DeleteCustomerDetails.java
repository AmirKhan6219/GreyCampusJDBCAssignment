package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomerDetails {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		String sql = "delete from customer_details where cid = 2";

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "Amir@123");
			statement = connection.createStatement();
			int count = statement.executeUpdate(sql);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCustomerDetails {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)";

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "Amir@123");
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, 2);
			prepareStatement.setString(2, "Amir");
			prepareStatement.setString(3, "Khan");
			prepareStatement.setString(4, "Sakinaka");
			prepareStatement.setString(5, "Mumbai");
			prepareStatement.setString(6, "Maharashtra");
			prepareStatement.setInt(7, 125463);
			prepareStatement.setString(8, "Laptop");
			prepareStatement.setDate(9, date);
			prepareStatement.setString(10, "Anuj");
			prepareStatement.setDate(11, date);
			prepareStatement.setString(12, "Amir");
			int count = prepareStatement.executeUpdate();
			System.out.println(count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
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

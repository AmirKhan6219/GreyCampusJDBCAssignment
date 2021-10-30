package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadCustomerDetails {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String sql="select * from customer_details";

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "Amir@123");
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				System.out.println(resultset.getString(4));
				System.out.println(resultset.getString(5));
				System.out.println(resultset.getString(6));
				System.out.println(resultset.getInt(7));
				System.out.println(resultset.getString(8));
				System.out.println(resultset.getDate(9));
				System.out.println(resultset.getString(10));
				System.out.println(resultset.getDate(11));
				System.out.println(resultset.getString(12));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

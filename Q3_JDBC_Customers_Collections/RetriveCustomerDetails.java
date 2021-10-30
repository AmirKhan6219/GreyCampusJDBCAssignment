package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetriveCustomerDetails {

	public ArrayList<CustomerDetails> getData() {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = "select * from customer_details";
		ArrayList<CustomerDetails> customerList = new ArrayList<CustomerDetails>();
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "Amir@123");
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				CustomerDetails details = new CustomerDetails();
				details.setCid(rs.getInt(1));
				details.setFirstname(rs.getString(2));
				details.setLastname(rs.getString(3));
				details.setStreet(rs.getString(4));
				details.setCity(rs.getString(5));
				details.setState(rs.getString(6));
				details.setZipcode(rs.getInt(7));
				details.setProduct_name(rs.getString(8));
				details.setCreated_on(rs.getDate(9));
				details.setCreated_by(rs.getString(10));
				details.setUpdate_on(rs.getDate(11));
				details.setUpdated_by(rs.getString(12));
				customerList.add(details);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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

		return customerList;

	}
}

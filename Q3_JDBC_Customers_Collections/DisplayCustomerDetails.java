package com.greycampus;

import java.util.ArrayList;

public class DisplayCustomerDetails {

	public static void main(String[] args) {

		RetriveCustomerDetails customerDetails = new RetriveCustomerDetails();
		ArrayList<CustomerDetails> list = customerDetails.getData();
		
		list.forEach(data -> {
			System.out.println(data.getCid());
			System.out.println(data.getFirstname());
			System.out.println(data.getLastname());
			System.out.println(data.getStreet());
			System.out.println(data.getCity());
			System.out.println(data.getState());
			System.out.println(data.getZipcode());
			System.out.println(data.getCreated_on());
			System.out.println(data.getCreated_by());
			System.out.println(data.getUpdate_on());
			System.out.println(data.getUpdated_by());
		});
	}

}

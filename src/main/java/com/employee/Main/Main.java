package com.employee.Main;

import com.employee.Main.Company;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("D:\\GJANAM\\Assignment2b\\Project\\src\\main\\java\\com\\employee\\Main\\Employee.xml");
			ObjectMapper mapper = new XmlMapper();
			TypeReference<List<Company>> typeReference = new TypeReference<>() {
			};
			List<Company> employeesList = mapper.readValue(inputStream, typeReference);
			inputStream.close();

			for (Company employee : employeesList) {
				String position = employee.getPosition();

				if ("Quality Engineer".equals(position)) {
					System.out.println(employee.getName());
					employee.Database();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

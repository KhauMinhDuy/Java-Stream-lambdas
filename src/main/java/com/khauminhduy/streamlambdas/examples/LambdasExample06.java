package com.khauminhduy.streamlambdas.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample06 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		try (FileWriter writer = new FileWriter("products.txt");){
//			for(Product product : products) {
//				writer.write(product.toString() + "\n");
//			}
			
			// According to forEach(), the lambda expression implements interface Consumer. The accept() method
            // of this interface does not declare any checked exceptions, so the lambda expression is not allowed
            // to throw any checked exceptions. We are forced to handle the IOException inside the lambda expression.
			products.forEach(product -> {
				try {
					writer.write(product.toString() + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
		} catch (IOException e) {
			System.err.println("An Exception Occurrend: " + e.getMessage());
		}
	}
	
}

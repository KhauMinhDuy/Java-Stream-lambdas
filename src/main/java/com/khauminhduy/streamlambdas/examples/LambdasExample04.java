package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample04 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		BigDecimal priceLimit = new BigDecimal("5.0");
		
		int numberOfCheapProducts = 0;
		
		for (Product product : products) {
			if (product.getPrice().compareTo(priceLimit) < 0) {
				numberOfCheapProducts++;
			}
		}
		
		// Because local variables are effectively final, you cannot modify them inside a lambda expression.
//		products.forEach(product -> {
//			if(product.getPrice().compareTo(priceLimit) < 0) {
//				numberOfCheapProducts++; // Error: Variable must be effectively final
//			}
//		});
		
		System.out.println("There are " + numberOfCheapProducts + " cheap products");
	}
	
}

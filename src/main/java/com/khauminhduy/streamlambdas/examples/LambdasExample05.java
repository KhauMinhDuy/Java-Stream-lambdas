package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample05 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		BigDecimal priceLimit = new BigDecimal("5.0");
		
		List<Product> cheapProducts = new ArrayList<>();
		
		// BAD PRACTICE! Modifying cheapProducts inside the body of the lambda expression.
        // In general, avoid side effects such as modifying objects from captured variables in lambda expressions.
		products.forEach(product -> {
			if(product.getPrice().compareTo(priceLimit) < 0) {
				cheapProducts.add(product);
			}
		});
		
		cheapProducts.forEach(System.out::println);
	}
	
}

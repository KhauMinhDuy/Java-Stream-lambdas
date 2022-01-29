package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample07 {

	interface ProductFactory {
		Product create(Category category, String name, BigDecimal price);
	}

	static boolean isExpensive(Product product) {
		return product.getPrice().compareTo(new BigDecimal("5.0")) >= 0;
	}

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();

		products.forEach(System.out::println);

		products.removeIf(LambdasExample07::isExpensive);

		// @formatter:off
		products.stream()
				.map(Product::getName)
				.forEach(System.out::println);
 
		// @formatter:on

		ProductFactory factory = Product::new;
		Product product = factory.create(Category.FOOD, "Blueberries", new BigDecimal("6.95"));
		System.out.println(product);
		
	}

}

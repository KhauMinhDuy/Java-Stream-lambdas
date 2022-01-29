package com.khauminhduy.streamlambdas.examples;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class BasicStreamsExample03 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		products.stream()
				.filter(product -> product.getCategory() == Category.FOOD)
				.forEach(System.out::println);
		
		products.stream()
				.map(product -> String.format("The price of %s is $ %.2f", product.getName(), product.getPrice()))
				.forEach(System.out::println);
		
		Pattern spaces = Pattern.compile("\\s+");
		products.stream()
				.flatMap(product -> spaces.splitAsStream(product.getName()))
				.forEach(System.out::println);
		
		Stream<String> stream = products.stream()
				.flatMap(product -> spaces.splitAsStream(product.getName()));
		
	}
	
}

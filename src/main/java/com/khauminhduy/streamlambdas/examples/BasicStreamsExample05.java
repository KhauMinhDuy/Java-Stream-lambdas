package com.khauminhduy.streamlambdas.examples;

import java.util.List;
import java.util.stream.Collectors;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class BasicStreamsExample05 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		List<String> foodProductsName = products.stream()
				.filter(product -> product.getCategory() == Category.FOOD)
				.map(Product::getName)
				.collect(Collectors.toList());
		System.out.println(foodProductsName);
		
		String categories = products.stream()
				.map(Product::getCategory)
				.distinct()
				.map(Category::name)
				.collect(Collectors.joining("; "));
		System.out.println(categories);
		
	}
	
}

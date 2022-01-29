package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class AdvancedStreamsExample04 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		Map<Category, BigDecimal> totalPerCategory = products.stream()
				.collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add));
		
		System.out.println(totalPerCategory);
		

		Map<Category, List<Product>> productsByCategory = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory));
		System.out.println(productsByCategory);
		
		Map<Category, List<String>> productNameByCategory = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));
		System.out.println(productNameByCategory);
		
		Map<Category, BigDecimal> totalPerCategory2 = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
		System.out.println(totalPerCategory2);
	}
	
}

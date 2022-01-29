package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class AdvancedStreamsExample05 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();

		BigDecimal priceLimit = new BigDecimal("5.00");
		
		Map<Boolean, List<Product>> partitionedProducts = products.stream()
				.collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(priceLimit) < 0));
		
		System.out.println("Cheap products: ");
		partitionedProducts.get(true).forEach(System.out::println);
		
		System.out.println("Expensive products: ");
		partitionedProducts.get(false).forEach(System.out::println);
		
	}

}

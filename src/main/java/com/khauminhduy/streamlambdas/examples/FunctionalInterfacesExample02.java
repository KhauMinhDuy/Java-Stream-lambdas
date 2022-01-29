package com.khauminhduy.streamlambdas.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class FunctionalInterfacesExample02 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		Map<Category, List<Product>> productByCategory = new HashMap<>();
		
//		// Without functional interfaces and lambda expressions.
//		for(Product product : products) {
//			
//			Category category = product.getCategory();
//			
//			// Check if the map already has a List for this category; if not, add one.
//			if(!productByCategory.containsKey(category)) {
//				productByCategory.put(category, new ArrayList<>());
//			}
//			
//			// Add the product to the appropriate list in the map.
//			productByCategory.get(category).add(product);
//			
//		}
		
		for(Product product : products) {
			
			Category category = product.getCategory();
			
			productByCategory.computeIfAbsent(category, c -> new ArrayList<>()).add(product);
			
		}
		
		productByCategory.forEach((category, ps) -> {
			System.out.println("Category: " + category);
			ps.forEach(p -> System.out.println("- " + p.getName()));
		});
		
		
	}
	
}

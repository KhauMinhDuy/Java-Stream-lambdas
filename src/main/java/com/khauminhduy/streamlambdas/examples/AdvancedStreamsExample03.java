package com.khauminhduy.streamlambdas.examples;

import java.util.ArrayList;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class AdvancedStreamsExample03 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		ArrayList<Object> productName1 = products.stream()
				.reduce(
					new ArrayList<>(),
					(list, product) -> {
						ArrayList<Object> newList = new ArrayList<>(list);
						newList.add(product.getName());
						return newList;
					},
					(list1, list2) -> {
						ArrayList<Object> newList = new ArrayList<>(list1);
						newList.addAll(list2);
						return newList;
					}
				);
		
		System.out.println(productName1);
		
		List<Object> productName2 = products.stream()
			.collect(
				ArrayList::new, 
				(list, product) -> list.add(product.getName()),
				ArrayList::addAll
			);
		
		System.out.println(productName2);
	}

}

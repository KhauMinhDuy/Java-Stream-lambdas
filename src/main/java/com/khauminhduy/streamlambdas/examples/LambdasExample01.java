package com.khauminhduy.streamlambdas.examples;

import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample01 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
//		products.sort(new Comparator<Product>() {
//
//			@Override
//			public int compare(Product p1, Product p2) {
//				return p1.getPrice().compareTo(p2.getPrice());
//			}
//		});
		
		products.sort((product1, product2) -> product1.getPrice().compareTo(product2.getPrice()));
		
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
}

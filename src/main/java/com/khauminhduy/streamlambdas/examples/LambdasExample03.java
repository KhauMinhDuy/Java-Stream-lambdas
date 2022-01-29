package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample03 {

	interface ProductFilter {
		boolean accept(Product product);
	}
	
	static void printProduct(List<Product> products, ProductFilter productFilter) {
		for(Product product : products) {
			if(productFilter.accept(product)) {
				System.out.println(product);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		BigDecimal priceLimit = new BigDecimal("5.0");
		
		printProduct(products, product -> product.getPrice().compareTo(priceLimit) < 0);
	}
	
}

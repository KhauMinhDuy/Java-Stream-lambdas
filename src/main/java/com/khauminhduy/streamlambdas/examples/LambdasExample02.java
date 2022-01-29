package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class LambdasExample02 {

	public static void printProduct(List<Product> products, BigDecimal priceLimit) {
		for (Product product : products) {
			if (product.getPrice().compareTo(priceLimit) < 0) {
				System.out.println(product);
			}
		}
	}

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();

		BigDecimal priceLimit = new BigDecimal("5.00");

		printProduct(products, priceLimit);
	}

}

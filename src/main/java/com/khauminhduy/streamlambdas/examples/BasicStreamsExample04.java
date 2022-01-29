package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class BasicStreamsExample04 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();

		Optional<Product> opt = products.stream().filter(product -> product.getCategory() == Category.OFFICE)
				.findFirst();
		opt.ifPresent(System.out::println);

		Optional<Product> optional = products.stream().filter(product -> product.getCategory() == Category.OFFICE)
				.findAny();
		optional.ifPresent(System.out::println);

		boolean foundOfficeProduct = products.stream().anyMatch(product -> product.getCategory() == Category.OFFICE);
		System.out.println("Does the list contain at least one office product? " + foundOfficeProduct);

		BigDecimal priceLimit = new BigDecimal("10.00");
		boolean allProductAreCheap = products.stream()
				.allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
		System.out.println("Are all products cheap? " + allProductAreCheap);

		boolean allProductsAreExpensive = products.stream()
				.noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
		System.out.println("Are All products expensive? " + allProductsAreExpensive);

	}

}

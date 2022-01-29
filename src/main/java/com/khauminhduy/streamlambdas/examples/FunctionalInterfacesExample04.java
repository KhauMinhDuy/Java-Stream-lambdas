package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.khauminhduy.streamlambdas.Category;
import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class FunctionalInterfacesExample04 {

	static Optional<Product> findProduct(List<Product> products, Predicate<Product> productFilter) {
		for (Product product : products) {
			if (productFilter.test(product)) {
				return Optional.of(product);
			}
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();

		String productName = "Spaghetti";

		BigDecimal priceLimit = new BigDecimal("2.0");

		Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
		Predicate<Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;

		// @formatter:off
		findProduct(products, isFood.and(isCheap))
			.ifPresentOrElse(
				System.out::println, 
				() -> System.out.printf("%s is not available %n", productName)
			);
		// @formatter:on

	}

}

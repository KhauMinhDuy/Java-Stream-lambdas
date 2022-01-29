package com.khauminhduy.streamlambdas.examples;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class FunctionalInterfacesExample01 {

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

		// @formatter:off
		findProduct(products, product -> product.getName().equalsIgnoreCase(productName))
									.map(Product::getPrice)
									.ifPresentOrElse(
										price -> System.out.printf("The price of %s is $ %.2f", productName, price), 
										() -> System.out.printf("%s is not available %n", productName)
									);
		// @formatter:on

	}

}

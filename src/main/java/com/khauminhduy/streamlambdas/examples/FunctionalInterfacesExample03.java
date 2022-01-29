package com.khauminhduy.streamlambdas.examples;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class FunctionalInterfacesExample03 {

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
		Function< Product, BigDecimal> productToPrice = Product::getPrice;
		Function<BigDecimal, String> priceToMessage = price -> String.format("The price of %s is $ %.2f", productName, price);
		
		Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);
		
		findProduct(products, product -> product.getName().equalsIgnoreCase(productName))
			.map(productToMessage)
			.ifPresentOrElse(
				System.out::println, 
				() -> System.out.printf("%s is not available %n", productName)
			);
		// @formatter:on

	}

}

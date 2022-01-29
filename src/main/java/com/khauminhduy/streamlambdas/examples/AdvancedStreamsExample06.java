package com.khauminhduy.streamlambdas.examples;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class AdvancedStreamsExample06 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		DoubleStream prices = products.stream()
				.mapToDouble(product -> product.getPrice().doubleValue());
		
		double price = prices.sum();
		System.out.printf("The sum of all product prices is $ %.2f%n", price);
		
		DoubleSummaryStatistics statisstics = products.stream()
				.mapToDouble(product -> product.getPrice().doubleValue())
				.summaryStatistics();
		
		System.out.printf("Count : %d%n", statisstics.getCount());
		System.out.printf("Sum: $ %.2f%n", statisstics.getSum());
		System.out.printf("Minimum: $ %.2f%n", statisstics.getMin());
		System.out.printf("Maximum: $ %.2f%n", statisstics.getMax());
		System.out.printf("Average: $ %.2f%n", statisstics.getAverage());
		
	}

}

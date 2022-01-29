package com.khauminhduy.streamlambdas.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.khauminhduy.streamlambdas.ExampleData;
import com.khauminhduy.streamlambdas.Product;

public class BasicStreamsExample02 {

	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		Stream<Product> stream1 = products.stream();
		
		String[] array = new String[] {"one", "two", "three"};
		Stream<String> stream2 = Arrays.stream(array);
		
		Stream<String> stream3 = Stream.of("one", "two", "three");
		
		Stream<String> stream4 = Stream.ofNullable("four");
		
		Stream<Object> stream5 = Stream.empty();
		
		// Returns an infinite stream of random numbers between 1 (inclusive) and 7 (exclusive)
		IntStream dice = new Random().ints(1, 7);
		
		
		
	}

}

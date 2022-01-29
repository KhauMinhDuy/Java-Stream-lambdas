package com.khauminhduy.streamlambdas;

import java.math.BigDecimal;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

	private final Category category;
	private final String name;
	private final BigDecimal price;

	public static final Comparator<Product> BYNAME = (o1, o2) -> o1.getName().compareTo(o2.getName());

}

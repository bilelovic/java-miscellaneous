package com.bilelovic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Selector {

	public static int totlValues(List<Integer> numbers, Predicate<Integer> selector) {
		return numbers.stream().filter(selector).reduce(0, Math::addExact);
	}

	public static int doubleIt(int number) {
		try {
			Thread.sleep(1000);

		} catch (Exception ex) {

		}
		return number * 2;
	}

	public static void main(String[] args) {
		// mixing object composition with functions composition
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(totlValues(values, e -> true));
		System.out.println(totlValues(values, e -> e % 2 == 0));

		// Referential transparency vs parallelStream
		System.out.println(values.parallelStream().mapToInt(Selector::doubleIt).sum());

	}

}

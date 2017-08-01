package com.bilelovic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//testIsPrime();
        doubleFirstEvenNumber();
    }

    
	private static void doubleFirstEvenNumber() {
		//find the double of the first even number greater than 3
		List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);
		Predicate<Integer> isGreaterThan3 = number -> number > 3;
		// function ? 
		Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> 
				number -> number > pivot;
		System.out.println(
		values.stream()
				.filter(isGreaterThan.apply(4))
				.filter(App::isEven)
				.map(App::doubleIt)
				.findFirst()
				.get()
				);
	}


	private static boolean isGreaterThan3(int e) {
		System.out.println("IsGreaterThan "+ e);
		return e > 3;
	}

	private static boolean isEven(int e) {
		System.out.println("isEven "+ e);
		return e % 2 == 0;
	}
	private static int doubleIt(int e) {
		return e*2;
	}

	private static void testIsPrime() {
		System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        System.out.println(isPrime(52536681));
		
	}


	private static boolean isPrime(final int number) {
		IntPredicate isDivisible  = divisor -> number % divisor == 0;
		
		return number > 1 && 
				IntStream.range(2, number)
				.noneMatch(isDivisible);
	}
}

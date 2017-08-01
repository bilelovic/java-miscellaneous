package com.bilelovic;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	testIsPrime();
        
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

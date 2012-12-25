package com.bride.jfractran.programs;

/**
 * Classe permettant de tester les programmes FRACTRAN.
 * @author Maxime BRIDE
 */
public class Main {
	public static void main(String args[]) {
		System.out.println(new Addition(4L, 6L).compute());
		System.out.println(new Subtraction(10L, 3L).compute());
		System.out.println(new Multiplication(8L, 20L).compute());
		System.out.println(new Division(134L, 3L).compute());
		System.out.println(new ConwayPrimeGame(7).compute());
		System.out.println(new Fibonacci(6).compute());
		System.out.println(new Syracuse(15L, 10).compute());
		System.out.println(new HammingWeight(30).compute());
	}
}

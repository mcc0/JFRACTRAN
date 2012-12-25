package com.bride.jfractran.programs;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour la multiplication.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Multiplication
 */
public class Multiplication extends ArithOperation {
	/**
	 * Initialise le programme de multiplication.
	 * @param a Le multiplicande.
	 * @param b Le multiplicateur.
	 */
	public Multiplication(long a, long b) {
		super(a, b, Fractions.MULTIPLICATION);
	}
	
	@Override
	public void process(PrimeDecomposition p) {
		_results.add(p.get(5L));
	}
}

package com.bride.jfractran.programs;

import java.util.ArrayList;

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
	protected void fillResult(PrimeDecomposition last, ArrayList<Long> result) {
		result.add(last.get(5L));
	}
}

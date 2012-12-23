package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour la division euclidiennes.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Division_euclidienne
 */
public class Division extends ArithOperation {
	/**
	 * Initialise le programme de division euclidienne.
	 * Ce programme retourne une liste de deux élements dont le premier est le
	 * quotient
	 * et le second est le reste.
	 * @param a Le dividende.
	 * @param b Le diviseur.
	 */
	public Division(long a, long b) {
		super(a, b, Fractions.DIVISION);
		
		_baseValue.put(11L, 1L);
	}

	@Override
	protected void fillResult(PrimeDecomposition last, ArrayList<Long> result) {
		result.add(last.get(5L));
		result.add(last.get(7L));
	}
}

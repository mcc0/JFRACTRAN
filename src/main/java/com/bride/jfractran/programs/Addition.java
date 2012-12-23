package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour la somme.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Addition
 */
public class Addition extends ArithOperation {
	/**
	 * Initialise le programme d'addition.
	 * @param a Le terme de gauche.
	 * @param b Le terme de droite.
	 */
	public Addition(long a, long b) {
		super(a, b, Fractions.ADDITION);
		
		_baseValue.put(5L, 1L); //5 est premier avec 6.
	}

	@Override
	protected void fillResult(PrimeDecomposition last, ArrayList<Long> result) {
		result.add(last.get(3L));
	}
}

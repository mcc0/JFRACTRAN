package com.bride.jfractran.programs;

import com.bride.jfractran.Filter;
import com.bride.jfractran.Fractions;

import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour la génération de certains termes de la suite de Fibonacci.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Suite_de_Fibonacci
 */
public class Fibonacci extends Sequence {
	/**
	 * Initialise le programme.
	 * @param limit Le nombre de termes voulu pour la suite.
	 */
	public Fibonacci(int limit) {
		super(limit, PrimeDecomposition.decompose(3L), Fractions.FIBONACCI);
		
		_filter = new Filter() {
			public boolean accept(PrimeDecomposition p) {
				return p.size() == 2 && p.containsFactor(2L) &&
						p.containsFactor(3L);
			}
		};
	}

	@Override
	protected long process(PrimeDecomposition p) {
		return p.compute();
	}
}

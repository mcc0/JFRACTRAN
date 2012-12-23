package com.bride.jfractran.programs;

import com.bride.jfractran.Fractions;

/**
 * Programme pour la génération des termes de la suite de Syracuse (compressée).
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Suite_de_Syracuse
 * @link http://fr.wikipedia.org/wiki/Suite_de_Syracuse#La_suite_compress.C3.A9e
 */
public class Syracuse extends ConwayPrimeGame {
	/**
	 * Initialise le programme.
	 * @param limit Le nombre de termes voulu pour la suite.
	 */
	public Syracuse(long n, int limit) {
		super(limit);
		
		_baseValue.put(2L, n);
		_fractions = Fractions.SYRACUSE;
	}
}

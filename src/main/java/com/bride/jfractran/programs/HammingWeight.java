package com.bride.jfractran.programs;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Calcule le poids de Hamming d'un entier (son nombre de 1 dans sa
 * représentartion binaire).
 * @author Maxime BRIDE
 */
public class HammingWeight extends OnlyLast {
	/**
	 * Initialise le programme.
	 * @param a L'entier donc on souhaite connaître de poids de Hamming.
	 */
	protected HammingWeight(int a) {
		super(Fractions.HAMMING_WEIGHT, new PrimeDecomposition());
		
		_baseValue.put(2L, a);
	}

	@Override
	protected void process(PrimeDecomposition p) {
		_results.add(p.get(13L));
	}
}

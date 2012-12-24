package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Filter;
import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour l'algorithme des nombres premiers de Conway.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Algorithme_des_nombres_premiers_de_Conway
 */
public class ConwayPrimeGame extends Sequence {
	/**
	 * Initialise le programme.
	 * @param limit Le nombre de termes voulu pour la suite.
	 */
	public ConwayPrimeGame(int limit) {
		super(limit, PrimeDecomposition.decompose(2L), Fractions.CONWAY_PRIME_GAME);
	
		_filter = new Filter() {
			public boolean accept(PrimeDecomposition p) {
				return p.size() == 1 && p.containsFactor(2L);
			}
		};
	}
	
	@Override
	public ArrayList<Long> process(PrimeDecomposition p) {
		ArrayList<Long> l = new ArrayList<Long>();
		
		l.add(p.get(2L));
		
		return l;
	}
}

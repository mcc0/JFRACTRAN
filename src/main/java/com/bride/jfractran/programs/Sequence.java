package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Représente un programme FRACTRAN générant une suite.
 * @author Maxime BRIDE
 */
public abstract class Sequence extends FractranProgram { 
	protected int _limit;
	
	/**
	 * Initialise le programme de génération de suite.
	 * @param limit Le nombre de termes voulu pour la suite.
	 * @param baseValue La valeur de base pour le calcul.
	 * @param fractions Les fractions du programme.
	 */
	public Sequence(int limit, PrimeDecomposition baseValue,
			Fractions fractions) {
		super(fractions, baseValue, limit);
	}
	
	@Override
	protected ArrayList<Long> buildResult(
			ArrayList<PrimeDecomposition> decompositions) {
		ArrayList<Long> result = new ArrayList<Long>();
		
		for(PrimeDecomposition p : decompositions) {
			result.add(process(p));
		}
		
		return result;
	}
	
	/**
	 * Traite la décomposition <code>p</code> pour générer un terme de la suite.
	 * @param p La décomposition à traiter.
	 * @return L'entier issu du traitement de <code>p</code>.
	 */
	protected abstract long process(PrimeDecomposition p);
}

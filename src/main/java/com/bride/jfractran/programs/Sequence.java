package com.bride.jfractran.programs;

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
}

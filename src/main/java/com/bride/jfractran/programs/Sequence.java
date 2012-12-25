package com.bride.jfractran.programs;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.FractranProgram;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Représente un programme FRACTRAN générant une suite.
 * @author Maxime BRIDE
 */
public abstract class Sequence extends FractranProgram { 
	protected int _limit;
	
	/**
	 * Initialise le programme de génération de suite.
	 * @param fractions Les fractions du programme.
	 * @param baseValue La valeur de base pour le calcul.
	 * @param limit Le nombre de termes voulu pour la suite.
	 */
	public Sequence(Fractions fractions, PrimeDecomposition baseValue,
			int limit) {
		super(fractions, baseValue, limit);
	}
}

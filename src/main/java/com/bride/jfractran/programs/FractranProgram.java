package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Filter;
import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Représente un programme FRACTRAN caractérisé par une liste de fractions.
 * @author Maxime BRIDE
 */
public abstract class FractranProgram {
	protected Fractions _fractions;
	protected PrimeDecomposition _baseValue;
	protected int _limit;
	protected Filter _filter;
	
	/**
	 * Initialise le programme avec les fractions spécifiées.
	 * @param fractions Les fractions du programme.
	 * @param baseValue La valeur de base pour le calcul.
	 * @see FractranProgram#FractranProgram(Fractions, PrimeDecomposition, int)
	 */
	protected FractranProgram(Fractions fractions,
			PrimeDecomposition baseValue) {
		this(fractions, baseValue, -1);
	}
	
	/**
	 * Initialise le programme avec les fractions spécifiées.
	 * @param fractions Les fractions du programme.
	 * @param baseValue La valeur de base pour le calcul.
	 * @param limit Le nombre maximal de décompositions à calculer.
	 */
	protected FractranProgram(Fractions fractions,
			PrimeDecomposition baseValue, int limit) {
		_fractions = fractions;
		_baseValue = baseValue;
		_limit = limit;
		_filter = Filter.DEFAULT;
	}
	
	/**
	 * Lance le calcul sur les fractions.
	 * @return Le résultat du calcul.
	 */
	protected ArrayList<Long> compute() {
		ArrayList<PrimeDecomposition> decompositions =
				process(_fractions.compute(_baseValue, _filter, _limit));
		ArrayList<Long> results = new ArrayList<Long>();
		
		for(PrimeDecomposition p : decompositions) {
			results.addAll(process(p));
		}
		
		return results;
	}
	
	/**
	 * Traite la liste des décompositions.
	 * @param decompositions Les décompositions à traiter.
	 * @return La liste des décompositins traitées.
	 */
	protected ArrayList<PrimeDecomposition> process(
			ArrayList<PrimeDecomposition> decompositions) {
		return decompositions;
	}
	
	/**
	 * Transforme une décomposition en entier pour contrsuire la liste des
	 * résultats.
	 * @param p La décomposition à traiter.
	 * @return Une liste d'entiers.
	 */
	protected abstract ArrayList<Long> process(PrimeDecomposition p);
}

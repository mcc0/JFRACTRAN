package com.bride.jfractran;

import java.util.ArrayList;


/**
 * Représente un programme FRACTRAN caractérisé par une liste de fractions.
 * @author Maxime BRIDE
 */
public abstract class FractranProgram {
	protected Fractions _fractions;
	protected PrimeDecomposition _baseValue;
	protected int _limit;
	protected ArrayList<PrimeDecomposition> _decompositions;
	protected ArrayList<Long> _results;
	
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
		_results = new ArrayList<Long>();
		_decompositions = new ArrayList<PrimeDecomposition>();
	}
	
	/**
	 * Lance le calcul sur la liste des fractions avec la décomposition
	 * <code>_baseValue</code> en entrée.
	 * @return Les entiers calculées.
	 * @link http://scienceblogs.com/goodmath/2006/10/27/prime-number-pathology-fractra/
	 */
	public ArrayList<Long> compute() {
		int index = 0;
		int i = 0;
		int s = _fractions.size();
		PrimeDecomposition p;
		PrimeDecomposition d = _baseValue;
		Fraction f;
		
		_results.clear();
		_decompositions.clear();
		
		while(index < s) {
			f = _fractions.get(index);
			p = f.multiply(d);
			
			if(p != null) {
				d = p;
				
				if(_limit < 0 || i < _limit) {
					if(accept(p)) {
						_decompositions.add(p);
						i++;
					}
					
					//On recommence les calculs à la première fraction.
					index = 0;
				} else {
					//On a atteint le nombre maximal de résultats, on s'arrête.
					index = s;
				}
			} else {
				//On continue avec la prochaine fraction.
				index++;
			}
		}
		
		//On traite les décompositions.
		processDecompositions();
		
		return _results;
	}

	/**
	 * Indique si la décomposition <code>p</code> est acceptée.
	 * Par défaut, cette méthode renvoie toujours true. Il faut la surcharger
	 * pour en changer le comportement.
	 * @param p La décomposition à tester.
	 * @return true si la décomposition est acceptée, false sinon.
	 */
	public boolean accept(PrimeDecomposition p) {
		return true;
	}
	
	/**
	 * Traite les décompositions issues du calcul sur les fractions.
	 * Cette méthode appelle la méthode <code>process</code> sur toutes les
	 * décompositions.
	 * @param results Les décompositions à traiter.
	 * @see FractranProgram#process(PrimeDecomposition)
	 */
	protected void processDecompositions() {
		for(PrimeDecomposition pd : _decompositions) {
			process(pd);
		}
	}
	
	/**
	 * Transforme une décomposition en entier(s) pour contrsuire la liste des
	 * résultats.
	 * @param p La décomposition à traiter.
	 */
	protected abstract void process(PrimeDecomposition p);
}

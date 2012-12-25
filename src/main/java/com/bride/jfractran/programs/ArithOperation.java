package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.FractranProgram;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Représente une opération arithmétique binaire élémentaire en FRACTRAN.
 * @author Maxime BRIDE
 */
public abstract class ArithOperation extends FractranProgram {
	protected long _a;
	protected long _b;
	
	/**
	 * Construit l'opération avec les opérandes <code>a</code> et
	 * </code>b</code>.
	 * @param a L'opérande gauche.
	 * @param b L'opérande droite.
	 * @param fractions Les fractions du programme FRACTRAN à utiliser pour le
	 * calcul.
	 */
	public ArithOperation(long a, long b, Fractions fractions) {
		super(fractions, new PrimeDecomposition());

		setOperands(a, b);
	}
	
	/**
	 * Spécifie les opérandes de l'opération.
	 * @param a L'opérande gauche.
	 * @param b L'opérande droite.
	 */
	public void setOperands(long a, long b) {
		_a = a;
		_b = b;
		
		_baseValue.put(2L, _a);
		_baseValue.put(3L, _b);
	}
	
	@Override
	protected void processDecompositions() {
		int s = _decompositions.size();

		/*
		 * En principe, il devrait toujours y avoir au moins une décomposition,
		 * mais restons prudents...
		 */
		if(s > 0) {
			/*
			 * On ne prend que la dernière décomposition qui est la seule à
			 * contenir les informations du calcul.
			 */
			_decompositions = new ArrayList<PrimeDecomposition>(
					_decompositions.subList(s - 1, s));
		}
		
		//On traite les décompositions.
		super.processDecompositions();
	}
}

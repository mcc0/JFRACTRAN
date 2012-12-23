package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
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
	protected ArrayList<Long> buildResult(ArrayList<PrimeDecomposition> decompositions) {
		ArrayList<Long> result = new ArrayList<Long>();
		int s = decompositions.size();
		
		if(s > 0) {
			fillResult(decompositions.get(s - 1), result);
		}
		
		return result;
	}
	
	/**
	 * Remplit le tableau d'entiers pour le résultat du programme.
	 * @param last La dernière décomposition issue du calcul sur les fractions.
	 * @param result La liste des résultats à remplir.
	 */
	protected abstract void fillResult(PrimeDecomposition last,
			ArrayList<Long> result);
}

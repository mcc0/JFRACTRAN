package com.bride.jfractran.programs;

import java.util.ArrayList;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.FractranProgram;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme FRACTRAN n'utilisant que la dernière décomposition pour générer
 * le résultat.
 * @author Maxime BRIDE
 */
public abstract class OnlyLast extends FractranProgram {
	/**
	 * Initialise le programme de génération de suite.
	 * @param fractions Les fractions du programme.
	 * @param baseValue La valeur de base pour le calcul.
	 */
	protected OnlyLast(Fractions fractions, PrimeDecomposition baseValue) {
		super(fractions, baseValue);
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

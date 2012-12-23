package com.bride.jfractran;

/**
 * Filtre les décompositions lors du calcul (notamment pour le calcul avec les
 * suites).
 * @author Maxime BRIDE
 */
public interface Filter {
	/**
	 * Filtre par défaut qui ne filtre rien.
	 */
	public static final Filter DEFAULT = new Filter() {
		public boolean accept(PrimeDecomposition p) {
			return true;
		}
	};
	
	/**
	 * Indique si la décomposition <code>p</code> est acceptée.
	 * @param p La décomposition à tester.
	 * @return true si la décomposition est acceptée, false sinon.
	 */
	public boolean accept(PrimeDecomposition p);
}

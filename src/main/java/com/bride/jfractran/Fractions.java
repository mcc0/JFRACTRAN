package com.bride.jfractran;

import java.util.ArrayList;

/**
 * Représente une suite de fractions pour un programme FRACTRAN.
 * @author Maxime BRIDE
 */
@SuppressWarnings("serial")
public class Fractions extends ArrayList<Fraction> {
	/**
	 * Les fractions de l'addition.
	 */
	public static final Fractions ADDITION = Fractions.create(3L, 2L);
	
	/**
	 * Les fractions de la soustraction.
	 */
	public static final Fractions SUBTRACTION = Fractions.create(1L, 6L);
	
	/**
	 * Les fractions de la multiplication.
	 */
	public static final Fractions MULTIPLICATION = Fractions.create(
			455L, 33L, 11L, 13L, 1L, 11L, 3L, 7L, 11L, 2L, 1L, 3L);
	
	/**
	 * Les fractions de la division.
	 */
	public static final Fractions DIVISION = Fractions.create(
			91L, 66L, 11L, 13L, 1L, 33L, 85L, 11L,
			57L, 119L, 17L, 19L, 11L, 17L, 1L, 3L);
	
	/**
	 * Les 14 fractions fantastiques pour l'algorithme des nombres premiers de
	 * Conway.
	 */
	public static final Fractions CONWAY_PRIME_GAME = Fractions.create(
			17L, 91L, 78L, 85L, 19L, 51L, 23L, 38L, 29L, 33L, 77L, 29L, 95L, 23L,
			77L, 19L, 1L, 17L, 11L, 13L, 13L, 11L, 15L, 14L, 15L, 2L, 55L, 1L);
	
	/**
	 * Les fractions pour la génération des termes de la suite de Fibonacci.
	 */
	public static final Fractions FIBONACCI = Fractions.create(
			23L, 95L, 57L, 23L, 17L, 39L, 130L, 17L, 11L, 14L, 35L,
			11L, 19L, 13L, 1L, 19L, 35L, 2L, 13L, 7L, 7L, 1L);
	
	/**
	 * Les fractions pour la génération des termes de la suite de Syracuse
	 * (version compressée).
	 */
	public static final Fractions SYRACUSE = Fractions.create(
			1L, 11L, 136L, 15L, 5L, 17L, 4L, 5L, 26L, 21L,
			7L, 13L, 1L, 7L, 33L, 4L, 5L, 2L, 7L, 1L);
	
	/**
	 * Les fractions pour la génération des termes de la suite de Syracuse
	 * (version compressée).
	 */
	public static final Fractions HAMMING_WEIGHT = Fractions.create(
			33L, 20L, 5L, 11L, 13L, 10L, 1L, 5L, 2L, 3L, 10L, 7L, 7L, 2L);
	
	/**
	 * Construit une liste de fractions avec les valeurs spécifiées.
	 * Il n'y a pas de constructeur prenant une liste d'entiers car si un
	 * entier de la liste est nul ou négatif, sa décomposition lancera une
	 * exception. Or, il est déconseillé d'écrire des constructeurs
	 * susceptibles de lancer des exceptions.
	 * @param values Les valeurs à ajouter.
	 * @return Un objet <code>Fractions</code> contenant la liste des fractions.
	 * @see Fractions#add(long...)
	 */
	public static Fractions create(long... values) {
		Fractions fractions = new Fractions();
		
		fractions.add(values);
		
		return fractions;
	}
	
	/**
	 * Ajoute les valeurs spécifiées.
	 * Chaque couple de valeurs correspond à un numérateur et à un dénominateur.
	 * Ainsi <code>n</code> valeurs créent <code>n/2</code> fractions.
	 * Si <code>n</code> est impair, on ajoute un 1 à la liste.
	 * @param values Les valeurs des couples numérateur/dénominateur.
	 */
	public void add(long... values) {
		for(int i = 0; i < values.length; i += 2) {
			long v2 = i + 1 < values.length ? values[i + 1] : 1;
			
			add(new Fraction(PrimeDecomposition.decompose(values[i]),
					PrimeDecomposition.decompose(v2)));
		}
	}
}

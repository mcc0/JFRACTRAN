package com.bride.jfractran;

/**
 * Représente une fraction d'un programme FRACTRAN.
 * @author Maxime BRIDE
 */
public class Fraction {
	private PrimeDecomposition _numerator;
	private PrimeDecomposition _denominator;
	
	/**
	 * Spécifie le numérateur et le dénominateur de la fraction avec des
	 * décompositions.
	 * @param numerator Le numérateur de la fraction.
	 * @param denominator Le dénominateur de la fraction.
	 */
	public Fraction(PrimeDecomposition numerator,
			PrimeDecomposition denominator) {
		_numerator = numerator;
		_denominator = denominator;
	}

	/**
	 * Multiplie la fraction avec une décomposition.
	 * @param factor La facteur de la multiplication.
	 * @return La décomposition issue de la multiplication.
	 * Le résultat est nul si <code>(numerator * factor) / denominator</code>
	 * n'est pas entier.
	 */
	public PrimeDecomposition multiply(PrimeDecomposition factor) {
		return _numerator.multiply(factor).divide(_denominator);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Fraction)) {
			return false;
		}
		
		if(o == this) {
			return true;
		}
		
		Fraction f = (Fraction)o;
		
		return _numerator.equals(f._numerator) &&
				_denominator.equals(f._denominator);
	}
}

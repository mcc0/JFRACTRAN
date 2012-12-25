package com.bride.jfractran.programs;

import com.bride.jfractran.Fractions;
import com.bride.jfractran.PrimeDecomposition;

/**
 * Programme pour la soustrction.
 * @author Maxime BRIDE
 * @link http://fr.wikipedia.org/wiki/FRACTRAN#Soustraction
 */
public class Subtraction extends ArithOperation {
	/**
	 * Initialise le programme de soustrction.
	 * Attention, ça n'est pas une vraie soustraction, en effet, si
	 * <code>a > b</code>, on calcule <code>a - b</code>, mais si
	 * <code>a < b</code>, on calcule <code>b - a</code>. Autrement dit
	 * le diminuende est toujours supérieur au diminuteur. Le résultat
	 * est alors toujours positif ou nul.
	 * @param a Le diminuende.
	 * @param b Le diminuteur.
	 */
	public Subtraction(long a, long b) {
		super(a, b, Fractions.SUBTRACTION);
	}
	
	@Override
	public void process(PrimeDecomposition p) {
		if(_a > _b) {
			_results.add(p.get(2L));
		} else if(_a < _b) {
			_results.add(p.get(3L));
		} else {
			_results.add(0L);
		}
	}
}

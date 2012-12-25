package com.bride.jfractran.programs;

import org.junit.Test;

import com.bride.jfractran.FractranProgramTest;

public class HammingWeightTest extends FractranProgramTest {	
	/**
	 * Teste le calcul du poinds de Hamming.
	 */
	@Test
	public void testCompute() {
		for(int i = 1; i <= 100; i++) {
			assertEquals((long)new HammingWeight(i).compute().get(0),
					(long)hammingWeight(i));
		}
	}
	
	/**
	 * Calcule le poids de Hamming de l'entier <code>a</code>.
	 * @param a L'entier donc on veut le poids de Hamming.
	 * @return Le poinds de Hamming de <code>a</code>.
	 */
	private int hammingWeight(int a) {
		int weight = 0;
		
		while(a > 0) {
			weight += a & 1;
			a >>>= 1;
		}
		
		return weight;
	}
}

package com.bride.jfractran.programs;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Teste le programme d'opération arithmétique.
 * @author Maxime BRIDE
 */
public abstract class ArithOperationTest extends FractranProgramTest {
	protected ArithOperation _op;
	
	/**
	 * Teste le calcul de l'opération.
	 */
	@Test
	public void testCompute() {
		ArrayList<Long> result;
		
		for(long a = 1L; a < 15L; a++) {
			for(long b = 1L; b < 15L; b++) {
				_op.setOperands(a, b);
				result = _op.compute();
				for(int i = 0; i < result.size(); i++) {
					assertEquals((long)result.get(i),
						computeResult(a, b, i));
				}
				
			}
		}
		
		//Opérande nulle.
		try {
			_op.setOperands(0L, 1L);
			fail();
		} catch(IllegalArgumentException ex) {
			
		}

		//Opérande négative.
		try {
			_op.setOperands(1L, -1L);
			fail();
		} catch(IllegalArgumentException ex) {
			
		}
	}
	
	/**
	 * Renvoie le résultat censé être calculé par l'opération (oracle). 
	 * @param a L'opérande gauche.
	 * @param b L'opérande droite.
	 * @param i L'indice dans le tableau des résultats de l'opération.
	 * @return Le résultat attendu du calcul de l'opération.
	 */
	public abstract long computeResult(long a, long b, int i);
}

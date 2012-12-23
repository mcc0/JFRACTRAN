package com.bride.jfractran.programs;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Before;

/**
 * Teste le programme de génération des termes de la suite de Syracuse.
 * @author Maxime BRIDE
 */
public class SyracuseTest extends SequenceTest {
	@Override
	@Before
	public void setUp() throws Exception {
		int limit = 10;
		
		_sequences = new Hashtable<Sequence, ArrayList<Long>>();
		
		for(long i = 5; i <= 20; i += 5) {
			_sequences.put(new Syracuse(i, limit), generate(i, limit));
		}
	}
	
	/**
	 * Génère les termes de la suite de Syracuse.
	 * @param n Le terme initial (que l'on n'insère pas dans la liste).
	 * @param limit La taille maximale de la suite.
	 * @return La liste des termes de la suite générée.
	 */
	private ArrayList<Long> generate(long n, int limit) {
		ArrayList<Long> result = new ArrayList<Long>();
		
		for(int i = 0; i < limit; i++) {
			if(n % 2 == 0) {
				n /= 2;
			} else {
				n = (n * 3 + 1) / 2;
			}
			result.add(n);
		}
		
		return result;
	}
}

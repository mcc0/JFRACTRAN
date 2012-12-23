package com.bride.jfractran;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Tests unitaires sur les listes fractions.
 * @author Maxime BRIDE
 */
public class FractionsTest extends TestCase {
	/**
	 * Teste la création de fractions.
	 */
	@Test
	public void testCreate() {
		Fractions f1 = Fractions.create(5L, 2L, 7L);
		Fractions f2 = Fractions.create(5L, 2L, 7L, 1L);
		Fractions f3 = new Fractions();
		
		f3.add(5L, 3L);

		assertEquals(f1.get(0), f2.get(0));
		assertEquals(f1.get(1), f2.get(1));
		assertFalse(f2.get(0).equals(f3.get(0)));
	}
	
	/**
	 * Teste le calcul sans filtre sur les fractions.
	 */
	@Test
	public void testCompute() {
		//http://fr.wikipedia.org/wiki/FRACTRAN#Exemple
		ArrayList<PrimeDecomposition> result;
		Fractions f = Fractions.create(3L, 10L, 4L, 3L);
		
		result = f.compute(PrimeDecomposition.decompose(14L));
		assertTrue(result.isEmpty());
		
		result = f.compute(PrimeDecomposition.decompose(15L));
		assertEquals(result.get(0).compute(), 20L);
		assertEquals(result.get(1).compute(), 6L);
		assertEquals(result.get(2).compute(), 8L);
	}
	
	/**
	 * Teste le calcul avec filtre sur les fractions.
	 */
	@Test
	public void testComputeFiltered() {
		//http://fr.wikipedia.org/wiki/FRACTRAN#Exemple
		ArrayList<PrimeDecomposition> result;
		Fractions f = Fractions.create(3L, 10L, 4L, 3L);
		Filter filter = new Filter() {
			@Override
			public boolean accept(PrimeDecomposition p) {
				//Ne prend que les puissances de 2.
				return p.size() == 1 && p.containsFactor(2L);
			}
		};
		
		result = f.compute(PrimeDecomposition.decompose(15L), filter, 1);
		assertEquals(result.get(0).compute(), 8L);
		assertEquals(result.size(), 1);

		result = f.compute(PrimeDecomposition.decompose(15L), filter, 0);
		assertTrue(result.isEmpty());
	}
}

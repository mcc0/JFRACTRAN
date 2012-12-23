package com.bride.jfractran;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Tests unitaires sur les fractions.
 * @author Maxime BRIDE
 */
public class FractionTest extends TestCase{
	/**
	 * Teste la multiplication d'une fraction par un entier décomposé.
	 */
	@Test
	public void testMultiply() {
		PrimeDecomposition p1 = PrimeDecomposition.decompose(10L);
		PrimeDecomposition p2 = PrimeDecomposition.decompose(3L);
		PrimeDecomposition p3 = PrimeDecomposition.decompose(6L);
		PrimeDecomposition p4 = PrimeDecomposition.decompose(7L);
		Fraction f = new Fraction(p1, p2);

		assertEquals(f.multiply(p3).compute(), 20L);
		assertNull(f.multiply(p4));
	}
	
	/**
	 * Test le test d'égalité de deux fractions.
	 */
	@Test
	public void testEquals() {
		Fraction f1 = new Fraction(PrimeDecomposition.decompose(1L),
				PrimeDecomposition.decompose(2L));
		Fraction f2 = new Fraction(PrimeDecomposition.decompose(1L),
				PrimeDecomposition.decompose(2L));
		Fraction f3 = new Fraction(PrimeDecomposition.decompose(2L),
				PrimeDecomposition.decompose(2L));
		Fraction f4 = new Fraction(PrimeDecomposition.decompose(1L),
				PrimeDecomposition.decompose(1L));
		
		assertFalse(f1.equals(null));
		assertFalse(f1.equals(new Object()));
		assertTrue(f1.equals(f1));
		assertTrue(f1.equals(f2));
		assertFalse(f1.equals(f3));
		assertFalse(f1.equals(f4));
	}
}

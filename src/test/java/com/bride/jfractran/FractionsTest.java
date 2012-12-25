package com.bride.jfractran;

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
}

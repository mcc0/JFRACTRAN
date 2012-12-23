package com.bride.jfractran;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Teste les décompositions d'entiers en produits de facteurs premiers.
 * @author Maxime BRIDE
 */
public class PrimeDecompositionTest extends TestCase {
	/**
	 * Teste le constructeur.
	 */
	@Test
	public void testPrimeDecomposition() {
		PrimeDecomposition p1;
		PrimeDecomposition p2;
		
		//Constructeur par défaut.
		p1 = new PrimeDecomposition();
		assertEquals(p1.compute(), 1L);

		//Constructeur de recopie.
		p2 = PrimeDecomposition.decompose(55);
		p1 = new PrimeDecomposition(p2);
		assertEquals(p1, p2);
	}
	
	/**
	 * Teste la décomposition.
	 */
	@Test
	public void testDecompose() {
		PrimeDecomposition p;
		
		//Nombre non premier.
		p = PrimeDecomposition.decompose(58320L);
		assertEquals(p.compute(), 58320L);

		//Nombre premier.
		p = PrimeDecomposition.decompose(13L);
		assertEquals(p.compute(), 13L);

		//Nombre négatif.
		try {
			p = PrimeDecomposition.decompose(-1);
			fail();
		} catch(IllegalArgumentException ex) {
			
		}

		//Nombre nul.
		try {
			p = PrimeDecomposition.decompose(0);
			fail();
		} catch(IllegalArgumentException ex) {
			
		}
	}
	
	/**
	 * Teste l'accès à l'exposant d'un facteur.
	 */
	@Test
	public void testGet() {
		PrimeDecomposition p = PrimeDecomposition.decompose(28L);
		
		assertEquals((long)p.get(7L), 1L);
		assertEquals((long)p.get(2L), 2L);
		assertEquals((long)p.get(3L), 0L);
	}
	
	/**
	 * Teste la modification de l'exposant d'un facteur.
	 */
	@Test
	public void testPut() {
		PrimeDecomposition p = new PrimeDecomposition();
		
		p.put(2L, 3L);
		p.put(5L, 1L);
		assertEquals(p.compute(), 40L);
		
		//Exposant négatif.
		try {
			p.put(2L, -1L);
			fail();
		} catch(IllegalArgumentException ex) {
			
		}
	}
	
	/**
	 * Teste la multiplication de deux décompositions.
	 */
	@Test
	public void testMultiply() {
		PrimeDecomposition p1 = PrimeDecomposition.decompose(18L);
		PrimeDecomposition p2 = PrimeDecomposition.decompose(23L);
		
		assertEquals(p1.multiply(p2).compute(), 18L * 23L);
		
		p1 = new PrimeDecomposition();
		assertEquals(p1.multiply(p2).compute(), 23L);
	}
	
	/**
	 * Teste la division de deux décompositions.
	 */
	@Test
	public void testDivide() {
		PrimeDecomposition p1 = PrimeDecomposition.decompose(6L * 1585L);
		PrimeDecomposition p2 = PrimeDecomposition.decompose(6L);

		assertEquals(p1.divide(p2).compute(), 1585L);
		assertNull(p2.divide(p1));
		
		p2 = new PrimeDecomposition();
		assertEquals(p1.divide(p2).compute(), 6L * 1585L);
	}

	/**
	 * Teste la taille d'une décomposition.
	 */
	@Test
	public void testSize() {
		PrimeDecomposition p1;

		p1 = PrimeDecomposition.decompose(18L);
		assertEquals(p1.size(), 2);

		p1 = new PrimeDecomposition();
		assertEquals(p1.size(), 0);

		p1 = PrimeDecomposition.decompose(30L);
		assertEquals(p1.size(), 3);
	}

	/**
	 * Teste le test de présence d'un facteur dans une décomposition.
	 */
	@Test
	public void testContainsFactor() {
		PrimeDecomposition p1;

		p1 = PrimeDecomposition.decompose(15L);
		assertTrue(p1.containsFactor(3L));
		assertTrue(p1.containsFactor(5L));
		assertFalse(p1.containsFactor(2L));

		p1 = PrimeDecomposition.decompose(37L);
		assertTrue(p1.containsFactor(37L));
	}

	/**
	 * Teste la suppression d'un facteur.
	 */
	@Test
	public void testRemove() {
		PrimeDecomposition p1 = PrimeDecomposition.decompose(5L);

		assertEquals(p1.remove(5L), 1);
		assertEquals(p1.remove(5L), 0);
	}

	/**
	 * Teste le test d'égalité de deux décompositions.
	 */
	@Test
	public void testEquals() {
		PrimeDecomposition p1;
		PrimeDecomposition p2;

		p1 = null;
		p2 = PrimeDecomposition.decompose(5L);
		assertFalse(p2.equals(p1));
		assertFalse(p2.equals(new Object()));
		assertTrue(p2.equals(p2));
		assertTrue(p2.equals(PrimeDecomposition.decompose(5L)));
	}
}

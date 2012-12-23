package com.bride.jfractran;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests unitaires du filtre.
 * @author Maxime BRIDE
 */
public class FilterTest extends TestCase {
	/**
	 * Vérifie que le filtre par défaut accepte tout.
	 */
	@Test
	public void testAccept() {
		assertTrue(Filter.DEFAULT.accept(null));
	}
}

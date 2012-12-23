package com.bride.jfractran.programs;

import org.junit.Before;

/**
 * Teste le programme de soustraction.
 * @author Maxime BRIDE
 */
public class SubtractionTest extends ArithOperationTest {
	@Override
	@Before
	public void setUp() throws Exception {
		_op = new Subtraction(1L, 1L);
	}
	
	@Override
	public long computeResult(long a, long b, int i) {
		//Ce programme soustrait toujours le petit entier au grand entier.
		return Math.max(a, b) - Math.min(a, b);
	}
}

package com.bride.jfractran.programs;

import org.junit.Before;

/**
 * Teste le programme de multiplication.
 * @author Maxime BRIDE
 */
public class MultiplicationTest extends ArithOperationTest {
	@Override
	@Before
	public void setUp() throws Exception {
		_op = new Multiplication(1L, 1L);
	}
	
	@Override
	public long computeResult(long a, long b, int i) {
		return a * b;
	}
}

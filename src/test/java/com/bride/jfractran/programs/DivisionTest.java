package com.bride.jfractran.programs;

import org.junit.Before;

/**
 * Teste le programme de division.
 * @author Maxime BRIDE
 */
public class DivisionTest extends ArithOperationTest {
	@Override
	@Before
	public void setUp() throws Exception {
		_op = new Division(1L, 1L);
	}
	
	@Override
	public long computeResult(long a, long b, int i) {
		//Le programme de division renvoie le quotient et le reste.
		return i == 0 ? (a / b) : (a % b);
	}
}

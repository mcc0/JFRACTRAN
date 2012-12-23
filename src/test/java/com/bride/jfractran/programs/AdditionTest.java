package com.bride.jfractran.programs;

import org.junit.Before;

/**
 * Teste le programme d'addition.
 * @author Maxime BRIDE
 */
public class AdditionTest extends ArithOperationTest {
	@Override
	@Before
	public void setUp() throws Exception {
		_op = new Addition(1L, 1L);  
    }
	
	@Override
	public long computeResult(long a, long b, int i) {
		return a + b;
	}
}

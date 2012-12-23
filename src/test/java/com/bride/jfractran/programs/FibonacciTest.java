package com.bride.jfractran.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import org.junit.Before;

/**
 * Teste le programme de génération des termes de la suite de Fibonacci.
 * @author Maxime BRIDE
 */
public class FibonacciTest extends SequenceTest {
	@Override
	@Before
	public void setUp() throws Exception {
		//Le programme le génère pas tous les termes de la suite.
		Long values[] = { 6L, 18L, 108L, 1944L, 209952L, 408146688L };
		
		_sequences = new Hashtable<Sequence, ArrayList<Long>>();
		_sequences.put(new Fibonacci(values.length),
				new ArrayList<Long>(Arrays.asList(values)));
	}
}

package com.bride.jfractran.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import org.junit.Before;

/**
 * Teste le programme de l'algorithme des nombres premiers de Conway.
 * @author Maxime BRIDE
 */
public class ConwayPrimeGameTest extends SequenceTest {
	@Override
	@Before
	public void setUp() throws Exception {
		Long values[] = { 2L, 3L, 5L, 7L, 11L, 13L, 17L };
		
		_sequences = new Hashtable<Sequence, ArrayList<Long>>();
		_sequences.put(new ConwayPrimeGame(values.length),
				new ArrayList<Long>(Arrays.asList(values)));
	}
}

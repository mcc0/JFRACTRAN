package com.bride.jfractran.programs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.bride.jfractran.FractranProgramTest;

import junit.framework.Assert;

/**
 * Teste un programme FRACTRAN générant une suite.
 * @author Maxime BRIDE
 */
public abstract class SequenceTest extends FractranProgramTest{
	protected Hashtable<Sequence, ArrayList<Long>> _sequences;
	
	/**
	 * Teste le calcul de la suite.
	 */
	@Test
	public void testSequence() {
		Set<Map.Entry<Sequence, ArrayList<Long>>> entries =
				_sequences.entrySet();
		for(Entry<Sequence, ArrayList<Long>> entry : entries) {
			Assert.assertEquals(entry.getKey().compute(), entry.getValue());
		}
	}
}

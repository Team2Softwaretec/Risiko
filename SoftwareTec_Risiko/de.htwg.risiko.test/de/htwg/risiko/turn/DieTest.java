package de.htwg.risiko.turn;

import java.util.Random;

import junit.framework.TestCase;

public class DieTest extends TestCase {

	public void testDie() {
		Die test = new Die();
		assertTrue(test.getRandom() != null);
	}
	
	public void testRoll() {
		int[] a = new int[5];
		int[] res = new int[5];
		res[0] = 4; res[1] = 5; res[2] = 2; res[3] = 4; res[4] = 3;
		Die test = new Die();
		Random r = new Random();
		r.setSeed(1);
		test.setRandom(r);
		test.roll(a);
		for (int i = 0; i < res.length; i++) {
			assertEquals(res[i],a[i]);
		}
	}
}

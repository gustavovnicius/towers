package towers;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import towers.Main.TowerNumber;

public class TowerNumberTest {

	@Test
	public void testGetCalculated() {
		tabularGetCalculatedAssert("2", "2");
		tabularGetCalculatedAssert("4", "2^2");
		tabularGetCalculatedAssert("6561", "9^2^2");
	}

	@Test
	public void testCompareTo() {
		tabularCompareToAssert(0, new TowerNumber("1"), new TowerNumber("1"));
		tabularCompareToAssert(1, new TowerNumber("1", 1), new TowerNumber("1"));
		tabularCompareToAssert(-1, new TowerNumber("1"), new TowerNumber("1", 1));

		tabularCompareToAssert(0, new TowerNumber("2^2"), new TowerNumber("2^2"));
		tabularCompareToAssert(1, new TowerNumber("2^2"), new TowerNumber("2"));
		tabularCompareToAssert(-1, new TowerNumber("2"), new TowerNumber("2^2"));

		tabularCompareToAssert(0, new TowerNumber("2^2"), new TowerNumber("2^2"));
		tabularCompareToAssert(1, new TowerNumber("2^2", 1), new TowerNumber("2^2"));
		tabularCompareToAssert(-1, new TowerNumber("2^2"), new TowerNumber("2^2", 1));
	}

	private void tabularGetCalculatedAssert(String expected, String tower) {
		TowerNumber t = new TowerNumber(tower);
		assertEquals(new BigInteger(expected), t.getCalculated());
	}

	private void tabularCompareToAssert(int expected, TowerNumber t1, TowerNumber t2) {
		assertEquals(expected, t1.compareTo(t2));
	}

}

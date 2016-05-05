package towers;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import towers.Main.TowerNumber;

public class TowerNumberTest {

	@Test
	public void testGetCalculated() {
		TowerNumber t = new TowerNumber("2");
		assertEquals(new BigInteger("2"), t.getCalculated());

		t = new TowerNumber("2^2");
		assertEquals(new BigInteger("4"), t.getCalculated());
	}

}

package fr.ledoublef;

import static org.junit.Assert.*;
import org.junit.Test;

public class AuctionHouseTest {

	@Test
	public void lowerCaseNameTest() {
		AuctionHouse house = new AuctionHouse("Toto");
		AuctionHouse house2 = new AuctionHouse("toto");
		assertEquals(house, house2);
	}

	@Test
	public void equalsTest() {
		AuctionHouse house = new AuctionHouse("bb");
		AuctionHouse house2 = new AuctionHouse("bb");
		assertEquals(house, house2);
		assertEquals(house, house);
	}
}

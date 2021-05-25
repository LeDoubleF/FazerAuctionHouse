package fr.ledoublef;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuctionHouseDaoTest {

	@BeforeEach
	public void clean() {
		AuctionHouseDao.init();
	}

	@Test
	void initTest() {
		String name = "Drouot";
		AuctionHouse house = new AuctionHouse(name);
		assertEquals(3, AuctionHouseDao.getAllAuctionhouses()
			.size());
		assertTrue(AuctionHouseDao.getAllAuctionhouses()
			.contains(house));
	}

	@Test
	void deleteTest() {
		String name = "Drouot";
		AuctionHouse house = new AuctionHouse(name);

		AuctionHouseDao.delete(name);
		assertEquals(2, AuctionHouseDao.getAllAuctionhouses()
			.size());
		assertFalse(AuctionHouseDao.getAllAuctionhouses()
			.contains(house));
	}

	@Test
	void addTest() {
		String name = "Drouot";
		AuctionHouseDao.add(name);
		assertEquals(3, AuctionHouseDao.getAllAuctionhouses()
			.size());
		AuctionHouseDao.add("test1");
		assertEquals(4, AuctionHouseDao.getAllAuctionhouses()
			.size());
		AuctionHouseDao.add(new AuctionHouse("test2"));
		assertEquals(5, AuctionHouseDao.getAllAuctionhouses()
			.size());
	}

	@Test
	void addStringNullValueTest() {
		String name = null;
		try {
			AuctionHouseDao.add(name);
			fail("should throw exception");
		} catch (NullPointerException aExp) {
			assertTrue(aExp.getMessage()
				.contains("A auctionhouse must have a name"));
		}
	}

	@Test
	void addAuctionHouseNullValueTest() {
		AuctionHouse house = null;
		try {
			AuctionHouseDao.add(house);
			fail("should throw exception");
		} catch (NullPointerException aExp) {
			assertTrue(aExp.getMessage()
				.contains("A auctionhouse can't be null"));
		}
	}

	@Test
	void getAuctionHouseByNameTest() {

		String name = "ebay";
		assertEquals(new AuctionHouse(name), AuctionHouseDao.getAuctionHouse(name));
	}

}

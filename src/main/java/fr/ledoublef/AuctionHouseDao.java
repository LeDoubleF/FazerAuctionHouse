package fr.ledoublef;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionHouseDao {

	static Map<String, AuctionHouse> auctionHouses = new HashMap<>();
	static {
		init();
	}

	private AuctionHouseDao() {
		throw new IllegalStateException("Utility class");
	}

	static void init() {
		auctionHouses = new HashMap<>();
		List<String> names = Arrays.asList("Ebay", "Drouot", "Christie's");
		names.forEach(AuctionHouseDao::add);
	}

	public static Collection<AuctionHouse> getAllAuctionhouses() {
		return auctionHouses.values();
	}

	public static AuctionHouse add(AuctionHouse house) {
		if (house == null)
			throw new NullPointerException("A auctionhouse can't be null");

		auctionHouses.put(house.getName(), house);
		return house;
	}

	public static AuctionHouse add(String name) {

		if (name == null)
			throw new NullPointerException("A auctionhouse must have a name");
		String nameLowerCase = name.toLowerCase();
		auctionHouses.put(nameLowerCase, new AuctionHouse(nameLowerCase));
		return auctionHouses.get(nameLowerCase);
	}

	public static AuctionHouse getAuctionHouse(String name) {
		return auctionHouses.get(name.toLowerCase());
	}

	public static void delete(String name) {
		auctionHouses.remove(name.toLowerCase());
	}

}

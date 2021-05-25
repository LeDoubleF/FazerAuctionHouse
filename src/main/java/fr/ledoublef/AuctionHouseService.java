package fr.ledoublef;

import java.util.Collection;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/auctionHouseService")
public class AuctionHouseService {

	@GET
	@Path("/houses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<AuctionHouse> getAuctionHouses() {
		return AuctionHouseDao.getAllAuctionhouses();
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public AuctionHouse add(String auctionhouseName) {
		return AuctionHouseDao.add(auctionhouseName);
	}

	@DELETE
	@Path("/{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void deleteEmployee(@PathParam("name") String name) {
		AuctionHouseDao.delete(name);
	}

}
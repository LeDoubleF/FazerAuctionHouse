package fr.ledoublef;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auctionHouse")

public class AuctionHouse implements Serializable, Comparable<AuctionHouse> {
	// avec un prénom.
	// nom, description, heure de début, heure de fin, début
	// prix, prix courant

	private static final long serialVersionUID = 1L;
	private String name;

	public AuctionHouse() {
	}

	public AuctionHouse(String name) {
		this.name = name.toLowerCase();
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionHouse other = (AuctionHouse) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(AuctionHouse other) {
		if (this.equals(other))
			return 0;
		else if (name.equals(other.getName()))
			return 0;
		else
			return name.compareToIgnoreCase(other.getName());
	}
}

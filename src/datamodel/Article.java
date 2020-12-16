package datamodel;

public class Article {

	private String id;
	private String description;
	private long unitPrice;
	private int unitsInStore;

	protected Article(String id, String description, long unitPrice, int unitsInStore) {
		this.id = id;
		this.description = description;
		this.unitPrice = unitPrice;
		this.unitsInStore = unitsInStore;
	}

	// Getter & Setter

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStore() {
		return unitsInStore;
	}

	public void setUnitsInStore(int unitsInStore) {
		this.unitsInStore = unitsInStore;
	}

}

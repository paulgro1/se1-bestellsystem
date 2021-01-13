package datamodel;

public class Article {

	private String id;
	private String description;
	private long unitPrice;
	private int unitsInStore;

	protected Article(String id, String description, long unitPrice, int unitsInStore) {

		setDescription(description);

		setUnitPrice(unitPrice);

		setUnitsInStore(unitsInStore);

		this.id = id;

	}

	// Getter & Setter

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null || description.equals("")) {
			this.description = "";
		} else {
			this.description = description;
		}
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		if (unitPrice <= 0 || unitPrice == Long.MAX_VALUE || unitPrice == Long.MIN_VALUE) {
			this.unitPrice = 0;
		} else {
			this.unitPrice = unitPrice;
		}
	}

	public int getUnitsInStore() {
		return unitsInStore;
	}

	public void setUnitsInStore(int unitsInStore) {
		if (unitsInStore <= 0 || unitsInStore == Integer.MAX_VALUE || unitsInStore == Integer.MIN_VALUE) {
			this.unitsInStore = 0;
		} else {
		this.unitsInStore = unitsInStore;
		}
	}

}

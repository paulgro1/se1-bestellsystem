package datamodel;

public class OrderItem {

	private String description;
	private final Article article;
	private int unitsOrdered;

	protected OrderItem(String description, Article article, int unitsOrdered) {
		setDescription(description);
		this.article = article;
		setUnitsOrdered(unitsOrdered);
	}

	// Getter & Setter Methoden

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

	public int getUnitsOrdered() {
		return unitsOrdered;
	}

	public void setUnitsOrdered(int unitsOrdered) {
		if(unitsOrdered < 0) {
			this.unitsOrdered = 0;
		} else {
		this.unitsOrdered = unitsOrdered;
		}
	}

	public Article getArticle() {
		return article;
	}

}

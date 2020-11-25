package datamodel;

public class OrderItem {

	protected String description;
	protected final Article article;
	protected int unitsOrdered;

	protected OrderItem(String description, Article article, int unitsOrdered) {
		this.description = description;
		this.article = article;
		this.unitsOrdered = unitsOrdered;
	}

	// Getter & Setter Methoden

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitsOrdered() {
		return unitsOrdered;
	}

	public void setUnitsOrdered(int unitsOrdered) {
		this.unitsOrdered = unitsOrdered;
	}

	public Article getArticle() {
		return article;
	}

}

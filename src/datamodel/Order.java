package datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private final long id;
	private final Date date;
	private final Customer customer;
	private final List<OrderItem> items = new ArrayList<OrderItem>();

	protected Order(long id, Date date, Customer customer) {
		this.id = id;
		this.date = date;
		this.customer = customer;
	}

	// Methoden

	public int count() {
		int count = 0;
		count++;
		return count;
	}

	public Order addItem(OrderItem item) {
		this.items.add(item);
		return this;
	}

	public Order removeItem(OrderItem item) {
		this.items.remove(item);
		return this;
	}

	public Order clearItems() {
		this.items.clear();
		return this;
	}

	// Getter-Methoden

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Iterable<OrderItem> getItems() {
		return items;
	}

}

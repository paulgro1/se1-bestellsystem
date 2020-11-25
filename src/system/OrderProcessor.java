package system;

import datamodel.Article;
import datamodel.Order;
import datamodel.OrderItem;

import java.util.Optional;
import java.util.function.Consumer;

final class OrderProcessor implements Components.OrderProcessor, Components.InventoryManager {

	private final InventoryManager inventoryManager;

	public OrderProcessor(InventoryManager inventoryManager) {
		this.inventoryManager = new InventoryManager();
	}

	@Override
	public boolean accept(Order order) {
		return false;
	}

	@Override
	public boolean accept(Order order, Consumer<Order> acceptCode, Consumer<Order> rejectCode,
			Consumer<OrderItem> rejectedOrderItemCode) {
		return false;
	}

	@Override
	public long orderValue(Order order) {
		return 0;
	}

	@Override
	public long vat(long grossValue) {
		return 0;
	}

	@Override
	public long vat(long grossValue, int rateIndex) {
		return 0;
	}

	@Override
	public boolean containsArticle(String id) {
		return false;
	}

	@Override
	public Iterable<Article> getInventory() {
		return null;
	}

	@Override
	public Optional<Article> get(String id) {
		return Optional.empty();
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public Components.InventoryManager add(Article article) {
		return null;
	}

	@Override
	public Components.InventoryManager remove(Article article) {
		return null;
	}

	@Override
	public void clear() {

	}
}

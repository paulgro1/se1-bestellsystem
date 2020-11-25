package system;

import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

/*
 * Non‐public implementation class.
 */
final class OutputProcessor implements Components.OutputProcessor {

	private final OrderProcessor orderProcessor;
	private final InventoryManager inventoryManager;
	private final int printLineWidth = 95;

	public OutputProcessor(InventoryManager inventoryManager, OrderProcessor orderProcessor) {
		this.inventoryManager = new InventoryManager();
		this.orderProcessor = new OrderProcessor(inventoryManager);
	}

	public OutputProcessor() {
		inventoryManager = null;
		orderProcessor = null;
	}

	@Override
	public void printOrders(List<Order> orders, boolean printVAT) {
		StringBuffer sbAllOrders = new StringBuffer("-------------");
		StringBuffer sbLineItem = new StringBuffer();

		long sum = 0;
		for (Order order : orders) {

			long orderSum = 0;
			String orderedItems = "";

			for (OrderItem oi : order.getItems()) {

				orderSum += oi.getArticle().getUnitPrice() * oi.getUnitsOrdered();
				int x = oi.getUnitsOrdered();
				orderedItems += ", " + x + "x " + oi.getDescription();
				orderedItems = orderedItems.replaceAll("^,", "");
			}

			Customer customer = order.getCustomer();
			String customerName = splitName(customer, customer.getFirstName() + " " + customer.getLastName());

			sum += orderSum;
			sbLineItem = fmtLine("#" + order.getId() + ", " + customerName + "'s Bestellung:" + orderedItems,
					fmtPrice(orderSum, "EUR", 14), printLineWidth);
			sbAllOrders.append("\n");
			sbAllOrders.append(sbLineItem);
		}

		String fmtPriceTotal = pad(fmtPrice(sum, "", " EUR"), 14, true);

		sbAllOrders.append("\n").append(fmtLine("-------------", "-------------", printLineWidth)).append("\n")
				.append(fmtLine("Gesamtwert aller Bestellungen:", fmtPriceTotal, printLineWidth));

		System.out.println(sbAllOrders.toString());
	}

	@Override
	public void printInventory() {

	}

	@Override
	public String fmtPrice(long price, String currency) {
		String fmtPrice = pad(fmtPrice(price, "", " " + currency), 14, true);
		return fmtPrice;
	}

	@Override
	public String fmtPrice(long price, String currency, int width) {
		String fmtPrice = pad(fmtPrice(price, "", " " + currency), 14, true);
		return fmtPrice;
	}

	public String fmtPrice(long price, String prefix, String postfix) {
		StringBuffer fmtPriceSB = new StringBuffer();
		if (prefix != null) {
			fmtPriceSB.append(prefix);
		}

		fmtPriceSB = fmtPrice(fmtPriceSB, price);

		if (postfix != null) {
			fmtPriceSB.append(postfix);
		}
		return fmtPriceSB.toString();
	}

	public StringBuffer fmtPrice(StringBuffer sb, long price) {
		if (sb == null) {
			sb = new StringBuffer();
		}
		double dblPrice = ((double) price) / 100.0; // convert cent to Euro
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("de"))); // rounds double
																										// to 2 digits

		String fmtPrice = df.format(dblPrice); // convert result to String in DecimalFormat
		sb.append(fmtPrice);
		return sb;
	}

	public String pad(String str, int width, boolean rightAligned) {
		String fmtter = (rightAligned ? "%" : "%-") + width + "s";
		String padded = String.format(fmtter, str);
		return padded;
	}

	@Override
	public StringBuffer fmtLine(String leftStr, String rightStr, int totalWidth) {
		StringBuffer sb = new StringBuffer(leftStr);
		int shiftable = 0; // leading spaces before first digit
		for (int i = 1; rightStr.charAt(i) == ' ' && i < rightStr.length(); i++) {
			shiftable++;
		}
		final int tab1 = totalWidth - rightStr.length() + 1; // - ( seperator? 3 : 0 );
		int sbLen = sb.length();
		int excess = sbLen - tab1 + 1;
		int shift2 = excess - Math.max(0, excess - shiftable);
		if (shift2 > 0) {
			rightStr = rightStr.substring(shift2, rightStr.length());
			excess -= shift2;
		}
		if (excess > 0) {
			switch (excess) {
			case 1:
				sb.delete(sbLen - excess, sbLen);
				break;
			case 2:
				sb.delete(sbLen - excess - 2, sbLen);
				sb.append("..");
				break;
			default:
				sb.delete(sbLen - excess - 3, sbLen);
				sb.append("...");
				break;
			}
		}
		String strLineItem = String.format("%-" + (tab1 - 1) + "s%s", sb.toString(), rightStr);
		sb.setLength(0);
		sb.append(strLineItem);
		return sb;
	}

	@Override
	public String splitName(Customer customer, String name) {

		String[] split = name.split(" ");

		if (split[0].contains(",")) {
			customer.setLastName(split[0].replace(",", ""));
			customer.setFirstName(split[1]);

		} else if (split.length != 3) {

			customer.setFirstName(split[0]);
			customer.setLastName(split[1]);

		} else {
			customer.setFirstName(split[0] + " " + split[1].trim());
			customer.setLastName(split[2]);
		}
		return singleName(customer);

	}

	@Override
	public String singleName(Customer customer) {
		String singleName = (customer.getLastName() + ", " + customer.getFirstName());
		return singleName;

	}

}
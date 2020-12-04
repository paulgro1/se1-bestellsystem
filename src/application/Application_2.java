package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;
import system.ComponentFactory;
import system.Components;

public class Application_2 {

	public static void main(String[] args) {

		System.out.println("SE1‐Bestellsystem");

		ComponentFactory componentFactory = ComponentFactory.getInstance();

		Components.OutputProcessor outputProcessor =

				componentFactory.getOutputProcessor();

		Components.DataFactory dataFactory = componentFactory.getDataFactory();

		Components.OrderProcessor orderProcessor =

				componentFactory.getOrderProcessor();
		/*
		 * Erzeugung der Kunden, Artikel und Bestellungen aus Application_1.java
		 */

		Application_2 application = new Application_2();

		Customer cEric = dataFactory.createCustomer("Eric Schulz-Mueller", "eric2346@gmail.com");
		Customer cAnne = dataFactory.createCustomer("Meyer, Anne", "+4917223524");
		Customer cNadine = dataFactory.createCustomer("Nadine Ulla Blumenfeld", "+4915292454");
		Customer cTimo = dataFactory.createCustomer("Timo Werner", "tw@gmail.com");
		Customer cSandra = dataFactory.createCustomer("Sandra Müller", "samue62@gmx.de");

		Article aKaffeemaschine = dataFactory.createArticle("Kaffeemaschine", 2999, 500);
		Article aTeekocher = dataFactory.createArticle("Teekocher", 1999, 2000);
		Article aTasse = dataFactory.createArticle("Tasse", 299, 2000);
		Article aBecher = dataFactory.createArticle("Becher", 149, 8400);
		Article aKanne = dataFactory.createArticle("Kanne", 2000, 2400);
		Article aTeller = dataFactory.createArticle("Teller", 649, 7000);

		// Eric's order
		Order o5234 = dataFactory.createOrder(cEric);
		OrderItem oi1 = dataFactory.createOrderItem(aKanne.getDescription(), aKanne, 1);
		o5234.addItem(oi1);

		// Eric's 2nd order
		Order o8592 = dataFactory.createOrder(cEric);
		OrderItem oi2 = dataFactory.createOrderItem(aTeller.getDescription(), aTeller, 4);
		OrderItem oi3 = dataFactory.createOrderItem(aBecher.getDescription(), aBecher, 8);
		OrderItem oi4 = dataFactory.createOrderItem("passende Tassen", aTasse, 4);
		o8592.addItem(oi2);
		o8592.addItem(oi3);
		o8592.addItem(oi4);

		// Anne's order
		Order o3563 = dataFactory.createOrder(cAnne);
		OrderItem oi5 = dataFactory.createOrderItem(aKanne.getDescription() + " aus Porzellan", aKanne, 1);
		o3563.addItem(oi5);

		// Nadine's order
		Order o6135 = dataFactory.createOrder(cNadine);
		OrderItem oi6 = dataFactory.createOrderItem(aTeller.getDescription() + " blau/weiss Keramik", aTeller, 12);
		o6135.addItem(oi6);

		// Timo's order
		Order o4566 = dataFactory.createOrder(cTimo);
		OrderItem oi7 = dataFactory.createOrderItem(aKaffeemaschine.getDescription(), aKaffeemaschine, 1);
		OrderItem oi8 = dataFactory.createOrderItem(aTasse.getDescription(), aTasse, 6);
		o4566.addItem(oi7);
		o4566.addItem(oi8);

		// Sandra's order
		Order o6753 = dataFactory.createOrder(cSandra);
		OrderItem oi9 = dataFactory.createOrderItem(aTeekocher.getDescription(), aTeekocher, 1);
		OrderItem oi10 = dataFactory.createOrderItem(aBecher.getDescription(), aBecher, 4);
		OrderItem oi11 = dataFactory.createOrderItem(aTeller.getDescription(), aTeller, 4);
		o6753.addItem(oi9);
		o6753.addItem(oi10);
		o6753.addItem(oi11);

		List<Order> orders = new ArrayList<Order>(List.of(o5234, o8592, o3563, o6135, o4566, o6753));

		outputProcessor.printOrders(orders, true); // Ausgabe aller Bestellungen
	}

}

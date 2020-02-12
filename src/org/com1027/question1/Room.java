package org.com1027.question1;

public class Room {
  // field cannot change value once the object is created
  private final double price;

  public Room(double price) {
	super();
	this.price = price;
  }

  public double getPrice() {
	return this.price;
  }
}
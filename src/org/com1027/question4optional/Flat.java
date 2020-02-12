package org.com1027.question4optional;

import java.text.DecimalFormat;

public class Flat extends Property {

  private int floor = 0;

  public Flat(int number, String street, String city, String postCode, int numberOfRooms, int floor)
	  throws IllegalArgumentException {
	super(number, street, city, postCode, numberOfRooms);
	this.floor = floor;
  }

  @Override
  public String displayOccupiedProperty() {
	DecimalFormat df = new DecimalFormat("#.00");
	StringBuilder builder = new StringBuilder();
	double total_price = 0.0;

	builder.append(this.toString()).append("\n");

	for (Room room : this.rooms.keySet()) {
	  builder.append("\tRoom: ").append(room.getPrice()).append("\n");
	  total_price += room.getPrice();
	}
	total_price = (total_price * 12) + 500;
	// .replace used as commas and dots are swapped in italian locale
	builder.append("\tTotal: £").append(df.format(total_price).replace(",", "."));

	return builder.toString();
  }

  @Override
  public boolean isAvailable() {
	return (this.getAvailableRooms() != 0);
  }

  @Override
  public void occupyRoom(Room room, ITenant tenant) throws IllegalArgumentException, NullPointerException {
	if (room.getPrice() < 0) {
	  throw new IllegalArgumentException("Room price cannot be negative");
	}
	if (room == null || tenant == null) {
	  throw new NullPointerException("Classes are not set");
	}
	if (this.isAvailable() == true) {
	  this.rooms.put(room, tenant);
	}
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();

	builder.append(super.toString()).append(" flat on ").append(this.floor).append(" floor :")
		.append(this.getAvailableRooms()).append(" available)");

	return builder.toString();
  }
}
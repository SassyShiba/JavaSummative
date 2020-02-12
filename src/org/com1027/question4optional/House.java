package org.com1027.question4optional;

import java.text.DecimalFormat;

public class House extends Property {

  public House(int number, String street, String city, String postCode, int numberOfRooms)
	  throws IllegalArgumentException {
	super(number, street, city, postCode, numberOfRooms);
  }

  @Override
  public String displayOccupiedProperty() {
	StringBuilder builder = new StringBuilder();
	DecimalFormat df = new DecimalFormat("#.00");
	double total_price = 0.0;

	builder.append(this.toString()).append("\n");
	
	for (Room room : this.rooms.keySet()) {
	  builder.append("\tRoom: ").append(room.getPrice()).append("\n");
	  total_price += room.getPrice();
	}
	// .replace used as commas and dots are swapped in italian locale
	builder.append("\tTotal: £").append(df.format(total_price*12).replace(",", "."));

	return builder.toString();
  }


  @Override
  public boolean isAvailable() {
	return (this.getAvailableRooms() != 0);
  }

  @Override
  public void occupyRoom(Room room, ITenant tenant) {
	if (this.isAvailable() == true) {
	  this.rooms.put(room, tenant);
	}
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(super.toString()).append(" house :").append(this.getAvailableRooms()).append(" available)");
	
	return builder.toString();
  }
}
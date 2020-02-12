package org.com1027.question4optional;

import java.util.HashMap;
import java.util.Map;

public abstract class Property {

  private int number = 0;
  private String street = null;
  private String city = null;
  private String postCode = null;
  private int numberOfRooms = 0;
  protected Map<Room, ITenant> rooms;

  public Property(int number, String street, String city, String postCode, int numberOfRooms)
	  throws IllegalArgumentException {
	super();
	if (validateCity(city)) {
	  throw new IllegalArgumentException("City name must start with a capital letter and can only contain letters");
	}
	if (validatePostCode(postCode)) {
	  throw new IllegalArgumentException("Invalid UK Postcode format");
	}
	this.rooms = new HashMap<Room, ITenant>();
	this.number = number;
	this.street = street;
	this.city = city;
	this.postCode = postCode;
	this.numberOfRooms = numberOfRooms;
  }

  public abstract String displayOccupiedProperty();
  public abstract boolean isAvailable();
  public abstract void occupyRoom(Room room, ITenant tenant);

  public int getAvailableRooms() {
	int availableRooms = this.numberOfRooms;
	if (this.rooms.size() != 0) {
	  availableRooms -= this.rooms.size();
	}
	return availableRooms;
  }

  public double getPrice() {
	double propertyPrice = 0;
	if (this.rooms.size() != 0) {
	  for (Room key : this.rooms.keySet()) {
		propertyPrice += key.getPrice();
	  }
	}
	return propertyPrice;
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();

	builder.append(this.number).append(" ").append(this.street).append(", ").append(this.city).append(" ")
		.append(this.postCode).append(" (").append(this.numberOfRooms).append(" bedroom");

	return builder.toString();
  }

  // Regex allows for city names such as Stoke-on-Trent to be valid
  private boolean validateCity(String city) {
	return !city.matches("[A-Z][a-zA-Z]+(\\s?[a-zA-Z-]+)*");
  }

  // Regex accepts only the 6 UK postcodes formats
  private boolean validatePostCode(String postCode) {
	return !postCode.matches("[A-Z]{1,2}\\d{1,2}([A-Z])?\\s\\d{1}[A-Z]{2}");
  }
}
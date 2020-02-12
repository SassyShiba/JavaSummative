package org.com1027.question1;

import java.util.HashMap;
import java.util.Map;

public class House {

  private int houseNumber = 0;
  private String street = null;
  private String city = null;
  private String postCode = null;
  private int numberOfRooms = 0;
  private Map<Room, ITenant> rooms = null;

  public House(int houseNumber, String street, String city, String postCode, int numberOfRooms)
	  throws IllegalArgumentException {
	super();
	if (validateCity(city)) {
	  throw new IllegalArgumentException("City name must start with a capital letter and can only contain letters");
	}
	if (validatePostCode(postCode)) {
	  throw new IllegalArgumentException("Invalid UK Postcode format");
	}
	this.rooms =  new HashMap<Room, ITenant>();
	this.houseNumber = houseNumber;
	this.street = street;
	this.city = city;
	this.postCode = postCode;
	this.numberOfRooms = numberOfRooms;
  }

  public int getAvailableRooms() {
	int availableRooms = this.numberOfRooms;
	if (this.rooms.size() != 0) {
	  availableRooms -= this.rooms.size();
	}
	return availableRooms;
  }

  public double getPrice() {
	double propertyPrice = 0.0;
	if (this.rooms.size() != 0) {
	  for (Room key : this.rooms.keySet()) {
		propertyPrice += key.getPrice();
	  }
	}
	return propertyPrice;
  }

  public boolean isAvailable() {
	return (this.getAvailableRooms() != 0);
  }

  public void occupyRoom(Room room, ITenant tenant) {
	if (this.isAvailable() == true) {
	  this.rooms.put(room, tenant);
	}
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();

	builder.append(this.houseNumber).append(" ").append(this.street).append(", ").append(this.city).append(" ")
		.append(this.postCode).append(" (").append(this.numberOfRooms).append(" bedroom house :")
		.append(this.getAvailableRooms()).append(" available)");

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
package org.com1027.question2;

public class Agency {

  private String name = null;
  private String phoneNumber = null;

  public Agency(String name, String phoneNumber) throws IllegalArgumentException {
	super();
	// Regex allows for names such as Anne Marie or Anne-Marie to be valid
	if (!name.matches("[A-Z][a-zA-Z]+(\\s?[a-zA-Z-]+)*")) {
	  throw new IllegalArgumentException("Name needs to start with a capital letter and only contain letters");
	}
	if (!phoneNumber.matches("\\d{5}\\s\\d{6}")) {
	  throw new IllegalArgumentException("Phone Number needs to be in format: 01234 567890");
	}
	this.name = name;
	this.phoneNumber = phoneNumber;
  }

  public String getName() {
	return this.name;
  }

  public String getPhoneNumber() {
	return this.phoneNumber;
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();

	builder.append("Agency: ").append(this.name).append(", Phone Number: ").append(this.phoneNumber);

	return builder.toString();
  }
}
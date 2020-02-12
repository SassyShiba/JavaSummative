package org.com1027.question3;

public class Tenant implements ITenant {

  private String name = null;
  private String surname = null;
  private int age = 0;
  private TenantType type = null;

  public Tenant(String name, String surname, int age, TenantType type) {
	super();
	this.name = name;
	this.surname = surname;
	this.age = age;
	this.type = type;
  }

  public int getAge() {
	return this.age;
  }

  @Override
  public TenantType getType() {
	return this.type;
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();

	builder.append(this.name).append(" ").append(this.surname);

	return builder.toString();
  }
}
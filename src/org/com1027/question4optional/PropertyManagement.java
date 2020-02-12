/**
 * PropertyManagement.java
 */

package org.com1027.question4optional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents all the properties for a particular lettings agency .
 */
public class PropertyManagement {

  /** The lettings agency. */
  private Agency estateAgency = null;
  /** List of all the properties owned by the agency. */
  private List<Property> properties;

  /**
   * Constructor for class allowing the estate agency to be set
   *
   * @param estateAgency managing properties
   */
  public PropertyManagement(Agency estateAgency) {
	super();
	this.properties = new ArrayList<Property>();
	this.estateAgency = estateAgency;
  }

  /**
   * Adds an object house to the list properties.
   * 
   * @param property to add
   */
  public void addProperty(Property property) {
	this.properties.add(property);
  }

  /**
   * Sets a room to be occupied by a specified tenant.
   * 
   * @param property the tenant will be living in
   * @param room the tenant will be staying at
   * @param tenant to add
   */
  public void addTenant(Property property, Room room, Tenant tenant) {
	property.occupyRoom(room, tenant);
  }

  /**
   * Returns a string with the properties of the list contents.
   * 
   * @return toString method of StringBuilder object builder
   */
  public String displayProperties() {
	StringBuilder builder = new StringBuilder();

	for (Property property : this.properties) {
	  builder.append(property.isAvailable() ? property.toString() : property.displayOccupiedProperty());
	  builder.append("\n");
	}
	return builder.toString();
  }

  /**
   * @return the estate agency as a string.
   */
  public String getEstateAgency() {
	return this.estateAgency.toString();
  }

  /**
   * Removes a specified property object from the list properties.
   * 
   * @param property to remove
   * @throws IllegalArgumentException if given object is not in list property.
   */
  public void removeProperty(Property property) throws IllegalArgumentException {
	if (!this.properties.contains(property)) {
	  throw new IllegalArgumentException("Specified object is not in the list and therefore cannot be removed");
	}
	this.properties.remove(property);
  }

  public String displayInfoGraphics() {
	// dictionary values
	class Data {
	  public double total = 0.0;
	  public int professionals = 0;
	  public int students = 0;
	}
	// dictionary keys
	String[] demographics = new String[] { "0-16", "17-25", "26-35", "36-49", "50-60", "60+" };
	Map<String, Data> statistics = new HashMap<>();

	// setup dictionary with empty values
	for (String key : demographics) {
	  statistics.put(key, new Data());
	}

	for (Property property : this.properties) {
	  for (ITenant itenant : property.rooms.values()) {
		Tenant tenant = (Tenant) itenant;
		String key = "60+";
		int age = tenant.getAge();

		if (age < 17) {
		  key = "0-16";
		} else if (age < 26) {
		  key = "17-25";
		} else if (age < 36) {
		  key = "26-35";
		} else if (age < 50) {
		  key = "36-49";
		} else if (age < 60) {
		  key = "50-60";
		}

		// assigning dictionary values
		Data data = statistics.get(key);
		data.total++;
		if (tenant.getType() == TenantType.PROFESSIONAL) {
		  data.professionals++;
		} else {
		  data.students++;
		}
		statistics.put(key, data);
	  }
	}

	StringBuilder builder = new StringBuilder("Age\tTotal\tProfessionals\tStudents\n");

	for (String key : demographics) {
	  Data data = statistics.get(key);
	  builder.append(key).append("\t");

	  DecimalFormat df = new DecimalFormat("#.#");
	  Double professionals_percents = data.professionals / data.total * 100;
	  Double students_percents = data.students / data.total * 100;

	  for (int i = 0; i < data.total; i++) {
		builder.append("*");
	  }

	  builder.append("\t")
		  .append(professionals_percents.isNaN() ? 0 : df.format(professionals_percents).replace(",", "."))
		  .append("%");
	  
	  builder.append("\t\t")
	  	  .append(students_percents.isNaN() ? 0 : df.format(students_percents).replace(",", "."))
		  .append("%").append("\n");
	}
	return builder.toString();
  }
}
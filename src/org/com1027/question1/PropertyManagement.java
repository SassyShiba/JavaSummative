/**
 * PropertyManagement.java
 */

package org.com1027.question1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents all the properties for a particular lettings agency .
 */
public class PropertyManagement {

  /** The lettings agency. */
  private Agency estateAgency = null;
  /** List of all the properties owned by the agency. */
  private List<House> properties = null;

  /**
   * Constructor for class allowing the estate agency to be set
   *
   * @param estateAgency managing properties
   */
  public PropertyManagement(Agency estateAgency) {
	super();
	this.properties = new ArrayList<House>();
	this.estateAgency = estateAgency;
  }

  /**
   * Adds an object house to the list properties.
   * 
   * @param property to add
   */
  public void addProperty(House property) {
	this.properties.add(property);
  }

  /**
   * Sets a room to be occupied by a specified tenant.
   * 
   * @param property the tenant will be living in
   * @param room     the tenant will be staying at
   * @param tenant   to add
   */
  public void addTenant(House property, Room room, Tenant tenant) {
	property.occupyRoom(room, tenant);
  }

  /**
   * Returns a string with the properties of the list contents.
   * 
   * @return toString method of StringBuilder object builder
   */
  public String displayProperties() {
	StringBuilder builder = new StringBuilder();

	for (House property : this.properties) {
	  builder.append(property).append("\n");
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
  public void removeProperty(House property) throws IllegalArgumentException {
	if (!this.properties.contains(property)) {
	  throw new IllegalArgumentException("Specified object is not in the list and therefore cannot be removed");
	}
	this.properties.remove(property);
  }
}
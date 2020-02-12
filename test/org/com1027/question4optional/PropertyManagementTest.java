package org.com1027.question4optional;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class PropertyManagementTest {

	@Test
	public void testAddProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);
		Property house = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);

		pm.addProperty(house);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :2 available)\n", pm.displayProperties());

	}

	@Test
	public void testAddTenant() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);
		Room room2 = new Room(1000);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Stella", "Kazamia", 50, TenantType.PROFESSIONAL);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);

		assertEquals(
				"1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n"
						+ "1 The Chase, Guildford GU2 7UB (5 bedroom house :5 available)\n" + "",
				pm.displayProperties());
	}

	@Test
	public void testDisplayHouses() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);
		Room room2 = new Room(1000);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Stella", "Kazamia", 50, TenantType.PROFESSIONAL);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);
		pm.addTenant(house2, room2, tenant2);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n"
				+ "1 The Chase, Guildford GU2 7UB (5 bedroom house :4 available)\n", pm.displayProperties());
	}

	@Test
	public void testGetEstateAgency() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		assertEquals("Agency: Simple Lettings, Phone Number: 01234 567890", pm.getEstateAgency());
	}

	
	@Test
	public void testPropertyManagement() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		assertEquals("", pm.displayProperties());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveInvalidProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);

		pm.removeProperty(house1);
	}

	@Test
	public void testRemoveProperty() {
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);

		Property house1 = new House(1, "Percy Road", "Guildford", "GU2 7XH", 2);
		Property house2 = new House(1, "The Chase", "Guildford", "GU2 7UB", 5);

		Room room1 = new Room(900);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);

		pm.addProperty(house1);
		pm.addProperty(house2);

		pm.addTenant(house1, room1, tenant1);

		pm.removeProperty(house2);

		assertEquals("1 Percy Road, Guildford GU2 7XH (2 bedroom house :1 available)\n", pm.displayProperties());
	}


	/**
	 * testInfographic
	 * 
	 * 1. Create a new estate agency 
	 * 2. Create a property management object 
	 * 3. Create new different properties (2 houses, 3 flats) that: 
	 * a. All of them are of single occupancy 
	 * 4. Assign only students in the two houses (of ages 18 and 26 respectively) 
	 * 5. Assign only professionals in the three flats (of ages 27, 35 and 50
	 * respectively) 
	 * 6. Check that all properties are occupied 
	 * 7. Test whether the infographics returned match the expected output
	 * 
	 * Note: Infographics can be in the form of a histogram, summary of percentages
	 * for each age group, etc. You can also store the information to a file and 
	 * retrieve them. The purpose for this question is to give you some freedom in
	 * experimenting with advanced OOP concepts.
	 */
	
	@Test
	public void testDisplayInfoGraphics(){
		Agency estate = new Agency("Simple Lettings", "01234 567890");
		PropertyManagement pm = new PropertyManagement(estate);
		
		Property house1 = new House(1, "Percy Road", "Guildford", "AA9A 9AA", 1);
		Property house2 = new House(1, "The Chase", "Guildford", "A9A 9AA", 1);
	
		Property flat1 = new Flat(1, "Cappuccino Road", "Guildford", "A9 9AA", 1, 1);
		Property flat2 = new Flat(1, "Latte Road", "Not Guildford", "A99 9AA", 1, 1);
		Property flat3 = new Flat(1, "Mocha Road", "Stoke-on-Trent", "AA99 9AA", 1, 1);

		Room room = new Room(900);

		Tenant tenant1 = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
		Tenant tenant2 = new Tenant("Stella", "Kazamia", 27, TenantType.PROFESSIONAL);
		Tenant tenant3 = new Tenant("Not Alice", "Wonderland", 26, TenantType.STUDENT);
		Tenant tenant4 = new Tenant("Not Stella", "Kazamia", 35, TenantType.PROFESSIONAL);
		Tenant tenant5 = new Tenant("Totally not Alice", "Wonderland", 50, TenantType.PROFESSIONAL);
		

		pm.addProperty(house1);
		pm.addProperty(house2);
		pm.addProperty(flat1);
		pm.addProperty(flat2);
		pm.addProperty(flat3);
	
		pm.addTenant(house1, room, tenant1);
		pm.addTenant(house2, room, tenant3);
		pm.addTenant(flat1, room, tenant2);
		pm.addTenant(flat2, room, tenant4);
		pm.addTenant(flat3, room, tenant5);
		
		assertEquals(false, house1.isAvailable());
		assertEquals(false, house2.isAvailable());
		assertEquals(false, flat1.isAvailable());
		assertEquals(false, flat2.isAvailable());
		assertEquals(false, flat3.isAvailable());
		
		assertEquals("Age\tTotal\tProfessionals\tStudents\n" + 
			"0-16\t\t0%\t\t0%\n" + 
			"17-25\t*\t0%\t\t100%\n" + 
			"26-35\t***\t66.7%\t\t33.3%\n" + 
			"36-49\t\t0%\t\t0%\n" + 
			"50-60\t*\t100%\t\t0%\n" + 
			"60+\t\t0%\t\t0%\n", pm.displayInfoGraphics());
	}
}

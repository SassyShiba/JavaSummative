package org.com1027.question1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TenantTest {
  
  private Tenant tenant;

  @Before public void setUp() {
	this.tenant = new Tenant("Alice", "Wonderland", 18, TenantType.STUDENT);
  }
  
  @After public void tearDown() {
	this.tenant = null;
  }
  
  @Test
  public void testGetAge() {
	assertEquals(18, tenant.getAge());
  }

  @Test
  public void testGetType() {
	assertEquals(TenantType.STUDENT, tenant.getType());
  }
  
  @Test
  public void testToString() {
	assertEquals("Alice Wonderland", tenant.toString());
  }
}

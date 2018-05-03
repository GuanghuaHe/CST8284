package test.cst8284.calculator;
import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplex {

	/*1. Use assertNotNull() to test the Complex() i.e.
	 *  the no-arg constructor (1 mark)
	 */
	@Test
	public void testNoArg() {
		Complex c1 = new Complex();
		assertNotNull(c1);
		
	}
	
	
	
	/*2.  Use assertEquals(double, double, double) to test 
	 * if getReal() returns the correct value set 
	 * using the Complex(String[]) constructor (1 mark)
	 */
	@Test
	public void testGetReal() {
		//String[] s = {"-4", "3"};
		//Complex c2 = new Complex(s);
		//System.out.println(c2.getReal());
		//assertEquals(-4, c2.getReal(), 0.000001);
		
		String s [] ={"-4","3i"}; 
		Complex c2 = new Complex(s);
		assertEquals(c2.getReal(), -4.0, 0.000001);
		
	}
	
	
	/*3. Use assertEquals(double, double, double) to test 
	 * if setReal() correctly resets the value set 
	 * using the Complex(String, String) constructor (1 mark)
	 */
	@Test
	public void testSetReal() {
		Complex c3 = new Complex("3", "-2i");
		c3.setReal(-1.8);
		assertEquals(c3.getReal(),-1.8, 0.000001);
		
	}
	
	
	/*
	 *   4. Use the no-arg Complex() constructor, and then 
	 *   use the real and imaginary setters to set new integer values.  
	 *   Then use assertTrue(boolean) to test the validity 
	 *   of your newly-added equals(String) method (1 mark)
	 */
	
	@Test
	public void testEqualsString() {
		Complex c4 = new Complex();
		c4.setReal(-5);
		c4.setImag(-6);
		assertTrue(c4.equals("-5-6"));
		
	}
	

	

}

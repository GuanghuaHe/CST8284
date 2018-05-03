package test.cst8284.calculator;
import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplexCalculator {

	@Test
	public void testToString() {
		Complex c = new Complex(3, 2);
		//System.out.println(c.toString());
		assertTrue(c.toString()
				.equals("3.0 + 2.0i"));
		//fail("Not yet implemented");
	}

	
	/*	 5. Using assertTrue(boolean), 
	 *   test that two Complex numbers created using the Complex(double, double) constructor 
	 *   and the Complex(String) constructor give the correct result using the divide() method.  
	 *   Use equals(Complex) to compare the actual and expected result (1 mark)
	 */
	@Test
	public void testEqualsComplex() {
		Complex c5 = new Complex(-2, 5);
		Complex c6 = new Complex("-2+5i");
		ComplexCalculator calculator = new ComplexCalculator();
		Complex c7 = calculator.divide(c5, c6);
		assertTrue(c7.equals("1.0+0.0"));
		
	}
	
	
	
	

	/*
	 *  6. Using one or more for() loops over a range of values, 
	 *  check that (A + Bi)*(A - Bi) is a pure real number, 
	 *  i.e. that imag = 0 for each possible compbination (3 marks)
	 */

	@Test
	public void testResultString() {
		for(int i=1; i<100; i++){
			Complex c1 = new Complex(i, i-1);			
			ComplexCalculator calculator = new ComplexCalculator();
			Complex c2 = calculator.conjugate(c1);
			double result = i*i + (i-1)*(i-1);
			Complex c3 = calculator.multiply(c1, c2);
			assertEquals(c3.getReal(), result, 0.000001);		
			assertEquals(c3.getImag(), 0, 0.000001);	
		}

	}




}

package test.cst8284.shape;

import static org.junit.Assert.*;

import org.junit.Test;

import cst8284.shape.Circle;
import cst8284.shape.Rectangle;
import cst8284.shape.Square;
import junit.framework.Assert;

public class TestCase {

	@Test
	public void testEqualsObjectSquareToRect() {
		assertTrue(new Square().equals(new Rectangle()));
	}

	@Test
	public void testEqualsObjectSquareToCircle() {
		assertFalse(new Square().equals(new Circle()));
	}
	
	@Test
	public void testEqualsObjectCircleToCircle() {
		
		assertTrue(new Circle().equals(new Circle(new Circle())));
	}
	
}

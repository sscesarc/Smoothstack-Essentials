/**
 * 
 */
package com.ss.jb.twelve;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Cesar Camarena
 *
 */
public class LineTest {
	// 1) Create a file called LineTest.java.
	// 2) Create tests for the getSlope, getDistance, and parallelTo methods.
	// 3) Because of rounding errors, it is bad practice to test double values
	//    for exact equality. To get around this, you can pass a small value 
	//    (such as .0001) to assertEquals to be used as a delta.
	
	@Test
	public void testGetSlope() {
		Line line = new Line(1, 1, 0, 0);
		
		assertEquals("The slope of the line should be 1 here.", 1.0, line.getSlope(), 0.0001);
		assertNotEquals("Test case with incorrect slope.", 0.0, line.getSlope(), 0.0001);
	}
	
	@Test
	public void testGetDistance() {
		Line line = new Line(1, 1, 0, 0);
		
		assertNotEquals("Distance is not 1.414", 1.414, line.getDistance(), 0.0001);
	}
	
	@Test
	public void testParallelTo() {
		Line line = new Line(1, 1, 0, 0);
		Line line2 = new Line(0, 0, 1, 1);
		
		assertTrue("Lines are not parallel", line.parallelTo(line2));
	}
}

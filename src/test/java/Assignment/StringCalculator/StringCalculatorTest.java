package Assignment.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest 
    extends TestCase
{
    StringCalculator calculator = new StringCalculator();
	
	public void testcase1(){
		assertEquals(0, calculator.add(""));
		assertEquals(1, calculator.add("1"));
		assertEquals(5, calculator.add("2,3"));
		assertEquals(6, calculator.add("1,2,3"));
		assertEquals(27, calculator.add("2,3,4,5,6,7"));
		assertEquals(18, calculator.add("2,3,6,7"));
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(10, calculator.add("1\n2,3\n4"));
	}
}

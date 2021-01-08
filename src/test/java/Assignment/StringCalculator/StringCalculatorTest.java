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
		
	}
}

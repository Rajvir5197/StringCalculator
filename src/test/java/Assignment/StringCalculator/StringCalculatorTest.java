package Assignment.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest 
    extends TestCase
{
    StringCalculator calculator = new StringCalculator();
	
	public void testcase1() throws Exception{
		assertEquals(0, calculator.add(""));
		assertEquals(1, calculator.add("1"));
		assertEquals(5, calculator.add("2,3"));
		assertEquals(6, calculator.add("1,2,3"));
		assertEquals(27, calculator.add("2,3,4,5,6,7"));
		assertEquals(18, calculator.add("2,3,6,7"));
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(10, calculator.add("1\n2,3\n4"));
		assertEquals(3, calculator.add("//;\n1;2"));
		assertEquals(3, calculator.add("//*\n1*2"));
		assertEquals(24, calculator.add("//+\n1+23"));
		
		try{
    		calculator.add("//;\n1;-2");
    	}
    	catch(Exception e){
    		assertEquals(true, e.toString().contains("negatives not allowed -2"));
    	}
		
		try{
    		calculator.add("//;\n-11;-2");
    	}
    	catch(Exception e){
    		assertEquals(true, e.toString().contains("negatives not allowed -11 -2"));
    	}	
		assertEquals(1, calculator.add("//+\n1+2004"));
		assertEquals(2, calculator.add("//+\n2025+2"));

		assertEquals(6, calculator.add("//[***]\n1***2***3"));
		assertEquals(6, calculator.add("//[++]\n1++2++3"));
		assertEquals(7, calculator.add("//[;;;;]\n2;;;;2;;;;3"));
		//[***]\n1***2***3
    		
	}
}

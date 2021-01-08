package Assignment.StringCalculator;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public int add(String string) {
		if("".equals(string))
			return 0;
		else{
			String[] numbers = string.split(",");
			if(numbers.length == 1){
				return Integer.parseInt(numbers[0]);
			}else{
				return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
			}
		}
	}
}

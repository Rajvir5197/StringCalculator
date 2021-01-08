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
			int result = 0;
			String[] numbers = string.split(",");
			if(numbers.length == 1){
				result =  Integer.parseInt(numbers[0]);
			}else{
				for(String num : numbers){
					result = result + Integer.parseInt(num);
				}		
			}
			return result;
		}
	}
}

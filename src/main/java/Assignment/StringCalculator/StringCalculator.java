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
        
        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.add("//+\n1+2\n3"));
    }

	public int add(String string) {
		if("".equals(string))
			return 0;
		else{
			int result = 0;
			if(string.startsWith("//")){
				String[] container = string.substring(2).split("\n");
				String delemiter = container[0];
				String numberString = container[1];
				string = numberString.replace("\n", "\\" + delemiter);
				String[] numbers = numberString.split("\\" + delemiter);
				if(numbers.length == 1){
					result =  Integer.parseInt(numbers[0]);
				}else{
					for(String num : numbers){
						result = result + Integer.parseInt(num);
					}		
				}	
			}
			else{
				
				string = string.replace("\n", ",");
				String[] numbers = string.split(",");
				if(numbers.length == 1){
					result =  Integer.parseInt(numbers[0]);
				}else{
					for(String num : numbers){
						result = result + Integer.parseInt(num);
					}		
				}	
			}
			
			return result;
		}
	}
}

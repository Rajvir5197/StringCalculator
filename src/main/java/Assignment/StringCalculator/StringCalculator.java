package Assignment.StringCalculator;

/**
 * Hello world!
 *
 */
public class StringCalculator {
	public static void main(String[] args) {
		System.out.println("Hello World!");

	}

	public int add(String string) throws Exception {
		if ("".equals(string))
			return 0;
		else {
			int result = 0;
			String[] numbers;
			if (string.startsWith("//")) {
				String[] container = string.substring(2).split("\n");
				String delemiter = container[0];
				String numberString = container[1];
				string = numberString.replace("\n", "\\" + delemiter);
				numbers = numberString.split("\\" + delemiter);
			} else {
				string = string.replace("\n", ",");
				numbers = string.split(",");
			}
			
			if (numbers.length == 1) {
				result = Integer.parseInt(numbers[0]);
			} else {
				for (String num : numbers) {
					if(Integer.parseInt(num) < 0){
						throw new Exception("negatives not allowed " + num);
					}
					result = result + Integer.parseInt(num);
				}
			}

			return result;
		}
	}
}

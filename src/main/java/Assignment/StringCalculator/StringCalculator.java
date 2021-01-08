package Assignment.StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringCalculator
 *
 */
public class StringCalculator {
	public static int count = 0;
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		StringCalculator cal = new StringCalculator();
		System.out.println(cal.add("//[*][;]\n1*2;3\n4"));
	}

	public int add(String string) throws Exception {
		count++;
		if ("".equals(string)) // First simple case for blank input
			return 0;
		else {                 // all other functionality BAU
			int result = 0;
			String[] numbers;
			String negativeNumber = "";
			if (string.startsWith("//")) {                               // if custom delimiter passed as argument
				String[] container = string.substring(2).split("\n");
				String delimiter = container[0];
				String numberString = container[1];
				String separator = "\\" + delimiter;
				if (delimiter.startsWith("[")) {                       // if delimiter is of variable length
					separator = "";
					List<String> matchList = new ArrayList<String>();
					Pattern regex = Pattern.compile("\\[(.*?)\\]");
					Matcher regexMatcher = regex.matcher(delimiter);
					
					while (regexMatcher.find()) {
						   matchList.add(regexMatcher.group(1));
						}
					for(String str:matchList) {
						   for(int i =0; i < str.length(); i++){
							   separator = separator+"\\"+str.charAt(0);
						   }
						   separator = separator + "|";
						}
						
						separator = separator.substring(0,separator.length() -1 );
				}                                                       // one delimiter is available with single length without []
					string = numberString.replace("\n", separator);
					numbers = numberString.split(separator);
				
			} else {                                                    // default case for delimiter with ,
				string = string.replace("\n", ",");
				numbers = string.split(",");
			}

			if (numbers.length == 1) {
				result = Integer.parseInt(numbers[0]);                   // one input passed as argument
			} else {
				for (String num : numbers) {
					if (Integer.parseInt(num) < 0) {
						negativeNumber += num + " ";
					}
					if (Integer.parseInt(num) <= 1000) {              // bypass number > 1000
						result = result + Integer.parseInt(num);
					}

				}
			}
			if (!"".equals(negativeNumber)) {
				throw new Exception("negatives not allowed " + negativeNumber);
			}

			return result;
		}
	}

	public int getCalledCount() {
		// TODO Auto-generated method stub
		return count;
	}
}

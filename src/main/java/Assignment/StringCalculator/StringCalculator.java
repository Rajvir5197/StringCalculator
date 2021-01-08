package Assignment.StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class StringCalculator {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		StringCalculator cal = new StringCalculator();
		System.out.println(cal.add("//[*][;]\n1*2;3\n4"));
	}

	public int add(String string) throws Exception {
		if ("".equals(string))
			return 0;
		else {
			int result = 0;
			String[] numbers;
			String negativeNumber = "";
			if (string.startsWith("//")) {
				String[] container = string.substring(2).split("\n");
				String delemiter = container[0];
				String numberString = container[1];
				String separator = "\\" + delemiter;
				if (delemiter.startsWith("[")) {
					separator = "";
					List<String> matchList = new ArrayList<String>();
					Pattern regex = Pattern.compile("\\[(.*?)\\]");
					Matcher regexMatcher = regex.matcher(delemiter);
					
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
				}
					string = numberString.replace("\n", separator);
					numbers = numberString.split(separator);
				
			} else {
				string = string.replace("\n", ",");
				numbers = string.split(",");
			}

			if (numbers.length == 1) {
				result = Integer.parseInt(numbers[0]);
			} else {
				for (String num : numbers) {
					if (Integer.parseInt(num) < 0) {
						negativeNumber += num + " ";
					}
					if (Integer.parseInt(num) <= 1000) {
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
}

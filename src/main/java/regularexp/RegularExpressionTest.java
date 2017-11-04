package regularexp;

import java.util.regex.Pattern;

/**
 * This class is used for test regular expression
 * @date Jan 21, 2015
 */
public class RegularExpressionTest {
	
	public static void main(String[] args) {
		test("^[a-zA-Z]{2}_[a-zA-Z]{2}$", new String[]{"aaa", "zh_CH", "1zh_bb", "zh1_j", "abcde", " zh_ch  ", "zh_11"});
		test("[*|&]", new String[]{"a*aa***bc&&"});
		String replacer = "[*|&]";
		System.out.println("a*aa***bc&&".replaceAll(replacer, ""));
	}

	private static void test(String regex, String[] testStrs) {
		Pattern pattern = Pattern.compile(regex);
		for (String str : testStrs) {
			if (pattern.matcher(str).matches()) {
				System.out.println(str + " is match");
			} else {
				System.out.println(str + " is not match");
			}
				
		}
	}

}

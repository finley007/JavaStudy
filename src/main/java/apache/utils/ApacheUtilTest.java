package apache.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class ApacheUtilTest {

	public static void main(String[] args) {
		testStringUtils();
		testArrayUtils();
	}
	
	private static void testStringUtils() {
		String str = null;
		System.out.println(StringUtils.isEmpty(str));
		str = "";
		System.out.println(StringUtils.isEmpty(str));
		str = "str";
		System.out.println(StringUtils.isEmpty(str));
	}
	
	private static void testArrayUtils() {
		String[] strs = null;
		System.out.println(ArrayUtils.isEmpty(strs));
		strs = new String[]{};
		System.out.println(ArrayUtils.isEmpty(strs));
		strs = new String[]{"str"};
		System.out.println(ArrayUtils.isEmpty(strs));
	}
	
	
}

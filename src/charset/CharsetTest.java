package charset;

import java.io.UnsupportedEncodingException;

public class CharsetTest {
	
	public static void main(String[] args) {
		runTest();
	}
	
	/**
	 * 经过这个测试可以知道String的getBytes方法可以转换字符串的编码方式
	 * 但是new String是不行，必须应用当前的字符集，否则胡乱码
	 */
	private static void runTest(){
		try {
			byte[] utf8 = "你".getBytes("UTF-8");  //会默认使用操作系统平台的字符集，winxp默认是GBK
			System.out.println(bytesToHexString(utf8));
			String str = new String(utf8,"UTF-8");
			System.out.println(str);
			byte[] utf16 = str.getBytes("UTF-16");
			System.out.println(bytesToHexString(utf16));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String bytesToHexString(byte[] bytes){
		StringBuilder stringBuilder = new StringBuilder("");  
		if (bytes != null && bytes.length > 0) {
			for(int i = 0;i< bytes.length;i++){
			    int v = bytes[i] & 0xFF;  
		        String hv = Integer.toHexString(v);  
		        if (hv.length() < 2) {  
		            stringBuilder.append(0);  
		        }  
		        stringBuilder.append(hv);
		        stringBuilder.append("|");
			}
		}
		return stringBuilder.toString();
	}  

}

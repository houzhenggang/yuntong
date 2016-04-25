package com.yuntong.charset;

import java.io.UnsupportedEncodingException;

public class G_CharSet {
	/**
	 * 
	 * @param charsetString 要转换的字符串
	 * @param oldCharset 本来的字符串编码
	 * @param newCharset 要转换的字符串编码
	 * @return
	 */
	public static String charSet(String charsetString,String oldCharset,String newCharset){
		String str=null;
		try {
			str=new String(charsetString.getBytes(oldCharset),newCharset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}

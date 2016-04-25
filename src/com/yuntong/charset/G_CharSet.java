package com.yuntong.charset;

import java.io.UnsupportedEncodingException;

public class G_CharSet {
	/**
	 * 
	 * @param charsetString Ҫת�����ַ���
	 * @param oldCharset �������ַ�������
	 * @param newCharset Ҫת�����ַ�������
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

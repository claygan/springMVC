package com.quest.commons.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description: TODO
 * @author Kolor
 * @date 2012-4-7 下午2:44:01
 */
public class Base64Util {
	/**
	 * @Title: getBASE64
	 * @Description: Base64编码
	 * @author Kolor
	 * @param bytes
	 * @return String
	 */
	@SuppressWarnings("restriction")
	public static String getBASE64(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		return (new sun.misc.BASE64Encoder()).encode(bytes);
	}

	/**
	 * @Title: getBASE64FromFile
	 * @Description: 将指定文件转换为base64编码字符串
	 * @author Kolor
	 * @param fileName
	 * @throws IOException
	 * @return String
	 */
	public static String getBASE64FromFile(String fileName) throws IOException {
		if (fileName == null) {
			return null;
		}

		InputStream input = null;
		try {
			input = new FileInputStream(fileName);
			byte[] bytes = new byte[input.available()];
			input.read(bytes);

			return getBASE64(bytes);
		} catch (IOException e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	/**
	 * 
	 * @Title: getBytesFromBASE64
	 * @Description: 将 BASE64 编码的字符串 s 进行解码
	 * @author Kolor
	 * @param s
	 * @return byte[]
	 */
	@SuppressWarnings("restriction")
	public static byte[] getBytesFromBASE64(String s) {
		if (s == null) {
			return null;
		}
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	public static String convertBase64MaptoString(Map<String, String> map) throws UnsupportedEncodingException {
		//
		if (map == null || map.size() <= 0) {
			return null;
		}
		//
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			String param = key + "=" + value;
			//
			if (num == 0) {
				sb.append(param);
				num++;
			} else {
				sb.append("&");
				sb.append(param);
			}
		}
		//
		String str = sb.toString();
		String keyvalues = new String(Base64.encodeBase64(str.getBytes()));
		//
		return keyvalues;
	}

	/**
	 * 把经过BASE64编码的字符串转换为Map对象
	 * 
	 * @param str
	 *            callback url上top_parameters的值，request.getParameter("top_parameter")方法获得参数已经做了url
	 *            decode。这里需要的就是decode后的参数
	 * @param encode
	 *            callback url上encode的值，如果不存在此参数请传null
	 * @return
	 */
	public static Map<String, String> convertBase64StringtoMap(String str, String encode) {
		if (str == null)
			return null;
		if (encode == null) {
			encode = "GBK";
		}
		String keyvalues = null;
		try {
			keyvalues = new String(Base64.decodeBase64(str.getBytes(encode)), encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] keyvalueArray = keyvalues.split("\\&");
		Map<String, String> map = new HashMap<String, String>();
		for (String keyvalue : keyvalueArray) {
			String[] s = keyvalue.split("\\=");
			if (s == null || s.length != 2)
				return null;
			map.put(s[0], s[1]);
		}
		return map;
	}
	
	public static String encode(String string) {
		if (StringUtils.isBlank(string)) {
			return null;
		}
		try {
			return Base64.encodeBase64URLSafeString(string.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			//
			e.printStackTrace();
		}
		return null;

	}
	//
	public static String decode(String string){
		if (StringUtils.isBlank(string)) {
			return null;
		}
		try {
			byte[] bytes = Base64.decodeBase64(string);
			
			return new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			//
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(encode("301245"));
		//		String content = "userId=50809&courseId=50732";
		//		String base64Str = getBASE64(content.getBytes());
		//		System.out.println("encode to base64 :\n" + base64Str);
		//
		//		System.out.println();
		//
		//		String retStr = new String(getBytesFromBASE64(base64Str));
		//		System.out.println("decode from base64:\n" + retStr);
	}
}

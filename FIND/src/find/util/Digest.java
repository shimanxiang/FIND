package find.util;

import java.security.MessageDigest;

public class Digest {
	/**
	  * �����ַ��SHA����ժҪ����byte[]��ʽ����
	  */
	public static byte[] MdigestSHA(String source) {
	  //byte[] nullreturn = { 0 };
	  try {
	   MessageDigest thisMD = MessageDigest.getInstance("SHA");
	   byte[] digest = thisMD.digest(source.getBytes("UTF8"));
	   return digest;
	  } catch (Exception e) {
	   return null;
	  }
	}

	/**
	  * ����byte[]��SHA����ժҪ����byte[]��ʽ����
	  */
	public static byte[] MdigestSHA(byte[] source) {
	  //byte[] nullreturn = { 0 };
	  try {
	   MessageDigest thisMD = MessageDigest.getInstance("SHA");
	   byte[] digest = thisMD.digest(source);
	   return digest;
	  } catch (Exception e) {
	   return null;
	  }
	}

	/**
	  * �����ַ��MD5����ժҪ����byte[]��ʽ����
	  */
	public static byte[] MdigestMD5(String source) {
	  //byte[] nullreturn = { 0 };
	  try {
	   MessageDigest thisMD = MessageDigest.getInstance("MD5");
	   byte[] digest = thisMD.digest(source.getBytes("UTF8"));
	   return digest;
	  } catch (Exception e) {
	   return null;
	  }
	}

	/**
	  * ����byte[]����MD5��ժҪ����byte[]��ʽ����
	  */
	public static byte[] MdigestMD5(byte[] source) {
	  //byte[] nullreturn = { 0 };
	  try {
	   MessageDigest thisMD = MessageDigest.getInstance("MD5");
	   byte[] digest = thisMD.digest(source);
	   return digest;
	  } catch (Exception e) {
	   return null;
	  }
	}
}

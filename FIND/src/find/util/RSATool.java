package find.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.crypto.Cipher;

public class RSATool {
	
	/**ʹ��˽Կ�������
	  * ��һ���Ѵ���byte[]��ʽ��˽Կ������ݣ�������ǩ��
	  * 
	  * @param keyInByte
	  *            ����byte[]��˽Կ
	  * @param source
	  *            Ҫǩ�����ݣ�һ��Ӧ������ժҪ
	  * @return ǩ�� byte[]
	  */
	public static byte[] sign(byte[] keyInByte, byte[] source) {
	  try {
	   PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(keyInByte);
	   KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
	   PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
	   Signature sig = Signature.getInstance("SHA1withRSA");
	   sig.initSign(privKey);
	   sig.update(source);
	   return sig.sign();
	  } catch (Exception e) {
	   return null;
	  }
	}

	/**
	  * ��֤����ǩ��
	  * 
	  * @param keyInByte
	  *            ����byte[]��ʽ�Ĺ�Կ
	  * @param source
	  *            ԭ�ĵ�����ժҪ
	  * @param sign
	  *            ǩ���ԭ�ĵ�����ժҪ��ǩ��
	  * @return �Ƿ�֤ʵ boolean
	  */
	public static boolean verify(byte[] keyInByte, byte[] source, byte[] sign) {
	  try {
	   KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
	   Signature sig = Signature.getInstance("SHA1withRSA");
	   X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(keyInByte);
	   PublicKey pubKey = mykeyFactory.generatePublic(pub_spec);
	   sig.initVerify(pubKey);
	   sig.update(source);
	   return sig.verify(sign);
	  } catch (Exception e) {
	   return false;
	  }
	}

	/**
	  * �����µ���Կ�ԣ����ش���byte[]��ʽ˽Կ�͹�Կ
	  * 
	  * @return �����byte[]��ʽ��˽Կ�͹�Կ��object[],���У�object[0]Ϊ˽Կbyte[],object[1]Ϊ��Կbyte[]
	  */
	public static Object[] giveRSAKeyPairInByte() {
	  KeyPair newKeyPair = creatmyKey();
	  if (newKeyPair == null)
	   return null;
	  Object[] re = new Object[2];
	  if (newKeyPair != null) {
	   PrivateKey priv = newKeyPair.getPrivate();
	   byte[] b_priv = priv.getEncoded();
	   PublicKey pub = newKeyPair.getPublic();
	   byte[] b_pub = pub.getEncoded();
	   re[0] = b_priv;
	   re[1] = b_pub;
	   return re;
	  }
	  return null;
	}

	/**
	  * �½���Կ��
	  * 
	  * @return KeyPair����
	  */
	public static KeyPair creatmyKey() {
	  KeyPair myPair;
	  long mySeed;
	  mySeed = System.currentTimeMillis();
	  try {
	   KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	   SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
	   random.setSeed(mySeed);
	   keyGen.initialize(1024, random);
	   myPair = keyGen.generateKeyPair();
	  } catch (Exception e1) {
	   return null;
	  }
	  return myPair;
	}

	/**
	  * ʹ��RSA��Կ�������
	  * 
	  * @param pubKeyInByte
	  *            ����byte[]��ʽ��Կ
	  * @param data
	  *            Ҫ���ܵ����
	  * @return �������
	  */
	public static byte[] encryptByRSA(byte[] pubKeyInByte, byte[] data) {
	  try {
	   KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
	   X509EncodedKeySpec pub_spec = new X509EncodedKeySpec(pubKeyInByte);
	   PublicKey pubKey = mykeyFactory.generatePublic(pub_spec);
	   Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	   cipher.init(Cipher.ENCRYPT_MODE, pubKey);
	   return cipher.doFinal(data);
	  } catch (Exception e) {
	   return null;
	  }
	}

	/**
	  * ��RSA˽Կ����
	  * 
	  * @param privKeyInByte
	  *            ˽Կ����byte[]��ʽ
	  * @param data
	  *            Ҫ���ܵ����
	  * @return �������
	  */
	public static byte[] decryptByRSA(byte[] privKeyInByte, byte[] data) {
	  try {
	   PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(
	     privKeyInByte);
	   KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
	   PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
	   Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	   cipher.init(Cipher.DECRYPT_MODE, privKey);
	   return cipher.doFinal(data);
	  } catch (Exception e) {
	   return null;
	  }

	}
}

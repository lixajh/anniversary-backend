package com.peake.webseed.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;


public class PasswordUtils {
	public static final String DEFAULT_PASSWORD = "88888888";
	//密码加密方法
	public static final String ALGORITHM_NAME = "MD5";
	//密码md5计算次数
	public static final int PWD_HASH_ITERATIONS = 3;

	public static final String DEFAULT_SALT = "defaultSalt";

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	/**
	 * 数据库保存密码生成方法：
	 * 明文密码先md5并转为小写，再使用salt生成SimpleHash。
	 * @param password  明文密码md5并小写得到的字符串
	 * @param salt
	 * @return
	 */
	public static String generatePassword(String password,String salt)
	{
		//明文密码进行md5并转为小写,这里先进行一遍md5加密，因为手机端登录时传过来的参数也已进行了md5加密
		password = md5(password);
		//使用salt生成密码
		String newPassword = new SimpleHash(getAlgorithmName(), password, ByteSource.Util.bytes(salt), getHashIterations())
				.toHex();
		return newPassword;
	}
	
	public static String generatePasswordWithOutMd5(String password,String salt)
	{
		//使用salt生成密码
		String newPassword = new SimpleHash(getAlgorithmName(), password, ByteSource.Util.bytes(salt), getHashIterations())
				.toHex();
		return newPassword;
	}
	
	

	/**
	 * @param password 
	 * @param salt
	 * @param md5cipherText
	 * @return
	 */
	public static boolean checkMd5Password(String password, String salt, String md5cipherText) {
		// 组合username,两次迭代，对密码进行加密
		String password_cipherText =  generatePassword(password, salt);
		return md5cipherText.equals(password_cipherText);
	}

	/**
	 * encode
	 *
	 * @param originString
	 * @return
	 */
	public static String md5(String originString) {
		if (originString != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(originString.getBytes());
				String resultString = byteArrayToHexString(results);
				return resultString.toLowerCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String getAlgorithmName(){
		return ALGORITHM_NAME;
	}
	public static int getHashIterations(){
		return PWD_HASH_ITERATIONS;
	}

	public static String getRanSalt() {
		return randomNumberGenerator.nextBytes().toHex();
	}

	public static void main(String[] args) {
		String aaa = generatePassword(DEFAULT_PASSWORD, "a57760386ad9cd0ab8b627c7e042d44a");
		System.out.println("aaa:"+aaa);
	}
}

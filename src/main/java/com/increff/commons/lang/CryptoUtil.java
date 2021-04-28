/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.increff.commons.lang;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility to perform Encryption of Strings using AES Encryption
 * By Default, uses AES, 128 bit, ECB mode encryption with UTF-8 output encoding
 */
public class CryptoUtil {

	private static String ALGORITHM = "AES";

	/**
	 * Encrypt a plaintext input String with a key using AES encryption
	 * @param plaintext Text to be encrypted
	 * @param keyStr key to be used for encryption
	 * @return Ciphertext string
	 */
	public static String encrypt(String plaintext, String keyStr) throws GeneralSecurityException {
		Cipher c = getCipher(keyStr, Cipher.ENCRYPT_MODE);
		try {
			byte[] decryptedBytes = plaintext.getBytes("UTF-8");
			byte[] encryptedBytes = c.doFinal(decryptedBytes);
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (UnsupportedEncodingException e) {
			throw new GeneralSecurityException("UTF-8 is unsupported", e);
		}
	}

	/**
	 * Decrypts a ciphertext string encrypted through AES
	 * @param ciphertext Ciphertext String to be decrypted
	 * @param keyStr Key to be used for decryption
	 * @return Decrypted plaintext String
	 */
	public static String decrypt(String ciphertext, String keyStr) throws GeneralSecurityException {
		byte[] encryptedBytes = Base64.getDecoder().decode(ciphertext);
		Cipher c = getCipher(keyStr, Cipher.DECRYPT_MODE);
		byte[] decryptedBytes = c.doFinal(encryptedBytes);
		try {
			String plaintext = new String(decryptedBytes, "UTF-8");
			return plaintext;
		} catch (UnsupportedEncodingException e) {
			throw new GeneralSecurityException("UTF-8 is unsupported", e);
		}
	}

	public static Cipher getCipher(String keyStr, int cipherMode) throws GeneralSecurityException {
		byte[] keyBytes;
		try {
			keyBytes = keyStr.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new GeneralSecurityException("UTF-8 is unsupported", e);
		}
		Key key = new SecretKeySpec(keyBytes, ALGORITHM);
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(cipherMode, key);
		return c;
	}
}

package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {

	public String getRandomSalt() {
		String salt = UUID.randomUUID().toString().substring(0,8);
		return salt;
	}
	
	public String getHash(String source, String salt) {
		String hash;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(source.getBytes());
			md.update(salt.getBytes());
			hash = String.format("%0128X", new BigInteger(1,md.digest()));
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

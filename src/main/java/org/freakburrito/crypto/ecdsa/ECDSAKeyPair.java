package org.freakburrito.crypto.ecdsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class ECDSAKeyPair {
	
	
	ECPrivateKey privatekey;
	
	ECPublicKey publicKey;
	
	
	
	
	@PostConstruct
	private void init(){
		

	    KeyPairGenerator keyGen = null;
	    SecureRandom random = null;
		try {
			keyGen = KeyPairGenerator.getInstance("EC");
		    random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


	    
	    keyGen.initialize(256, random);	
	    
	    KeyPair pair = keyGen.generateKeyPair();
	    
	    privatekey = (ECPrivateKey) pair.getPrivate();
	    publicKey = (ECPublicKey) pair.getPublic();
		
	}

}

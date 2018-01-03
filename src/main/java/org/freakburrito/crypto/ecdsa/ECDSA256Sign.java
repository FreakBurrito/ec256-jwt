package org.freakburrito.crypto.ecdsa;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

import javax.inject.Inject;

public class ECDSA256Sign {
	
	
	@Inject 
	ECDSAKeyPair keyPair;
	
	
	public String sign(){
		
		String signature = null;
		
        try {

        /*
         * Create a Signature object and initialize it with the private key
         */

        Signature dsa = Signature.getInstance("SHA1withECDSA");

        dsa.initSign(keyPair.privatekey);

        String str = "This is string to sign";
        byte[] strByte = str.getBytes("UTF-8");
        dsa.update(strByte);

        /*
         * Now that all the data to be signed has been read in, generate a
         * signature for it
         */

        byte[] realSig = dsa.sign();
        
        signature = new BigInteger(1, realSig).toString(16);
        
        System.out.println("Signature: " + signature);

		
        } catch (Exception e){
        	e.printStackTrace();
        	
        }
		
		return signature;
		
		
	}
	

}

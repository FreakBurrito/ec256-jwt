package org.freakburrito.crypto.ecdsa;

import java.math.BigInteger;
import java.security.Signature;

import javax.inject.Inject;
// cribbed from https://stackoverflow.com/questions/11339788/tutorial-of-ecdsa-algorithm-to-sign-a-string
public class ECDSA256Sign {
	
	
	@Inject 
	ECDSAKeyPair keyPair;
	
	
	public String sign(String data){
		
		String signature = null;
		
        try {

        /*
         * Create a Signature object and initialize it with the private key
         */

        Signature ecdsaSignature = Signature.getInstance("SHA256withECDSA");

        ecdsaSignature.initSign(keyPair.privatekey);

        byte[] dataByte = data.getBytes("UTF-8");
        ecdsaSignature.update(dataByte);

        /*
         * Now that all the data to be signed has been read in, generate a
         * signature for it
         */

        byte[] realSig = ecdsaSignature.sign();
        
        signature = new BigInteger(1, realSig).toString(16);
        
        System.out.println("Signature: " + signature);

		
        } catch (Exception e){
        	e.printStackTrace();
        	
        }
		
		return signature;
		
		
	}
	

}

package org.freakburrito.crypto.ecdsa;

import java.math.BigInteger;
import java.security.Signature;

import javax.inject.Inject;

public class ECDSA256Verify {

	@Inject
	ECDSAKeyPair keyPair;

	public boolean verify(String signature) {

		boolean verified = false;
		
		try {

			/*
			 * Create a Signature object and initialize it with the private key
			 */

			Signature dsa = Signature.getInstance("SHA1withECDSA");

			dsa.initVerify(keyPair.publicKey);

			String str = "This is string to sign";
			byte[] strByte = str.getBytes("UTF-8");
			dsa.update(strByte);

			byte[] realSig = new BigInteger(signature, 16).toByteArray();

			/*
			 * Now that all the data to be signed has been read in, generate a
			 * signature for it
			 */

			verified = dsa.verify(realSig);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return verified;

	}

}

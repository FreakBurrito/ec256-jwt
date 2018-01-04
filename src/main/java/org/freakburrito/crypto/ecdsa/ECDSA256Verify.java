package org.freakburrito.crypto.ecdsa;

import java.math.BigInteger;
import java.security.Signature;

import javax.inject.Inject;

// cribbed from https://stackoverflow.com/questions/11339788/tutorial-of-ecdsa-algorithm-to-sign-a-string
public class ECDSA256Verify {

	@Inject
	ECDSAKeyPair keyPair;

	@Inject
	ECDSAPublicKey publicKey;

	public boolean verify(String signature, String data) {

		boolean verified = false;

		try {

			/*
			 * Create a Signature object and initialize it with the private key
			 */

			Signature ecdsaSignature = Signature.getInstance("SHA256withECDSA");

			ecdsaSignature.initVerify(keyPair.publicKey);

			byte[] dataByte = data.getBytes("UTF-8");
			ecdsaSignature.update(dataByte);

			byte[] realSig = new BigInteger(signature, 16).toByteArray();

			/*
			 * Now that all the data to be signed has been read in, generate a
			 * signature for it
			 */

			verified = ecdsaSignature.verify(realSig);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return verified;

	}

	public boolean verifyNewPublicKey(String signature, String data) {
		boolean verified = false;

		try {

			/*
			 * Create a Signature object and initialize it with the private key
			 */

			Signature ecdsaSignature = Signature.getInstance("SHA256withECDSA");

			ecdsaSignature.initVerify(publicKey.publicKey);

			byte[] dataByte = data.getBytes("UTF-8");
			ecdsaSignature.update(dataByte);

			byte[] realSig = new BigInteger(signature, 16).toByteArray();

			/*
			 * Now that all the data to be signed has been read in, generate a
			 * signature for it
			 */

			verified = ecdsaSignature.verify(realSig);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return verified;

	}

}

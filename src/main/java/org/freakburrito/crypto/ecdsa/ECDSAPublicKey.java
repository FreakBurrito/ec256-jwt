package org.freakburrito.crypto.ecdsa;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class ECDSAPublicKey {

	@Inject
	ECDSAKeyPair keyPair;

	ECPublicKey publicKey;

	@PostConstruct
	private void init() {
		// https://stackoverflow.com/a/29355749
		try {
			
			BigInteger x = new BigInteger(keyPair.publicKey.getW().getAffineX().toString());
			BigInteger y = new BigInteger(keyPair.publicKey.getW().getAffineX().toString());
			
			
			ECPoint publicKeyPoint = new ECPoint(x,y);
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC", "SunEC");
			parameters.init(new ECGenParameterSpec("secp256r1"));
			ECParameterSpec ecParameters = parameters.getParameterSpec(ECParameterSpec.class);
			ECPublicKeySpec pubSpec = new ECPublicKeySpec(publicKeyPoint, ecParameters);
			KeyFactory kf = KeyFactory.getInstance("EC");
			publicKey = (ECPublicKey) kf.generatePublic(pubSpec);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

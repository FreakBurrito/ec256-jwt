package org.freakburrito.crypto.ecdsa;


import org.jboss.weld.environment.se.events.ContainerInitialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ECDSAMain {
	
	
	 
	    @Inject
	    ECDSA256Sign sign;
	    
	    @Inject
	    ECDSA256Verify verify;
	 
	    public void testSignature(@Observes ContainerInitialized event) {
	       
	    	String signature = sign.sign();
	    	
	    	System.out.println(signature);
	    	
	    	boolean result = verify.verify(signature);
	    	
	    	System.out.println("Signature Valid: " + result);
	    	
	    	
	    }
	

}

package org.freakburrito.crypto.ecdsa;


import org.jboss.weld.environment.se.events.ContainerInitialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ECDSAMain {
	
	
	 
	    @Inject
	    ECDSA256Sign sign;
	 
	    public void testSignature(@Observes ContainerInitialized event) {
	        System.out.println(sign.sign());
	    }
	

}

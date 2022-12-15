package service.consumer;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.provider.remoteservice.generic.RemoteCallImpl;
import org.eclipse.ecf.provider.tcpsocket.client.TCPSocketRequestCustomizer;
import org.eclipse.ecf.provider.tcpsocket.common.TCPSocketRequest;
import org.osgi.service.component.annotations.Component;

import service.ExampleRequest;

@Component
public class ExampleRequestCustomizer implements TCPSocketRequestCustomizer{

	@Override
	public TCPSocketRequest createRequest(ID requestContainerID, long serviceId, RemoteCallImpl call) {
		String localUsername = System.getProperty("user.name");
		return new ExampleRequest(requestContainerID, serviceId, call, localUsername);
	}

}

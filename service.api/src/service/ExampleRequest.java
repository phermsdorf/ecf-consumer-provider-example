package service;

import org.eclipse.ecf.core.identity.ID;
import org.eclipse.ecf.provider.remoteservice.generic.RemoteCallImpl;
import org.eclipse.ecf.provider.tcpsocket.common.TCPSocketRequest;

public class ExampleRequest extends TCPSocketRequest{

	private static final long serialVersionUID = 1L;
	private String username;

	public ExampleRequest(ID requestContainerID, long serviceId, RemoteCallImpl call, String username) {
		super(requestContainerID, serviceId, call);
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

}

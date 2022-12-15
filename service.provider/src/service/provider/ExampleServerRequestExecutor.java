package service.provider;

import org.eclipse.ecf.provider.remoteservice.generic.Response;
import org.eclipse.ecf.provider.tcpsocket.common.TCPSocketRequest;
import org.eclipse.ecf.provider.tcpsocket.server.TCPSockerServerRequestExecutor;

import org.eclipse.ecf.remoteservice.RemoteServiceRegistrationImpl;
import org.osgi.service.component.annotations.Component;
import org.slf4j.MDC;
import org.slf4j.MDC.MDCCloseable;

import service.ExampleRequest;

@Component
public class ExampleServerRequestExecutor extends TCPSockerServerRequestExecutor{

	@Override
	public Response execute(TCPSocketRequest request, RemoteServiceRegistrationImpl reg) {
		if(request instanceof ExampleRequest) {
			ExampleRequest exampleRequest = (ExampleRequest) request;
			
			//with that one could configure SESSION_NAME variable in Logger configuration to log the calling username
			try (MDCCloseable closeable = MDC.putCloseable("SESSION_NAME", exampleRequest.getUsername())) {
				UserManager.setUser(exampleRequest.getUsername());
				return super.execute(exampleRequest, reg);
			} finally {
				UserManager.setUser(null);
			}
			
		} else throw new IllegalStateException();
	}

}

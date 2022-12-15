package service.provider;

import org.eclipse.ecf.provider.tcpsocket.common.TCPSocketConstants;
import org.osgi.service.component.annotations.Component;

import service.IHello;

@Component(property = {
		"my.id=myservice",
		"service.exported.interfaces=*",
		"service.exported.configs=" + TCPSocketConstants.SERVER_PROVIDER_CONFIG_TYPE
		 })
public class HelloService implements IHello{

	public HelloService() {
		System.err.println();
	}
	
	@Override
	public void sayHello() {
		System.err.println("Hello called from " + UserManager.getUser());
	}

}

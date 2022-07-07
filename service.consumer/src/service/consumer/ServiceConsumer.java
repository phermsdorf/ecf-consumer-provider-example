package service.consumer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

import service.IHello;

@Component
public class ServiceConsumer {
	
	@Reference(policy = ReferencePolicy.DYNAMIC)
	private volatile IHello hello;
	
	private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
	@Activate
	void onActivate() {
		System.err.println("Started Consumer");
		hello.sayHello();
		executor.scheduleWithFixedDelay(() -> hello.sayHello(),0, 15,TimeUnit.SECONDS);
	}
	@Deactivate
	void onDeactivate() {
		executor.shutdown();
		System.err.println("Stopped Consumer");
	}
	
}

package service.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import service.consumer.programatically.SecondConsumer;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		new SecondConsumer().start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}

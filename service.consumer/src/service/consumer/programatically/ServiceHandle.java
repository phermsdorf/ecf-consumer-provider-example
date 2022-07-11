package service.consumer.programatically;

import java.io.Closeable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceHandle<T> implements Closeable {

		private final BundleContext context;
		private ServiceReference<T> serviceReference;
		private final Class<T> target;

		public ServiceHandle(final BundleContext context, final Class<T> target) {
			this.context = context;
			this.target = target;
		}

		public T getService() {
			serviceReference = context.getServiceReference(target);
			if(serviceReference==null) {
				return null;
			}
			return context.getService(serviceReference);
		}

		@Override
		public void close() {
			if(serviceReference!=null) {
				context.ungetService(serviceReference);
			}
		}
	}

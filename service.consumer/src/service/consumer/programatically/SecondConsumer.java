package service.consumer.programatically;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import service.IHello;

public class SecondConsumer {
	
	public SecondConsumer() {
	}

	private void callService() {
		//that would be done by a utility class - just for the example
		try( ServiceHandle<IHello> serviceHandle = new ServiceHandle<IHello>(getBundleContext(), IHello.class)) {
			IHello service = serviceHandle.getService();
			if(service==null) {
				System.err.println("no service available");
			}else {
				service.sayHello();
			}
		}
	}
	
	public void start() {
		Job job = new Job("demo") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					callService();
				} finally {
					schedule(5000L);
				}
				return Status.OK_STATUS;
			}
		};
		//give the ServiceImporter some time tu run
		job.schedule(5000L);
	}

	private BundleContext getBundleContext() {
		return FrameworkUtil.getBundle(getClass()).getBundleContext();
	}

}

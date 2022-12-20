/*******************************************************************************
 * Copyright (c) 2022 GODYO Business Solutions AG and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Peter Hermsdorf, GODYO Business Solutions AG - initial API and implementation
 ******************************************************************************/

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

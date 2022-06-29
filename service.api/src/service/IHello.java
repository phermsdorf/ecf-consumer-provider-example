package service;

import java.util.UUID;

public interface IHello {
	
	String SERVICE_ID = String.valueOf(UUID.nameUUIDFromBytes(IHello.class.getName().getBytes()).getMostSignificantBits());

	void sayHello();

}

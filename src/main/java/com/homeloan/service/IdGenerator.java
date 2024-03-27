package com.homeloan.service;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator{

	private static final String PREFIX = "HL";
    private static final AtomicInteger sequence = new AtomicInteger(1);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		 int value = sequence.incrementAndGet();
	        String id = PREFIX + String.format("%04d", value);
	        return id;
	}

}

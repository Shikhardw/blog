package com.swayam.demo.rmi.shared.jini.http;

import java.lang.reflect.Method;

import net.jini.core.constraint.MethodConstraints;
import net.jini.jeri.BasicInvocationHandler;
import net.jini.jeri.ObjectEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpBasedInvocationHandler extends BasicInvocationHandler {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpBasedInvocationHandler.class);

    public HttpBasedInvocationHandler(ObjectEndpoint oe, MethodConstraints serverConstraints) {
        super(oe, serverConstraints);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info("************** ");
        return super.invoke(proxy, method, args);
    }

}

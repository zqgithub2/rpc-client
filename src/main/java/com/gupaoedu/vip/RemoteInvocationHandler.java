package com.gupaoedu.vip;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        //请求的数据包
        RpcRequest rpcRequest = new RpcRequest();
        //请求的数据包
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        //远程通信
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object result = rpcNetTransport.send(rpcRequest);
        return result;
    }
}

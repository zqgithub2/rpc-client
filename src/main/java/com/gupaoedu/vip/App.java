package com.gupaoedu.vip;

public class App {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String result = iHelloService.sayHello("mic");
        System.out.println(result);


    }
}

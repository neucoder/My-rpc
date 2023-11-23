package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void sayHello(String hello);
}

class HelloImpl implements Hello{
    private String name;
    @Override
    public void sayHello(String hello) {
        System.out.println(hello + " " + "world " +"name:"+name);
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        // 创建被代理类对象
        Hello hello = new HelloImpl();
// 创建代理类对象
        Hello proxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理方法执行前");
                method.invoke(hello, args);
                System.out.println("代理方法执行后");
                return null;
            }
        });
        //测试jdk动态代理生成代理类
        //参考 https://stackoverflow.com/questions/4409456/how-to-unwrap-the-original-object-from-a-dynamic-proxy

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
        Field f = invocationHandler.getClass().getDeclaredField("val$hello");
        f.setAccessible(true);
        Hello obj = (Hello)f.get(invocationHandler);
        Field name = obj.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "你是一个什么样的对象啊，让人这么难搞");


// 调用被代理类的setName方法，修改name属性
        proxy.sayHello("hello");

    }
}


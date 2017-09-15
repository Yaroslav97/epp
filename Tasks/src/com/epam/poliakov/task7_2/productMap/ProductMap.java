package com.epam.poliakov.task7_2.productMap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

public class ProductMap implements InvocationHandler {

    private Map map = new HashMap();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
           return map.put(method.getName().substring(3, method.getName().length()).toLowerCase(), args[0]);
        } else if (method.getName().startsWith("get")) {
            return map.get(method.getName().substring(3, method.getName().length()).toLowerCase());
        }
        throw new NoSuchMethodException();
    }
}

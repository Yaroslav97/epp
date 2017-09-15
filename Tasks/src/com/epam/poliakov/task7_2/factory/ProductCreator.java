package com.epam.poliakov.task7_2.factory;

import com.epam.poliakov.task7_2.exception.UnmodifiableException;
import com.epam.poliakov.task7_2.product.Car;
import com.epam.poliakov.task7_2.product.Product;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProductCreator implements Creator, InvocationHandler {

    private Product product;

    public ProductCreator(Product product) {
        this.product = product;
    }

    @Override
    public Product factoryMethod() {
        return product = (Product) setProxyClass();
    }

    public Object setProxyClass() {
        return Proxy.newProxyInstance(
                Car.class.getClassLoader(),
                new Class[]{Product.class},
                new ProductCreator(product));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().startsWith("set")) {
            throw new UnmodifiableException();
        }
        return method.invoke(product, args);
    }
}

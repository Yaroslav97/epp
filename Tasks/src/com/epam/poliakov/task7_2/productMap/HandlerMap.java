package com.epam.poliakov.task7_2.productMap;

import com.epam.poliakov.task7_2.factory.Creator;
import com.epam.poliakov.task7_2.product.Product;

import java.lang.reflect.Proxy;

public class HandlerMap implements Creator{

    @Override
    public Product factoryMethod() {
        return (Product) Proxy.newProxyInstance(
                Product.class.getClassLoader(),
                new Class[]{Product.class},
                new ProductMap());
    }
}

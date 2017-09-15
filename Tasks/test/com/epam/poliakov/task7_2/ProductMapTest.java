package com.epam.poliakov.task7_2;

import com.epam.poliakov.task7_2.product.Product;
import com.epam.poliakov.task7_2.productMap.HandlerMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProductMapTest {

    private Product product;

    @Before
    public void init(){
        HandlerMap handlerMap = new HandlerMap();
        product = handlerMap.factoryMethod();
        product.setName("car");
        product.setColor("blue");
    }

    @Test
    public void testShouldGetNameFromMap() {
        assertEquals("car", product.getName());
    }

    @Test
    public void testShouldGetColorFromMap() {
        assertEquals("blue", product.getColor());
    }

    @Test
    public void testShouldSetNameFromMap() {
        product.setName("aaa");
        assertEquals("aaa", product.getName());
    }

    @Test
    public void testShouldSetColorFromMap() {
        product.setColor("0000ff");
        assertEquals("0000ff", product.getColor());
    }
}
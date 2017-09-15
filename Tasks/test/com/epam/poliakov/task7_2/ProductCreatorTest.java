package com.epam.poliakov.task7_2;

import com.epam.poliakov.task7_2.exception.UnmodifiableException;
import com.epam.poliakov.task7_2.factory.Creator;
import com.epam.poliakov.task7_2.factory.ProductCreator;
import com.epam.poliakov.task7_2.product.Car;
import com.epam.poliakov.task7_2.product.Product;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductCreatorTest {

   private Creator creator;

    @Before
    public void init(){
        creator = new ProductCreator(new Car("Tesla", "black"));
    }

    @Test
    public void testShouldCreateFactoryMethod() {
        Product product = creator.factoryMethod();
        assertEquals("Tesla", product.getName());
    }

    @Test(expected = UnmodifiableException.class)
    public void testShouldCreateFactoryMethodAndThrowException() {
        Product product = creator.factoryMethod();
        product.setName("uhgiu");

    }
}

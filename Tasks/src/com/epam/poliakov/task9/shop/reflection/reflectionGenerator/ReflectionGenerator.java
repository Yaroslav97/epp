package com.epam.poliakov.task9.shop.reflection.reflectionGenerator;

import com.epam.poliakov.task9.shop.entity.productEntity.Vehicle;

public interface ReflectionGenerator {

    Vehicle generate(String loadClass);
}

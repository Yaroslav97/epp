package com.epam.poliakov.task7_1.reflection.reflectionGenerator;

import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

public interface ReflectionGenerator {

    Vehicle generate(String loadClass);
}

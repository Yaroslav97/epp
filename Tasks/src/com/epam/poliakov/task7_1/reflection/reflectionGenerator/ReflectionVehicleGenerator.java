package com.epam.poliakov.task7_1.reflection.reflectionGenerator;

import com.epam.poliakov.task7_1.annotation.Product;
import com.epam.poliakov.task7_1.shop.controller.generator.inputer.Inputer;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class ReflectionVehicleGenerator implements ReflectionGenerator {

    private static final String PATH = "com.epam.poliakov.task7_1.shop.entity.productEntity.";
    private static final String I18N = "i18n";
    private ResourceBundle resourceBundle;
    private Inputer inputer;

    public ReflectionVehicleGenerator(Inputer inputer) {
        this.inputer = inputer;
        resourceBundle = ResourceBundle.getBundle(I18N);
    }

    @Override
    public Vehicle generate(String loadClass) {
        Vehicle vehicle = null;
        try {
            vehicle = (Vehicle) createObject(loadClass);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        setParameter(vehicle);
        return vehicle;
    }

    public void setParameter(Vehicle vehicle) {
        try {
            List<Method> allSetMethods = getAllSetters(vehicle.getClass().getMethods());
            for (Method m : allSetMethods) {
                Object[] obj = getInputer(m);
                m.invoke(vehicle, obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Object[] getInputer(Method m) {
        Object[] args = new Object[1];
        Type[] type = m.getParameterTypes();

        if (String.class.equals(type[0])) {
            args[0] = inputer.generateString(resourceBundle.getString(m.getName().substring(3, m.getName().length()).toLowerCase()));
        } else if (int.class.equals(type[0])) {
            args[0] = inputer.generateInt(resourceBundle.getString(m.getName().substring(3, m.getName().length()).toLowerCase()));
        }
        return args;
    }

    private List<Method> getAllSetters(Method[] methods) {
        Method m = null;
        List<Method> methodList = new ArrayList<>();

        for (int i = 0; i < methods.length; i++) {
            m = methods[i];
            if (m.getName().contains("set") && m.isAnnotationPresent(Product.class)) {
                methodList.add(methods[i]);
            }
        }
        return methodList;
    }

    public Object createObject(String loadClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(PATH + loadClass).newInstance();
    }
}

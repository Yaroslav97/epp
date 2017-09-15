package com.epam.poliakov.task7_1;
import com.epam.poliakov.task7_1.reflection.ReflectionResourceBundle;
import com.epam.poliakov.task7_1.shop.entity.productEntity.Vehicle;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ReflectionTest {

    public static final String WRONG_KEY = "a";

    @Test
    public void testShouldGetI18nWordFromBundleForEN() {
        Locale.setDefault(Locale.ENGLISH);
        ReflectionResourceBundle reflectionResourceBundle = new ReflectionResourceBundle(Vehicle.class);
        assertEquals("name", reflectionResourceBundle.getI18nWord(Vehicle.NAME));
    }

    @Test
    public void testShouldGetI18nWordFromBundleForRU() throws Exception {
        Locale.setDefault(new Locale("ru"));
        ReflectionResourceBundle reflectionResourceBundle = new ReflectionResourceBundle(Vehicle.class);
        assertEquals("название", reflectionResourceBundle.getI18nWord(Vehicle.NAME));
    }

    @Test
    public void testShouldCheckGetI18nWordForNull() throws Exception {
        Locale.setDefault(new Locale("ru"));
        ReflectionResourceBundle reflectionResourceBundle = new ReflectionResourceBundle(Vehicle.class);
        assertEquals(null, reflectionResourceBundle.getI18nWord(WRONG_KEY));
    }
}
package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;

    @Test
    public void getSound() {
        Cat cat = new Cat(mockFeline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(mockFeline);
        List<String> expectedFood = Arrays.asList("мясо1", "мясо2");

        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);

        verify(mockFeline).eatMeat();
    }
}
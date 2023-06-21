package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FelineTest {

    @Mock
    private Animal animalMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(animalMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int expectedKittens = 1;

        int actualKittens = feline.getKittens();

        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithCount() {
        Feline feline = new Feline();
        int expectedKittens = 3;
        int kittensCount = 3;

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(expectedKittens, actualKittens);
    }
}
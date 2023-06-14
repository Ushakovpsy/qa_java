package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    @Test
    public void testGetKittens() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);

        when(mockFeline.getKittens()).thenReturn(3);

        int result = lion.getKittens();
        assertEquals(3, result);
    }

    @Test
    public void testDoesHaveMane_Samec() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);

        boolean result = lion.doesHaveMane();
        assertEquals(true, result);
    }

    @Test
    public void testDoesHaveMane_Samka() throws Exception {

        Lion lion = new Lion("Самка", mockFeline);

        boolean result = lion.doesHaveMane();
        assertEquals(false, result);
    }

    @Test
    public void testGetFood() throws Exception {

        Lion lion = new Lion("Самец", mockFeline);

        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        List<String> result = lion.getFood();
        assertEquals(List.of("Мясо"), result);
    }

    @Test
    public void incorrectGenderException() throws Exception {

        String expected = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Лев", mockFeline);
        });
        assertEquals(expected, exception.getMessage());
    }
}

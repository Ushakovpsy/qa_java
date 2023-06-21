package com.example;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodPredator() throws Exception {
        Animal animal = new Animal();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test(expected = Exception.class)
    public void getFoodUnknownAnimal() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный вид");
    }

    @Test
    public void getFamilyAnimal() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}
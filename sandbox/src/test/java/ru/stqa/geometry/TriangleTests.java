package ru.stqa.geometry;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateSquare() {
        Assertions.assertEquals(17.320508075688775, Triangle.countTriangleSquare(5.0, 7.0, 8.0));
    }

    void canCalculatePerimeter() {
        Assertions.assertEquals(20, Triangle.countTriangleSquare(5.0, 7.0, 8.0));
    }
}


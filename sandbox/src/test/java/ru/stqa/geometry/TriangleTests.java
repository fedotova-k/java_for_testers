package ru.stqa.geometry;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateSquare() {
        var triangle = new Triangle(5.0,7.0,8.0);
        double result = triangle.countTriangleSquare();
        Assertions.assertEquals(17.320508075688775, result);
    }

    void canCalculatePerimeter() {
        Assertions.assertEquals(20, new Triangle(5.0,7.0,8.0).countTriangleSquare());
    }
}


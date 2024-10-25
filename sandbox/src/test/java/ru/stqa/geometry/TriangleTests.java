package ru.stqa.geometry;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateSquare() {
        var triangle = new Triangle(5.0, 7.0, 8.0);
        double result = triangle.countTriangleSquare();
        Assertions.assertEquals(17.320508075688775, result);
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20, new Triangle(5.0, 7.0, 8.0).countTrianglePerimeter());
    }

    @Test
    void canNotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(4.0, -4.0, 5.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //System.out.println("Одна из сторон меньше нуля");
        }
    }

    @Test
    void canNotCreateUnequalTriangle() {
        try {
            new Triangle(1.0, 2.0, 9.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //System.out.println("Нарушено неравенство треугольника");
        }
    }

    @Test
    void testEqualityWithTheSameArguments() {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(3.0, 5.0, 4.0);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void testEqualityWithAlmostEqualArguments() {
        var t1 = new Triangle(4.0, 5.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void testTwoEqualityWithAlmostEqualArguments() {
        var t1 = new Triangle(4.0, 5.0, 3.0);
        var t2 = new Triangle(4.0, 3.0, 5.0);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void testEqualityWithDifferentArguments() {
        try {
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(2.0, 4.0, 4.0);
        Assertions.assertEquals(t1, t2);
        }
        catch (AssertionError e) {
          //  System.out.println("Треугольники не равны");
        }
    }

}


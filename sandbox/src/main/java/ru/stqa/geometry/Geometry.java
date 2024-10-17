package ru.stqa.geometry;

public class Geometry {
    public static void main(String[] args) {
        Triangle triangle = new Triangle (5,9,7);

        System.out.println("Площадь треугольника равна: "+(triangle.countTriangleSquare()));
        System.out.println("Периметр треугольника равен: "+ (triangle.countTrianglePerimeter()));
    }
}
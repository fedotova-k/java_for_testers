package ru.stqa.geometry;

public class Geometry {
    public static void main(String[] args) {

        System.out.println("Площадь треугольника равна: "+(Triangle.countTriangleSquare(6,7,9)));
        System.out.println("Периметр треугольника равен: "+ (Triangle.countTrianglePerimeter(6,7,9)));
    }
}
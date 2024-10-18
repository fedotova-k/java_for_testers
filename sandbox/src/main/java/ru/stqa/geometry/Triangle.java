package ru.stqa.geometry;

public record Triangle (double a, double b, double c) //класс со сторонами треугольника
{


    public static double countTriangleSquare(double a, double b, double c) { // метод для высчитаывания площади по формуле Герона
        double semiperimeter = ((a + b + c) / 2); // высчитываем полупериметр
        return Math.sqrt((semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c))); // рассчет по формуле Герона
    }

    public static double countTrianglePerimeter(double a, double b, double c) { // метод для расчета периметра
        return (a + b + c);
    }
}
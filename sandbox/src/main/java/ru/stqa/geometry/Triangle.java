package ru.stqa.geometry;

public class Triangle {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
     this.a =a;
     this.b =b;
     this.c =c;
}
    public double countTriangleSquare() { // метод для высчитаывания площади по формуле Герона
        double semiperimeter = ((this.a + this.b + this.c) / 2); // высчитываем полупериметр
        return Math.sqrt((semiperimeter * (semiperimeter - this.a) * (semiperimeter - this.b) * (semiperimeter - this.c))); // рассчет по формуле Герона
    }

    public double countTrianglePerimeter() { // метод для расчета периметра
        return (this.a + this.b + this.c);
    }
}
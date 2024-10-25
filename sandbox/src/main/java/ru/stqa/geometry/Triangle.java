package ru.stqa.geometry;

import java.util.Objects;

public class Triangle {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            throw new IllegalArgumentException("Значение должно быть больше нуля");
        }
        else if ((a + b < c) || (b + c < a) || (c + a < b)) {
            throw new IllegalArgumentException("Сумма двух любых сторон должна быть не меньше третьей стороны");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double countTriangleSquare() { // метод для высчитаывания площади по формуле Герона
        double semiperimeter = ((this.a + this.b + this.c) / 2); // высчитываем полупериметр
        return Math.sqrt((semiperimeter * (semiperimeter - this.a) * (semiperimeter - this.b) * (semiperimeter - this.c))); // рассчет по формуле Герона
    }

    public double countTrianglePerimeter() { // метод для расчета периметра
        return (this.a + this.b + this.c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.b) == 0)
                || ((Double.compare(this.a, triangle.c) == 0) && (Double.compare(this.b, triangle.b) == 0) && (Double.compare(this.c, triangle.a) == 0))
                || ((Double.compare(this.a, triangle.b) == 0) && (Double.compare(this.b, triangle.a) == 0) && (Double.compare(this.c, triangle.c) == 0))
                || ((Double.compare(this.a, triangle.c) == 0) && (Double.compare(this.b, triangle.a) == 0) && (Double.compare(this.c, triangle.b) == 0))
                || (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.a) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
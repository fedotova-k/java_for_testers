package ru.stqa.geometry;

public record Triangle (double a, double b,double c) {

    private double getSemiperimeter() {
        return ((this.a + this.b + this.c) / 2);
    }

    public double countTriangleSquare() {
        return Math.sqrt((getSemiperimeter() * (getSemiperimeter() - a) * (getSemiperimeter() - b) * (getSemiperimeter() - c)));
    }

    public double countTrianglePerimeter() {
        return (a+b+c);
    }
}
import java.lang.Math;

public class Triangle implements Shape {
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        return a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
    }

    @Override
    public double getPerimeter() {
        double sideA = a.getDistance(b);
        double sideB = b.getDistance(c);
        double sideC = c.getDistance(a);
        double p = getPerimeter() / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double yHeight() {
        return abs(a.getDistance(new Poin))
    }
}
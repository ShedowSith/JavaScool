package homework_1;

import java.util.Arrays;

public class TestFigure {
    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        Square s = new Square(5);
        Rect r = new Rect(4, 5);
        Circle c = new Circle(6);
        System.out.println("Площадь треугольника = " + t.area());
        System.out.println("Площадь квадрата = " + s.area());
        System.out.println("Площадь прямоугольника = " + r.area());
        System.out.println("Площадь круга = " + c.area());
    }
}

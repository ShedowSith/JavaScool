package homework_1;

class Triangle extends Rect{
    int c;
    public Triangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public double area() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}

package homework_1;

class Rect extends Square{
    int b;

    public Rect(int a, int b) {
        super(a);
        this.b = b;
    }

    public double area() {
        return a*b;
    }
}

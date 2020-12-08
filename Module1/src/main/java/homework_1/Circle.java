package homework_1;

class Circle extends Figure{
    private int r;
    public Circle(int r) {
        this.r = r;
    }

    public double area() {
        return Math.PI*r;
    }
}
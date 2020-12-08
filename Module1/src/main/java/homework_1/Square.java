package homework_1;

class Square extends Figure{
    int a;

    public Square(int a) {
        this.a = a;
    }

    public double area() {
        return a*a;
    }
}

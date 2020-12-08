package homework_1;

public class Converter {
    public static void main(String[] args) {
        System.out.println("По Кельвину " + toKelvin(10));
        System.out.println("По Фаренгейту " + toFarengeit(10));
    }
    public static double toKelvin(double c){
        return c + 273.15;
    }
    public static double toFarengeit(double c){
        return c * 1.8 + 32;
    }
}

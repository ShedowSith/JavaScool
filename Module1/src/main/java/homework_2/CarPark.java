package homework_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarPark {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        LoadHelperCar.init(cars);
        cars.forEach(System.out::println);
/*
        Первый вариант
*/
        Collections.sort(cars);
        System.out.println("------------------------");
        cars.forEach(System.out::println);
/*
        Второй вариант
 */
//        List<Car> sortCars = cars.stream().sorted().collect(Collectors.toList());
//        sortCars.forEach(System.out::println);
    }



    public static class LoadHelperCar{
        public static Collection<Car> init(Collection<Car> cars){
            cars.add(new Car("Лада", "седан"));
            cars.add(new Car("Лада", "хэтчбек"));
            cars.add(new Car("Мерседес", "седан"));
            cars.add(new Car("Бмв", "кроссовер"));
            cars.add(new Car("Форд", "хэтчбек"));
            cars.add(new Car("Пежо", "седан"));
            cars.add(new Car("Пежо", "кроссовер"));
            cars.add(new Car("Тойота", "седан"));
            return cars;
        }
    }
    public static class Car implements Comparable<Car> {
        private String model;
        private String type;

        public Car(String model, String type) {
            this.model = model;
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public int compareTo(Car o) {
            return this.getType().compareTo(o.getType());
        }

        @Override
        public String toString() {
            return this.model + " " + this.type;
        }
    }
}

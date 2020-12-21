package homework_3;
import java.util.Map;

public interface CountMap <T>{

    // добавляет элемент в этот контейнер.
    void add(T o);
    //Возвращает количество добавлений данного элемента
    int getCount(T o);
    ///Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(T o);
    //количество разных элементов
    int size();
    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей, суммировать значения
    void addAll(CountMap source);
    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map<T, Integer> toMap();
    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<T, Integer > destination);

    public static void main(String[] args) {
        CountMap map = new CountMapImpl();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5); // 2
        System.out.println(count);
        int count2 = map.getCount(6); // 1
        System.out.println(count2);
        int count3 = map.getCount(10); // 3
        System.out.println(count3);
    }
}

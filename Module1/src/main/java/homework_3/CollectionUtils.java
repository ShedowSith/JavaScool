package homework_3;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }
    public static<T> List newArrayList() {
        return new ArrayList<T>();
    }
    public static<T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }
    public static<E> List limit(List<E> source, int size) {
        return source.subList(0, size);
    }
    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }
    public static<T> void removeAll( List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }
    //true если первый лист содержит все элементы второго
    public static<T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }
    //true если первый лист содержит хотя-бы 1 второго
    public static<T> boolean containsAny(List<? extends T> c1, List<T> c2) {
        boolean result = false;
        Iterator<T> iterator = c2.iterator();
        while (iterator.hasNext()){
            result = c1.contains(iterator.next());
            if (result) break;
        }
        return result;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    public static<T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<T> listResult = new ArrayList();
        Iterator<? extends T> iterator = list.iterator();
        while (iterator.hasNext()){
            T elem = iterator.next();
            int r1 = elem.compareTo(min);
            int r2 = elem.compareTo(max);
            if(r1 != r2){
                listResult.add(elem);
            }
        }
        return listResult;
    }
    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static<T extends Comparable<? super T>> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> listResult = new ArrayList();
        Iterator<? extends T> iterator = list.iterator();
        while (iterator.hasNext()){
            T elem = iterator.next();
            int r1 = elem.compareTo(min);
            int r2 = elem.compareTo(max);
            if(r1 != r2){
                listResult.add(elem);
            }
        }
        Collections.sort(listResult, comparator);
        return listResult;
    }

    public static void main(String[] args) {
        CollectionUtils.range(Arrays.asList(8,1,3,5,6,4), 3, 6).forEach(System.out::println);
        System.out.println("-----------------------------");
        CollectionUtils.range(Arrays.asList(8,1,3,5,6,4), 3, 6, Comparator.naturalOrder()).forEach(System.out::println);
    }

}

package homework_3;

import java.util.*;

public class CountMapImpl<T> implements CountMap<T>{
    private Map<T, Integer> map = new HashMap<>();
    @Override
    public void add(T o) {
        map.put(o, map.getOrDefault(o, 0)+1);
    }

    @Override
    public int getCount(T o) {
        return map.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        int count = map.getOrDefault(o, 0);
        map.remove(o);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap source) {
        Iterator<Map.Entry<T, Integer>> iterator = source.toMap().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<T, Integer> entry = iterator.next();
            map.put(entry.getKey(), map.getOrDefault(entry.getKey(), entry.getValue())+entry.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        map.forEach((k,v) -> destination.put(k,v));
    }
}

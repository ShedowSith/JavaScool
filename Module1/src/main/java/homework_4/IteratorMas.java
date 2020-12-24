package homework_4;

import java.util.Iterator;

public class IteratorMas implements Iterator {
    private Object[] objects;
    private int size;
    private int current;
    public IteratorMas(Object[] objects) {
        this.objects = objects;
        this.size = objects.length;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return (size!=0 && current<size)?true:false;
    }

    @Override
    public Object next() {
        Object o = objects[current];
        current++;
        return o;
    }
}

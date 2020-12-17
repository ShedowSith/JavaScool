package homework_2;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public class IteratorRevers<T> implements Iterator<T> {
    private ArrayDeque<T> stack = new ArrayDeque<>();
    public IteratorRevers(Collection<T> list) {
        list.forEach(v -> stack.push(v));
    }

    @Override
    public boolean hasNext() {
        return stack.peek()!=null;
    }

    @Override
    public T next() {
        return stack.poll();
    }
}

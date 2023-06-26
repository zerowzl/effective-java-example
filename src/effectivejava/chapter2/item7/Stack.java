package effectivejava.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 消除过期的对象引用
 *
 * @author Dave Wang
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 有内存泄露
     */
    /*public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }*/
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        // java.util.Vector#removeElementAt
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

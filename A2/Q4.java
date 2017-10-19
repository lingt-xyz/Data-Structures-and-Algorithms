/**
 * Created by Ling Tan on 2017-02-08.
 */
public class Q4 {
    class ArrayStack<E> {
        public static final int CAPACITY = 100;
        private E[] data;
        private int size = 0;

        public ArrayStack() {
            this(CAPACITY);
        }

        public ArrayStack(int capacity) {
            data = (E[]) new Object[capacity];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(E e) throws IllegalStateException {
            if (size() == data.length) {
                throw new IllegalStateException("Stack is full");
            } else {
                data[size++] = e;
            }
        }

        public E top() {
            if (isEmpty()) {
                return null;
            } else {
                return data[size];
            }
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            } else {
                E e = data[size];
                data[size] = null;
                size--;
                return e;
            }
        }
    }
}

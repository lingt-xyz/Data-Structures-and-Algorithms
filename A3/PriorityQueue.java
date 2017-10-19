/**
 * Created by Ling Tan on 2017-03-16.
 */
public class PriorityQueue {
    private static int capacity = 10;//initial size of the array
    private State state = State.Min;
    private Entry[] array = new Entry[capacity];
    private int size = 0;

    /**
     * Removes and returns the entry (a key, value pair) with the smallest or biggest key,
     * depending on the current state of the priority queue (either Min or Max).
     *
     * @return
     */
    public Entry remove() {
        if (isEmpty()) {//is pq is empty
            return null;
        }
        Entry entry = array[0];
        array[0] = array[size - 1];//move the last node to be the root
        array[size - 1] = null;//remove last node
        size--;
        if (!isEmpty()) {
            downHeap(0);
        }
        return entry;
    }

    private void downHeap(int index) {
        int leftIndex = 2 * (index + 1) - 1;
        int rightIndex = leftIndex + 1;
        int minIndex;
        int maxIndex;
        if (state == State.Min) {
            if (rightIndex >= size()) {//no right child
                if (leftIndex >= size()) {//no left child
                    return;
                } else {
                    minIndex = leftIndex;
                }
            } else {
                if (array[leftIndex].getKey() <= array[rightIndex].getKey()) {
                    minIndex = leftIndex;
                } else {
                    minIndex = rightIndex;
                }
            }
            if (array[index].getKey() > array[minIndex].getKey()) {//swap the value
                Entry tmp = array[minIndex];
                array[minIndex] = array[index];
                array[index] = tmp;
                downHeap(minIndex);
            }
        } else {
            if (rightIndex >= size()) {
                if (leftIndex >= size()) {
                    return;
                } else {
                    maxIndex = leftIndex;
                }
            } else {
                if (array[leftIndex].getKey() >= array[rightIndex].getKey()) {
                    maxIndex = leftIndex;
                } else {
                    maxIndex = rightIndex;
                }
            }
            if (array[index].getKey() < array[maxIndex].getKey()) {
                Entry tmp = array[maxIndex];
                array[maxIndex] = array[index];
                array[index] = tmp;
                downHeap(maxIndex);
            }
        }

    }

    /**
     * Insert the (k,v) entry which is a key(k), value(v) pair to the priority queue.
     *
     * @param entry
     */
    public void insert(Entry entry) {
        if (size() == capacity) {//pq is full
            capacity *= 2;
            Entry[] new_array = new Entry[capacity];
            for (int i = 0; i < size; i++) {
                new_array[i] = array[i];
            }
            array = new_array;
        }
        array[size] = entry;//insert at the end
        upheap(size);
        size++;
    }

    private void upheap(int index) {

        if (index != 0) {
            int parentIndex = index / 2;
            if (state == State.Min) {
                if (array[parentIndex].getKey() > array[index].getKey()) {
                    Entry tmp = array[parentIndex];
                    array[parentIndex] = array[index];
                    array[index] = tmp;
                    upheap(parentIndex);
                }
            } else {
                if (array[parentIndex].getKey() < array[index].getKey()) {
                    Entry tmp = array[parentIndex];
                    array[parentIndex] = array[index];
                    array[index] = tmp;
                    upheap(parentIndex);
                }
            }

        }
    }

    /**
     * Returns the top entry (with the minimum or the maximum key,
     * depending on whether it is a Min- or Max-priority queue, without removing the entry.
     *
     * @return
     */
    public Entry top() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

    /**
     * Transforms a min- to a max-priority queue or vice versa.
     */
    public void toggle() {
        if (state == State.Min) {
            switchToMax();
        } else {
            switchToMin();
        }
    }

    /**
     * Transforms a max- to a min-priority queue; else leave unchanged.
     */
    public void switchToMin() {
        if (state == State.Max) {
            reverseArray();
            state = State.Min;
        }
    }

    /**
     * Transforms a min- to a max-priority queue; else leave unchanged.
     */
    public void switchToMax() {
        if (state == State.Min) {
            reverseArray();
            state = State.Max;
        }
    }

    private void reverseArray() {
        Entry[] new_array = new Entry[capacity];
        int step = size();
        for (int i = 0; i < step; i++) {
            new_array[step - i - 1] = this.remove();
        }
        array = new_array;
        size = step;
    }

    /**
     * Returns the current state (Min or Max) of the priority queue.
     *
     * @return
     */
    public String state() {
        return state.toString();
    }

    /**
     * Returns true if the priority queue is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current number of entries in the priority queue
     *
     * @return
     */
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append("==>");
            }
            sb.append("[key:" + array[i].key + ", value:\"" + array[i].value + "\"]");
        }
        return sb.toString();
    }

    private enum State {Min, Max}

    public static class Entry {
        private Integer key;
        private String value;

        public Entry(Integer k, String v) {
            this.key = k;
            this.value = v;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String toString(){
            return "[key:" + key + ", value:\"" + value + "\"]";
        }
    }


}

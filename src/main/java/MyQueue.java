import java.util.*;

public class MyQueue<E> extends MyLinkedList<E> {
    transient Object[] elements;

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        elements = new Object[16 + 1];
    }

    public MyQueue(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public E peek() {
        E element = get(0);
        return element;
    }

    public E poll() {
        E element = get(0);
        remove(0);
        return element;
    }

}

class TestMyQueue {
    public static void main(String[] args) {
        MyQueue someQueue = new MyQueue(Arrays.asList("Max", "Jonathan", "Sam"));
        System.out.println("someList = " + someQueue);
        someQueue.add("Jay");
        System.out.println("someList = " + someQueue);
        System.out.println("someQueue.peek() = " + someQueue.peek());
        System.out.println("someQueue.poll() = " + someQueue.poll());
        System.out.println("someList = " + someQueue);
        someQueue.remove(0);
        System.out.println("someList = " + someQueue);
        System.out.println("someList = " + someQueue.size());
        System.out.println("someList = " + someQueue.get(0));
        someQueue.clear();
        System.out.println("someList = " + someQueue);
    }
}

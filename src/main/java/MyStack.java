import java.util.*;

public class MyStack<E> extends MyLinkedList<E> {
    transient Object[] elements;

    /**
     * Constructs an empty queue.
     */
    public MyStack() {
        elements = new Object[16 + 1];
    }

    public MyStack(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public E peek() {
        E element = get(size-1);
        return element;
    }

    public E pop() {
        E element = get(size-1);
        remove(size-1);
        return element;
    }

    public E push(E element) {
        linkFirst(element);
        return element;
    }

}

class TestMyStack {
    public static void main(String[] args) {
        MyStack someStack = new MyStack(Arrays.asList("Max", "Jonathan", "Sam"));
        System.out.println("someStack = " + someStack);
        someStack.add("Jay");
        System.out.println("someStack = " + someStack);
        System.out.println("someStack.peek() = " + someStack.peek());
        System.out.println("someStack.push() = " + someStack.push("Ann"));
        System.out.println("someStack = " + someStack);
        System.out.println("someStack.poll() = " + someStack.pop());
        System.out.println("someStack = " + someStack);
        someStack.remove(0);
        System.out.println("someStack = " + someStack);
        System.out.println("someStack = " + someStack.size());
        System.out.println("someStack = " + someStack.get(0));
        someStack.clear();
        System.out.println("someList = " + someStack);
    }
}

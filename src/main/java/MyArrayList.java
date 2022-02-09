import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;


/**
 * add(Object value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(int index) возвращает элемент под индексом
 */

public class MyArrayList<E> extends AbstractList<E> {

    /**
     * The default capacity initialization.
     */
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * The size of MyArrayList
     */
    private int size;

    /**
     * The storage of array elements.
     */
    private Object[] elementData;

    /**
     * The constructor for initialization with size
     */
    public MyArrayList(int size) {
        this.size = size;
        if (size > 0) {
            this.elementData = new Object[size];
        } else if (size == 0) {
            this.elementData = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Size: "+
                    size);
        }
    }

    /**
     * The constructor for initialization with elements
     */
    public MyArrayList(Collection<? extends E> elements) {
        this.elementData = elements.toArray();
        this.size = elements.toArray().length;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Method to increase the capacity of list
     */
    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return elementData = Arrays.copyOf(elementData, minCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    /**
     * Adding element at the end of list
     */
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    public boolean add(E e) {
        add(e, elementData, size);
        return true;
    }

    /**
     * Remove element by index
     */
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
//        es[size = newSize] = null;
    }

    /**
     * Method to remove all elements
     */
    public void clear() {
        modCount++;
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

}

class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<String> testingArray = new MyArrayList<>(Arrays.asList("Max", "Jonathan", "Sam"));
        System.out.println("testingArray.toString() = " + testingArray.toString());
        testingArray.add("Roy");
        System.out.println("testingArray.toString() = " + testingArray.toString());
        testingArray.remove(1);
        System.out.println("testingArray.toString() = " + testingArray.toString());
        testingArray.clear();
        System.out.println("testingArray.toString() = " + testingArray.toString());
    }
}
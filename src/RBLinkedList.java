
public class RBLinkedList<R> {

    private Node<R> first;
    private Node<R> last;
    private int size;
    private int i = 0;

    public String toStringRec() {
        Node tmp = first;
        String str = "[ ";
        return recToString(tmp, str, i);
    }

    private String recToString(Node current, String str, int i) {
        return i != size ? recToString(current.next, str + current.value + ", ", ++i) : new StringBuilder(str).deleteCharAt(str.length() - 2).append("]").toString();
    }

    public void removeByIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
       delete(removeByIndexRec(first, index, i + 1));
    }

    private Node<R> removeByIndexRec(Node<R> current, int index, int i) {
        return index == i ? current : removeByIndexRec(current.next, index, ++i);
    }

    public void removeByValue(R value) {
       removeByValueRec(first, value);
    }

    private void removeByValueRec(Node<R> current, R value) {
        if (current.value.equals(value)) {
            delete(current);
        } else {
            removeByValueRec(current.next, value);
        }
    }

    private void delete(Node<R> trash) {
        if (trash.previous == null) {
            first = trash.next;
        } else {
            trash.previous.setNext(trash.next);
            trash.previous = null;
        }
        if (trash.next == null) {
            last = trash.previous;
        } else {
            trash.next.setPrevious(trash.previous);
            trash.next = null;
        }
        trash.value = null;
        size--;
        }

    public void set(int index, R value) {
        if (index == size + 1) {
            add(value);
        } else if (index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        removeByIndexRec(first, index, i + 1).setValue(value);
    }

    public R get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> tmp = first;
        return getRec(tmp, index, ++i);
    }

    private R getRec(Node<R> current, int index, int i) {
        return index != i ? getRec(current.next, index, ++i) : current.value;
    }

    public void add(int index, R value) {
         if (index > size || index < 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> node = new Node<>();
        Node<R> tmp = addRec(first, index, i + 1);
        if (tmp.previous == null) {
            prepend(value);
        } else if (tmp.next == null || index == size) {
            add(value);
        } else {
            tmp.previous.setNext(node);
            tmp.setPrevious(node);
            node.setNext(tmp);
            node.setValue(value);
            size++;
        }
    }

    private Node<R> addRec(Node<R> current, int index, int i) {
        return index != i ? addRec(current.next, index, ++i) : current;
    }

    public void prepend(R value) {
        if (size == 0) {
            last = first = new Node<>(null, null, value);
            size++;
            return;
        }
        first = first.previous = new Node<>(first, null, value);
        size++;
    }

    public void add(R value) {
        if (size == 0) {
            last = first = new Node<>(null, null, value);
            size++;
            return;
        }
        last = last.next = new Node<>(null, last, value);
        size++;
    }

    public int getSize() {
        return size;
    }

    private class Node<R> {

        Node<R> next;
        Node<R> previous;
        R value;

        public Node() {
        }

        public Node(Node<R> next, Node<R> previous, R value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public Node<R> getNext() {
            return next;
        }

        public void setNext(Node<R> next) {
            this.next = next;
        }

        public Node<R> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<R> previous) {
            this.previous = previous;
        }

        public R getValue() {
            return value;
        }

        public void setValue(R value) {
            this.value = value;
        }
    }
}
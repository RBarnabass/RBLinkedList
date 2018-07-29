
public class RBLinkedList<R> {

    private Node<R> first;
    private Node<R> last;
    private int size;

    @Override
    public String toString() {
        return recToString(first, "[ ");
    }

    private String recToString(Node<R> current, String str) {
        return current.next != null ? recToString(current.next, str + current.value + ", ") : str + current.value + " ]";
    }

    public void removeByIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
       delete(getPosition(first, index, 0));
    }

    public void removeByValue(R value) {
       removeByValueRec(first, value);
    }

    private void removeByValueRec(Node<R> current, R value) {
        if (current.value.equals(value)) {
            delete(current);
        } else if (current.next != null) {
            removeByValueRec(current.next, value);
        } else {
            System.err.println("There is not value like that");
            return;
        }
    }

    private void delete(Node<R> trash) {
        Node<R> next = trash.next;
        Node<R> previous = trash.previous;
        if (previous != null) {
            previous.next = next;
        } else {
            first = next;
        }
        if (next != null) {
            next.previous = previous;
        }
        size--;
    }

    public void set(int index, R value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        getPosition(first, index, 0).setValue(value);
    }

    public R get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return getPosition(first, index, 0).value;
    }

    public void insert(int index, R value) {
         if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
             add(value);
         } else {
             Node<R> node = new Node<>(null, null, value);
             Node<R> tmp = getPosition(first, index, 0);
             if (tmp.previous == null) {
                 prepend(value);
             }  else {
                 Node<R> previous = tmp.previous;
                 previous.setNext(node);
                 tmp.setPrevious(node);
                 node.setNext(tmp);
                 node.setPrevious(previous);
                 size++;
             }
         }
    }

    private Node<R> getPosition(Node<R> current, int index, int i) {
        return index != i ? getPosition(current.next, index, ++i) : current;
    }

    public void prepend(R value) {
        if (size == 0) {
            add(value);
        }
        first.previous = new Node<>(first, null, value);
        first = first.previous;
        size++;
    }

    public void add(R value) {
        if (size == 0) {
            last = first = new Node<>(null, null, value);
            size++;
            return;
        }
        last.next = new Node<>(null, last, value);
        last = last.next;
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
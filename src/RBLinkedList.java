
public class RBLinkedList<R> {

    private Node<R> first;
    private Node<R> last;
    private int size;

    @Override
    public String toString() {
        Node tmp = first;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (int i = 0; i < size; i++) {
            if (tmp.value != null) {
                sb = sb.append(tmp.getValue()).append(", ");
            }
            tmp = tmp.next;
        }
        return sb.deleteCharAt(sb.length() - 2).append("]").toString();
    }

    public void remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> tmp = first;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                tmp.previous.setNext(tmp.next);
                tmp.next.setPrevious(tmp.previous);
                size--;
            }
            tmp = tmp.next;
        }
    }

    public void remove(R value) {
        Node<R> tmp = first;
        for (int i = 1; i <= size; i++) {
            if (tmp.getValue().equals(value)) {
                tmp.previous.setNext(tmp.next);
                tmp.next.setPrevious(tmp.previous);
                size--;
            }
            tmp = tmp.next;
        }
    }

    public R get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> tmp = first;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void set(int index, R value) {
        if (index == size + 1) {
            add(value);
        } else if (index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> tmp = first;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                tmp.setValue(value);
            }
            tmp = tmp.next;
        }
    }

    public void add(int index, R value) {
        if (index == size + 1) {
            add(value);
        } else if (index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<R> tmp = first;
        if (index == size) {
            add(value);
        } else {
            for (int i = 1; i < size; i++) {
                if (i == index) {
                    Node<R> node = new Node<>(tmp, tmp.previous, value);
                    tmp.setPrevious(node);
                    node.previous.setNext(node);
                    size++;
                    return;
                }
                tmp = tmp.next;
            }
        }
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

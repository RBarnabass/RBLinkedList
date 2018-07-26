import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();

        RBLinkedList list = new RBLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.prepend(0);
        list.add(3, 3.5);

        System.out.println(list.toString());
        /*System.out.println(list.get(2));
        list.set(2, -2);
        System.out.println(list.get(2));
        System.out.println();*/
        System.out.println();
        list.remove(5);
        list.remove(3.5);
        System.out.println(list.get(3));
        System.out.println(list.getSize());
        System.out.println(list.toString());
    }
}

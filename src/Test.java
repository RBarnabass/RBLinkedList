
public class Test {

    public static void main(String[] args) {


        RBLinkedList list = new RBLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.prepend(0);
        list.add(1, 3.5);

        System.out.println();
        System.out.println(list.toString());
        //list.removeByIndex(1);
        list.set(6, -9);
        System.out.println(list.toString());
        System.out.println(list.get(6));



    }
}

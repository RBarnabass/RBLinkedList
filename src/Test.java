
public class Test {

    public static void main(String[] args) {


        RBLinkedList list = new RBLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.prepend(-10);
        list.insert(1,0);
        list.set(3,5);

        System.out.println(list.toString());
        System.out.println();
        //System.out.println(list.get(0));
        //list.removeByValue(0);
        list.removeByIndex(0);
        System.out.println(list.toString());

    }
}

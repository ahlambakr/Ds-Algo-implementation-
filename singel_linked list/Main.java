
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertLast(10);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);

        // list.insertAfter(list.find(30),500);
       // list.insertBefore(list.find(10),500);
        list.deleteNode(list.find(40));

        list.PrintList();





    }
}
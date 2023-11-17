// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       LinkedList list = new LinkedList();
       list.insertLast(1);
       list.insertLast(2);
       list.insertLast(3);
       list.PrintList();
       list.insertAfter(list.find(2),40);
       list.PrintList();
       list.deleteNode(list.find(2));
       list.PrintList();
       list.insertBefore(list.find(40),100);
       list.PrintList();





    }
}
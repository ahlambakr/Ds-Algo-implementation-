public class Main {
    public static void main(String[] args) {




        //System.out.println("Hello world!");
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        tree.Insert(14);
        tree.Insert(15);
        tree.Insert(16);
        tree.Insert(17);
        tree.Insert(18);
        tree.Insert(19);
        tree.Insert(20);

    //    System.out.println(tree.Height()) ;
        tree.preOrder();
        

    }
}
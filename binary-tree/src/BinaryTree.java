

import java.util.LinkedList;
import java.util.Queue;



public class BinaryTree <Tdata> {

    //   public TreeNode <Tdata> root ;
    TreeNode<Tdata> Root;

    public void Insert(Tdata _data) {
        TreeNode newNode = new TreeNode<>(_data);
        if (this.Root == null) {
            this.Root = newNode;
            return ;
        }
        Queue<TreeNode<Tdata>> q = new LinkedList<>();
        q.add(this.Root);
        while (!q.isEmpty()){

            TreeNode  currentNode = q.poll() ;
          if (currentNode.Left == null ){
              currentNode.Left = newNode ;
             break;
          }
          else  {
           q.add((TreeNode<Tdata>) currentNode.Left) ;

          }
          if (currentNode.Right == null ){
              currentNode.Right = newNode;
             break;
          }
          else {
              q.add((TreeNode<Tdata>) currentNode.Right) ;
          }

        }



    }

    public int Height (){

   return  internalHeight((this.Root));
    }

    int internalHeight (TreeNode node ){
    if (node == null ) return 0 ;
    return  1+ Math.max( internalHeight((TreeNode) node.Left) ,internalHeight((TreeNode) node.Right));
    }
  public void preOrder () {
        internalpreOrder(this.Root);
        System.out.print("");
  }
  void internalpreOrder (TreeNode node ){
        if(node == null ) return;
        System.out.println(node.Data + " -> " );
        internalpreOrder((TreeNode) node.Left);
        internalpreOrder((TreeNode) node.Right);
  }
    public void InOrder () {
        internalInOrder(this.Root);
        System.out.print("");
    }
    void internalInOrder (TreeNode node ){
        if(node == null ) return;

        internalInOrder((TreeNode) node.Left);
        System.out.println(node.Data + " -> " );
        internalInOrder((TreeNode) node.Right);
    }
    public void postOrder () {
        internalpostOrder(this.Root);
        System.out.print("");
    }
    void internalpostOrder (TreeNode node ){
        if(node == null ) return;

        internalpostOrder((TreeNode) node.Left);
        internalpostOrder((TreeNode) node.Right);
        System.out.println(node.Data + " -> " );
    }

    



}

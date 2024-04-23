
public class LinkedListIterator {
    private LinkedListNode currentNode ;
    LinkedListIterator(){
        this.currentNode =null;
    }
    LinkedListIterator(LinkedListNode node ){
        this.currentNode = node;
    }
    int data (){
        return this.currentNode.data;
    }
    LinkedListIterator next(){
        this.currentNode = this.currentNode.next;
        return this;
    }

    LinkedListNode Current (){
        return  this.currentNode;
    }

}
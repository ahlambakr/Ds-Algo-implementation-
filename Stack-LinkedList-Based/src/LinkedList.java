public class LinkedList {
    LinkedListNode head ;
    LinkedListNode tail ;
    public void  insertLast (int data ){
        LinkedListNode newNode = new LinkedListNode(data) ;
        if(this.head==null){
            head=newNode;
            tail=newNode;
        }
        else {
            this.tail.next = newNode;
            tail=newNode ;
        }
    }
    public LinkedListIterator Begin() {
        LinkedListIterator itr = new LinkedListIterator(this.head);
        return itr;
    }
    public LinkedList PrintList() {
        for (LinkedListIterator itr = this.Begin(); itr.Current() != null; itr.next()) {
            System.out.print(itr.data() + " -> ");
        }


        return null;
    }



    public LinkedListNode  find(int _data) {
        for (LinkedListIterator itr = this.Begin(); itr.Current() != null; itr.next()) {
            if(_data == itr.data())  return itr.Current();
        }
        return null;

    }
    public LinkedListNode  findParent(LinkedListNode node ) {
        for (LinkedListIterator itr = this.Begin(); itr.Current() != null; itr.next()) {
            if(itr.Current().next == node )  return itr.Current();
        }
        return null;

    }


    void insertAfter (LinkedListNode node , int _date ){
        LinkedListNode newNode = new LinkedListNode(_date);
        if (node.next==null){
            this.tail=newNode;

        }
        else {
            newNode.next = node.next;
            node.next = newNode;

        }
    }
    void insertBefore (LinkedListNode node , int _data){
        LinkedListNode newNode =new LinkedListNode(_data);
        newNode.next=node;
        LinkedListNode parent = this.findParent(node);
        if(parent == null ) this.head=newNode;
        else
            parent.next =newNode;


    }
    void deleteNode (LinkedListNode node ){
        if ( this.head == this.tail ) {
            this.head=null;
            this.tail=null;
        }
        else if (node == this.head ) this.head=node.next;
        else {
            LinkedListNode parent = this.findParent(node);
            if (this.tail==node) this.tail = parent ;
            else
                parent.next=node.next;
        }

    }

 void insertFirst (int _data ){
     LinkedListNode newNode =new LinkedListNode(_data);
     if(this.head == null){
         this.head = newNode ;
         this.tail = newNode ;
     }
     else {
         newNode.next = this.head;
         this.head=newNode;
     }

 }
 void deleteHead () {
        if(this.head == null ) return;
        this.head = this.head.next ;
 }

}
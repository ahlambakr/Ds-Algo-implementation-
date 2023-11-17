public class LinkedList {
    LinkedListNode head ;
    LinkedListNode tail ;
    public void  insertLast (int date ){
        LinkedListNode newNode = new LinkedListNode(date) ;
        if(this.tail==null){
            this.head=newNode;
            this.tail=newNode;
        }
        else {
            newNode.back=this.tail;
            this.tail.next=newNode;
            this.tail=newNode;
        }
    }
    public LinkedListIterator Begin() {
        LinkedListIterator itr = new LinkedListIterator(this.head);
        return itr;
    }
    public void PrintList() {
        for (LinkedListIterator itr = this.Begin(); itr.Current() != null; itr.next()) {
            System.out.print(itr.data() + " -> ");
        }
        System.out.println();
    }

    public LinkedListNode  find(int _data) {
        for (LinkedListIterator itr = this.Begin(); itr.Current() != null; itr.next()) {
            if(_data == itr.data())  return itr.Current();
        }
        return null;

    }


    void insertAfter (LinkedListNode node , int _date ){
        LinkedListNode new_node = new LinkedListNode(_date);
        new_node.next = node.next;
        new_node.back=node;
        node.next=new_node;
        if(new_node.next==null){
            this.tail = new_node ;

        }
        else {
            new_node.next.back =new_node ;

        }


    }
    void insertBefore (LinkedListNode node , int _data){
          LinkedListNode new_node =new LinkedListNode(_data);
          new_node.next=node;
          if(node==this.head){
              head=new_node;
          }
          else {
              node.back.next=new_node;
          }


    }

    void deleteNode (LinkedListNode node ){
        if(this.head==this.tail){
            this.head = null ;
            this.tail = null ;
        }
        //head
       else if (node.back == null ){
            this.head=node.next;
            node.next.back = null;

        }
       //back
         else if (node.next==null){
            this.tail=node.back;
            node.back.next=null;
        }
        else {
         node.back.next=node.next;
         node.next.back=node.back;
        }
    }

}


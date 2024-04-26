public class Queue {

    LinkedList data_list ;
    Queue () {
  data_list = new LinkedList() ;
    }

    void enqueue ( int _data ){
        data_list.insertLast(_data);
    }

    int dequeue (  ){
        int node_data = data_list.head.data ;
        data_list.deleteHead();
        return  node_data ;
    }
int peek () {
        if(data_list.head==null) return 0;
        return data_list.head.data ;
}
   void print() {
        data_list.PrintList() ;
   }

}


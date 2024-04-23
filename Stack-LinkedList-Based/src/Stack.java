public class Stack {

    private LinkedList dataList;


    public Stack () {
        this.dataList= new LinkedList() ;
    }

    void push(int _data) {
        this.dataList.insertFirst(_data);
    }
    int pop (){
        int head_date = this.dataList.head.data;

this.dataList.deleteHead();
return head_date;
    }
  int peak (){
        return this.dataList.head.data ;
  }
//  boolean isEmpty () {
 //return this.dataList.length <= 0 ;
  //}


   void  print(){
        this.dataList.PrintList();
    }
}

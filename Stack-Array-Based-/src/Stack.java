public class Stack {
    private int[] data_list;
    private int top_index;
    private int initial_size;
    private int current_size;

    Stack() {
        this.data_list  = new int [initial_size];
        this.top_index = -1;
        this.initial_size = 5 ;
       this.current_size= initial_size;

    }
    void resizeOrnot(){
        if( top_index >=  current_size -1 ) return ;
      int [] newArray = new int[ current_size +  initial_size ] ;
      // newArray =  data_list.clone();
        System.arraycopy(data_list, 0, newArray, 0, data_list.length);
        data_list = newArray;
        current_size =  initial_size ;


    }


    void push (int _data ) {
        resizeOrnot();

       data_list [ ++top_index ] =  _data ;

    }
    int peek () {
        if(top_index == -1) return  0 ;
        return data_list[top_index] ;
    }
    int pop () {if(top_index == -1) return  0 ;
      int head_data =  data_list[top_index] ;
      data_list[ top_index ] =0 ;
      top_index -- ;
      return  head_data ;
    }
 boolean IsEmpty(){
      if (top_index == -1) return  true ;
      else
          return  false ;
 }
 int size() {
        return  top_index+1;
 }
 void print() {
        for (int i = top_index ; i>=0 ; i-- ){
            System.out.println(data_list[i]);
        }
 }

}

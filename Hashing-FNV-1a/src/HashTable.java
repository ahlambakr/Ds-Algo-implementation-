

public class HashTable<K,V> {
     KeyValuPair [] entries;
     int intialSize ;
     int entriesCount ;
     public HashTable (){
         this.intialSize = 7;
         this.entriesCount = 0;
         this.entries = new  KeyValuPair[this.intialSize] ;

     }
    public int getHash(String key) {
       // int  FnvOffsetBasis = 2166136261;
        long FnvOffsetBasis = 2166136261L;


        int FNVPrime = 16777619;

        String keyStr = key;
        char[] data = keyStr.toCharArray();
        long hash = FnvOffsetBasis; // Change data type to long

        for (int i = 0; i < data.length; i++) {
            hash = hash ^ data[i];
            hash = hash * FNVPrime;
        }

        System.out.println("[hash] " + keyStr + " " + hash + " " + Long.toHexString(hash) + " "
                + hash % this.entries.length);

        return (int)(hash % this.entries.length ); // Cast the result back to int
    }

        public void ResizeOrNot () {
            if (this.entriesCount < this.entries.length) {
                return;
            }
            int NewSize = this.entries.length * 2;
            KeyValuPair[] entriesCopy = new KeyValuPair[this.entries.length];
            int[] copiedArray = new int[this.entries.length];
            System.arraycopy(this.entries, 0, entriesCopy, 0, this.entries.length);

            this.entries = new KeyValuPair[NewSize];
            this.entriesCount =0 ;
            for (int i = 0; i < entriesCopy.length; i++)
                if (entriesCopy[i] == null) {
                    try {
                        this.AddToEntries((K) entriesCopy[i].key, (V) entriesCopy[i].value);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        }

        public void Set (K key , V value) throws Exception {
          this.ResizeOrNot();
          this.AddToEntries(key, value);
        }
        public V Get  (K _key) {
            int hash = this.getHash((String) _key);
            if (this.entries[hash] != null && this.entries[hash].key != _key) {
                hash = this.CollisionHandling(_key, hash, false);
            }
            if (hash == -1 || this.entries[hash] == null) {
                return (V) "NOT FOUNDED";
            }
          if (this.entries[hash].key == _key) {
              return (V) this.entries[hash].value;
          }
          else
              return (V) "NOT FOUNDED" ;

        }

        int CollisionHandling (K key , int hash , boolean Set) {
         int newHash ;
         for (int i = 1 ;i<this.entries.length ; i++ ){
             newHash =  (hash + i ) % this.entries.length ;
            if(Set && (  this.entries [newHash] == null || this.entries[newHash].key == key) )
                return newHash ;
            else if (!Set && (this.entries[newHash].key==key )) return  newHash ;

         }
         return  -1;
        }
        public  int Size() {
         return this.entriesCount ; }

    public  void Print () {
   for (int  i = 0; i<this.entries.length ;i++) {
       if (this.entries[i] == null) continue;
       else {
           System.out.println(this.entries[i].key + " " + this.entries[i].value);
       }
   }
     }

      /*void AddToEntries (K key ,V value) throws  Exception{
         int hash = this.getHash((String) key) ;
         if (this.entries[hash] != null && this.entries[hash].key != key ){
             hash =this.CollisionHandling(key ,hash ,true) ;

         }
         if(hash == -1 ) try {

             throw  new Exception("invalid hash table") ;
          }
         if (this.entries[hash] == null ){
             KeyValuPair newPair = new KeyValuPair<>(key, value);
            this.entries[hash] = newPair ;
            this.entriesCount ++ ;

         }
 else if (this.entries[hash].key == key ) {
     this.entries[hash].value = value ;
         }
 else{
     throw  new Exception("invalid hash table ");
         }
     } */

    void AddToEntries(K key, V value) throws Exception {
        int hash = this.getHash( (String) key);

        if (this.entries[hash] != null && !this.entries[hash].key.equals(key)) {
            hash = this.CollisionHandling(key, hash, true);
        }

        if (hash == -1) {
            throw new Exception("Invalid hash table");
        } else if (this.entries[hash] == null) {
            KeyValuPair<K, V> newPair = new KeyValuPair<>(key, value);
            this.entries[hash] = newPair;
            this.entriesCount++;
        } else if (this.entries[hash].key.equals(key)) {
            this.entries[hash].value = value;
        } else {
            throw new Exception("Invalid hash table");
        }
    }






}

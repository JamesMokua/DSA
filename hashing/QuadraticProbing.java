package hashing;

import java.util.ArrayList;

public class QuadraticProbing {
    String[] hashTable;
    int usedCellNumber;

    // Constructor
    QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    // create a hash function that gives us a hash value
    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }
    //calculating if we need new hashmap or not
       // The Load factor is a measure that decides when to increase the HashMap
    // capacity to maintain the get() and put() operation complexity of O(1).
    public double getLoadFactor() {
        //calculate loadfactor
        //initial capacity of the hashmap*Load factor of the hashmap.  
        double loadFactor = usedCellNumber * 1.0 / hashTable.length;
        return loadFactor;
    }
      // Rehash(create a hashtable that is two times the original size)
      public void rehashKeys(String word){
        ArrayList<String> data = new ArrayList<String>();
        for(String s : hashTable){
            if(s != null){
                data.add(s);
            }
            data.add(word);
            hashTable = new String[hashTable.length * 2];
            for(String t : data){
                //INsert in Hash Table
                insertHashTable(t);
            }
        }

    }

    public void insertHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word, hashTable.length);
            int counter = 0;
            for(int i = index; i < index+hashTable.length;i++){
                int newIndex = (index + (counter*counter)) % hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println(word + " has been inserted successfully");
                    break;
                }else{
                   System.out.println(newIndex+" is already occupied. Trying next one..."); 
                }
                counter++;
            }
        }
        usedCellNumber++;
    }
    public void displayHashTable(){
        if(hashTable == null){
            System.out.println("HashTable does not exist");
            return;
        }else{
            System.out.println("---------HashTable----------");
            for(int i = 0; i<hashTable.length; i++){
                System.out.println("Index "+i+", key: "+hashTable[i]);
            }

        }
    }
    public boolean searchHashTable(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = index; i< index+hashTable.length;i++){
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                System.out.println(word+" found at location: "+newIndex);
                return true;
            }
        }
        System.out.println(word+" not found in HashTable");
        return false;
    }
    public void deleteKeyHashTable(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = index; i < index+hashTable.length;i++){
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                hashTable[newIndex] = null;
                System.out.println(word+" has been deleted from hash table");
                return;
            }
        } 
        System.out.println(word+" not found in hash table");
    }
    public static void main(String[] args){
        QuadraticProbing qp = new QuadraticProbing(13);
        qp.insertHashTable("The");
        qp.insertHashTable("quick");
        qp.insertHashTable("brown");
        qp.insertHashTable("fox");
        qp.insertHashTable("over");
        qp.insertHashTable("lazy");
        qp.displayHashTable();

    }
}

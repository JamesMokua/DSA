package hashing;

import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size) {
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

    // Insert in hashTable
    public void insertHashTable(String word){
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75){//determines whether to rehash or not
            rehashKeys(word);
        }else{
            int index =modASCIIHashFunction(word, hashTable.length);
            for(int i = index; i < hashTable.length; i++){
                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] == null){
                hashTable[newIndex] = word;
                System.out.println("The " + word + " successfully inserted at location: "+newIndex);
                break;
                }else{
                    System.out.println(newIndex+" is already occupied. Trying next empty cell");
                }
            }
        }
        usedCellNumber++;

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

    public static void main(String[] args) {
     LinearProbing lp = new LinearProbing(13);
     lp.insertHashTable("The");
     lp.insertHashTable("quick");
     lp.insertHashTable("brown");
     lp.insertHashTable("fox");
     lp.insertHashTable("over");
    //  lp.deleteKeyHashTable("fox");
     lp.displayHashTable();
    }
}

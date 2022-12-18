package hashing;
import java.util.ArrayList;
import java.util.LinkedList;


public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;
   //initialize a hashtable of certain size
    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }
    //create a hash function that gives us a hash value
    public int modASCIIHashFunction(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum=0,i=0; i <word.length();i++){
            sum = sum + ch[i];
        }
        return sum % M;
    }
    //insertion method in direct chaining
    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex] == null){//we dont have any value in that cell
            hashTable[newIndex] = new LinkedList<String>();//create linkedlist 
            hashTable[newIndex].add(word);//add the word to the linkedlist

        }else{
            hashTable[newIndex].add(word);//if we already have a value just add the value at the end of the 
            //created linked list
        }
    }

    //search method in direct chaining
    public boolean searchHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)){
            System.out.println(word + " found in HashTable at location: "+newIndex);
            return true;
        }else{
            System.out.println(word + " not found in HashTable");
            return false;
        }
    }
    //delete method
    public void deleteKeyHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);  
        boolean result = searchHashTable(word);
        if(result == true){
            hashTable[newIndex].remove(word);
            System.out.println(word + " has been deleted from HashTable");
        }
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
    public static void main(String[] args){
        DirectChaining dc =  new DirectChaining(13);
        dc.insertHashTable("The");
        dc.insertHashTable("quick");
        dc.insertHashTable("brown");
        dc.insertHashTable("fox");
        dc.insertHashTable("over");
        dc.deleteKeyHashTable("ox");
        dc.displayHashTable();
    }
}

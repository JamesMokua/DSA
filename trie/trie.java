package trie;

import java.util.HashMap;
import java.util.Map;

public class trie {
    public class trieNode {
        Map<Character, trieNode> children;
        boolean endOfString;

        public trieNode() {
            children = new HashMap<>();
            endOfString = false;
        }
    }

    private trieNode root;

    public trie() {
        root = new trieNode();
        System.out.println("The Trie has been created");
    }
    public void insert(String word){
        trieNode current = root;
        //check if the word is already in the trie
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            trieNode node = current.children.get(ch);//assign the new node to the current character
            if(node == null){//if the character doesnt match any in the Trie we add it to the trie
                node = new trieNode();
                current.children.put(ch, node);
            }
            current = node;//continue to the next node
        }
        current.endOfString = true;//set end of string to true upon going through the entire word
        System.out.println("Successfully inserted "+ word + " in Trie");
    }

    // Search for a word in Trie

    public boolean search(String word){
        trieNode currentNode = root;//keep track of currentNode
        //loop through the word
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            trieNode node = currentNode.children.get(ch);
            if(node == null){
                System.out.println("Word "+ word+ " does not exist in Trie");
                return false;
            }
            currentNode = node;//continue to the next node
        }
       if( currentNode.endOfString == true){
        System.out.println("Word "+ word+ " exists in Trie");
        return true;
       }else{
        System.out.println("This word "+word+" is a prefix of another word");
       }
       return currentNode.endOfString;
    }

    public static void main(String[] args) {
        trie t = new trie();
        // t.insert("API");
        t.insert("APIS");
        t.search("API");
        t.search("APIS");
        t.search("John");
    }
}

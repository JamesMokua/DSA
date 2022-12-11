package binarytree;
import java.util.ArrayList;

public class Treenode {
     String data;
     ArrayList<Treenode> children;

     public Treenode(String data){
        this.data = data;
        this.children = new ArrayList<Treenode>();
     }
     public void addChild(Treenode node){
        this.children.add(node);
     }
     public String print(int level){
        String ret;
        ret = "  ".repeat(level)+data+"\n";
        for(Treenode node : this.children){
            ret += node.print(level+1);
        }
         return ret;
     }

     public static void main(String[] args){
        Treenode drinks = new Treenode("Drinks");
        Treenode hot = new Treenode("Hot");
        Treenode cold = new Treenode("Cold");
        Treenode tea = new Treenode("Tea");
        Treenode coffee = new Treenode("Coffee");
        Treenode wine = new Treenode("Wine");
        Treenode beer = new Treenode("Beer");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(wine);
        cold.addChild(beer);
        System.out.println(drinks.print(0));
     }
}

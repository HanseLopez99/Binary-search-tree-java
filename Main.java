
public class Main{
    public static void main(String arg[]){
		BinarySearchTree<String> b = new BinarySearchTree<String>();
		b.insert("dog");b.insert("homework");
		b.insert("house");b.insert("town");b.insert("woman");b.insert("yes");
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find("homework"));
		System.out.println("Delete Node with no children (2) : " + b.delete("yes"));		
		b.display(b.getRoot());
		System.out.println("\n Delete Node with one child (4) : " + b.delete("dog"));		
		b.display(b.getRoot());
		System.out.println("\n Delete Node with Two children (10) : " + b.delete("10"));		
		b.display(b.getRoot());
	}
}
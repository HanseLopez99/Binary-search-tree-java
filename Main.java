import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class Main{
    public static void main(String arg[]){
		BinarySearchTree<String> tree = new BinarySearchTree<String>(); //Creando nuevo BynarySearchTree<E>
        Association<String,String> assoc = new Association<String,String>(); //Creando Association<K,V> con key y value tipo String
        Map<String, String> map = null; //Creando nuevo Map
        Iterator<String> it = null; //Declarando Iterator
        String[] words = null;

        map = assoc.Reader();//Leyendo e interpretando el archivo dictionary.txt
        it = map.keySet().iterator();//Recibiendo asociaciones dentro de un Map tipo LinkedHashMap<String,String>

        //Insertando cada una de las asociaciones del al Arbol
		while(it.hasNext()){
            String key = it.next();
            tree.insert(key);           
        }

        //Recorriendo y mostrando las asociaciones in-Order
        System.out.println("________________________________________________________--");
    	System.out.println("                 Hoja de Trabajo 7");
    	System.out.println("________________________________________________________--\n");
        System.out.println("\n --In Order--\n");
        tree.displayInOrder(tree.root);//Mostrando in-Order
        System.out.println("");

        words = tree.readText();
        for(int n=0;n<words.length;n++){
            if(tree.find(words[n])){
                
            }else{

            }
        } 
	}
}
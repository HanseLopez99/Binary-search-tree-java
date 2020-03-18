/*Hansel Andre Lopez Montenegro 19026
Algoritmos y Estructura de datos
Hoja de trabajo 7
*/

import java.util.Map;
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
            key = key.toLowerCase();//Convirtiendo a minusculas
            tree.insert(key); //Metodo para insertar en el arbol           
        }

        //Recorriendo y mostrando las asociaciones in-Order
        System.out.println("________________________________________________________--");
    	System.out.println("                 Hoja de Trabajo 7");
    	System.out.println("________________________________________________________--\n");
        System.out.println("\n --Palabras del Diccionario In Order:\n");
        tree.displayInOrder(tree.root);//Metodo para mostrar in-Order
        System.out.println("");

        //Traduciendo texto.txt
        System.out.println("\n --Archivo de texto traducido:\n");
        words = assoc.readText();//Metodo para leer el archivo texto.txt y retornar palabras en un String[]
        assoc.translate(words, tree);//Metodo para traducir segun palabras del diccionario
        System.out.println("\n");
	}
}
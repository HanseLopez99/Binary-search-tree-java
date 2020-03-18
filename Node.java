/*Hansel Andre Lopez Montenegro 19026
Algoritmos y Estructura de datos
Hoja de trabajo 7

Referencia de sitio utilizado como guia para implementacion de Binary Search Tree (BST): 
https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
*/

public class Node<E>{
	String data;
	Node<E> left;
	Node<E> right;	
	public Node(String data){
		this.data = data;
		left = null;
		right = null;
	}
}
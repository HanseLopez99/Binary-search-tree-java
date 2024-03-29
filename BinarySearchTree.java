/*Hansel Andre Lopez Montenegro 19026
Algoritmos y Estructura de datos
Hoja de trabajo 7

Referencia de sitio utilizado como guia para implementacion de Binary Search Tree (BST): 
https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
*/

public class BinarySearchTree<E extends Comparable<E>> {
    public Node<E> root;
	public BinarySearchTree(){
		this.root = null;
    }
    
    public Node<E> getRoot(){
        return this.root;
    }

	public boolean find(String id){
		Node<E> current = root;
		while(current!=null){
			if(current.data.compareTo(id) == 0){
				return true;
			}else if(current.data.compareTo(id) > 0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(String id){
		Node<E> parent = root;
		Node<E> current = root;
		boolean isLeftChild = false;
		while(current.data.compareTo(id) != 0){
			parent = current;
			if(current.data.compareTo(id) > 0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node<E> successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node<E> getSuccessor(Node<E> deleleNode){
		Node<E> successsor =null;
		Node<E> successsorParent =null;
		Node<E> current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(String id){
		Node<E> newNode = new Node<E>(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node<E> current = root;
		Node<E> parent = null;
		while(true){
			parent = current;
			if(id.compareTo(current.data)<0){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
    }
    
	public void displayInOrder(Node<E> root){
		if(root!=null){
			displayInOrder(root.left);
			System.out.print(" " + root.data);
            displayInOrder(root.right);
		}
    }		
}


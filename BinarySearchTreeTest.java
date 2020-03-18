import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest<E> {
	public Node<E> root;

	@Test
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
	
	@Test
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

}

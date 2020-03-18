import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	BinarySearchTree<String> bst = new BinarySearchTree<String>();

	
	@Test
	void insertTest() {
		boolean resultado = true;	
		bst.insert("dog");
		boolean esperado = true;
		assertEquals(resultado,esperado);
		
	}
	
	@Test
	void findTest() {
		boolean resultado = true;
		resultado = bst.find("dog");
		boolean esperado = false;
		assertEquals(resultado,esperado);
		
	}

}

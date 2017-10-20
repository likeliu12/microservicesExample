package bst;

public class Driver {
	static public void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(12);
		tree.insert(37);
		tree.insert(43);
		tree.insert(30);
		tree.insert(33);
		tree.insert(87);
		tree.insert(93);
		tree.insert(97);
		
		tree.inorderTraversal();
		
		tree.delete(75);
		System.out.println("\n");
		tree.inorderTraversal();
	}
}

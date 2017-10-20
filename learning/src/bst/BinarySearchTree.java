package bst;

public class BinarySearchTree <E extends Comparable<? super E>>{
	private Node<E> root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(E key) {
		if(root == null) {
			root = new Node<E>(key);
			return;
		}
		else {
			insert(root, key);
		}
	}
	private void insert(Node<E> node, E key) {
		
		if (key.compareTo(node.key) < 0) {
			if (node.leftChild != null) {
				insert(node.leftChild, key);
			} else {
				System.out.println("  Inserted " + key + " to left of Node "
						+ node.key);
				node.leftChild = new Node<E>(key);
			}
		} else if (key.compareTo(node.key) > 0 ) {
			if (node.rightChild != null) {
				insert(node.rightChild, key);
			} else {
				System.out.println("  Inserted " + key + " to right of Node "
						+ node.key);
				node.rightChild = new Node<E>(key);
			}
		} else {
			System.out.println("node exist " + key);
		}
	}

	public void delete(E k) {
		if(root == null) {
			return;
		}
		delete(root, k);
	}
	
	private Node<E> delete(Node<E> t, E k) {
		if (t == null) { // k not in tree; do nothing.
		} 
		else if (k.compareTo(t.key) < 0) {
			t.leftChild = delete(t.leftChild, k);
		} 
		else if (k.compareTo(t.key) > 0) {
			t.rightChild = delete(t.rightChild, k);
		} 
		else { // Found it; now delete it.
				if (t.rightChild == null) {
					// t has at most one child, on the left.
					t = t.leftChild;
				} 
				else 
				{	// t has a right child. Replace t’s value
					// with its successor value.
					E successor = min(t.rightChild);
					t.key = successor;
					// Delete that successor.
					t.rightChild = delete(t.rightChild, successor);
				}
		}
		return t;
	}
	
	private E min(Node<E> t) {
		// To find the min, go left as far as possible.
		if (t.leftChild == null) {
			return t.key;
		} else {
			return min(t.leftChild);
		}
	}
	
	private void preorderTraversal(Node <E>node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preorderTraversal(node.leftChild);
			preorderTraversal(node.rightChild);
		}
	}

	public void inorderTraversal() {
		inorderTraversal(root);
	}
	private void inorderTraversal(Node <E>node) {
		if (node != null) {
			inorderTraversal(node.leftChild);
			System.out.print(node.key + " ");
			inorderTraversal(node.rightChild);
		}
	}

	private void postorderTraversal(Node <E>node) {
		if (node != null) {
			postorderTraversal(node.leftChild);
			postorderTraversal(node.rightChild);
			System.out.print(node.key + " ");
		}
	}
}

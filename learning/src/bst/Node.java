package bst;

public class Node<T> {
	 
    public T key;
    public Node<T> parent;
    public Node<T> leftChild;
    public Node<T> rightChild;
    
    public Node(T key) {
    	this.key = key;    	
    }
    
}


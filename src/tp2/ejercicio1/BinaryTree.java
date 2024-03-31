package tp2.ejercicio1;

import tp1.ej8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
	
	public void imprimirPreOrder(BinaryTree<Integer> a) {

			System.out.println(a.getData());
		
		if(a.hasLeftChild()) {
			imprimirPreOrder(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			imprimirPreOrder(a.getRightChild());
		}
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cantHD = 0;
		int cantHI = 0;
		if(isLeaf()) {
			return 1;
		}else {
			if(this.hasLeftChild()) {
				cantHI = this.getLeftChild().contarHojas();
			}
			if(this.hasRightChild()) {
				cantHD = this.getRightChild().contarHojas();
			}
		}
		return cantHD + cantHI;
		
	}
	
	public int contarNodos() {
		int cant = 0;
		if(isLeaf()) {
			return 1;
		}else {
			cant++;
			if(this.hasLeftChild()) {
				cant += this.getLeftChild().contarNodos();
			}
			if(this.hasRightChild()) {
				cant += this.getRightChild().contarNodos();
			}
		}
		return cant;
	}
	
	public int getAltura() {
		return this.getAltura(this);
	}
	
	public int getAltura(BinaryTree<T> a) {
		if(a.isEmpty()) {
			return 0;
		}else {

			int heightL = 0, heightR = 0;
			if(this.hasLeftChild()) {
				heightL = this.getLeftChild().getAltura(this.getLeftChild());
			}
			if(this.hasRightChild()) {
				heightR = this.getRightChild().getAltura(this.getRightChild());
			}
			  
	         return Math.max(heightL, heightR) + 1;  
		}
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	if(this.isEmpty()) {
    		return new BinaryTree<T>();
    	}else {
    		//Hacemos un clon del nodo actual
    		BinaryTree<T> abb_espejo = new BinaryTree<T>(this.getData());
    		//Si tiene hijo izquiedo, agregamos como hijo derecho el hijo izquierdo y hacemos el espejo a los sub-nodos del sub-nodo
    		if(this.hasLeftChild()) {
        		abb_espejo.addRightChild(this.getLeftChild().espejo()); 
        	}
    		//Si tiene hijo derecho, agregamos como hijo izquierdo el hijo derecho y hacemos el espejo a los sub-nodos del sub-nodo
        	if(this.hasRightChild()) {
        		abb_espejo.addLeftChild(this.getRightChild().espejo()); 
        	}
        	return abb_espejo;
    	}
    	
    }
    
    //En base al arbol
    //        3
    //     2     5
    //  1      4    6
    

	// 0<=n<=m
	public void entreNiveles(int n, int m) throws Exception{
		int altura = 0;
		Queue<BinaryTree<T>> cola= new Queue<BinaryTree<T>>();
		BinaryTree<T> arbol;
		//Encolo el primer elemento: 3
		cola.enqueue(this);
		//Encolo null
		cola.enqueue(null);
		//[3, null];
		
		//Si los parametros están dentro del ranto
		if (n>=0 && altura<=m){
			//Mientras la cola no este vacía
			while (!cola.isEmpty()){
				//altura = 0 | altura = 1 | altura = 1 ...
				//arbol = 3 | arbol = null | arbol = 5 ...
				//[null] | [2, 5] | [5, null] ...
				arbol = cola.dequeue();
				if (arbol == null){
					if (!cola.isEmpty()){
						//Encolo el null, para indicar el fin de un nivel
						//[2, 5, null]
						cola.enqueue(arbol);
						//Paso al siguiente nivel
						altura++;
					}
				}
				else{
					if (n<=altura && altura<=m){
						System.out.println(arbol.getData());
					}
					
					if (arbol.hasLeftChild()){
						//[null, 2]
						cola.enqueue(arbol.getLeftChild());
					}
					if (arbol.hasRightChild()){
						//[null, 2, 5]
						cola.enqueue(arbol.getRightChild());
					}
				}
			}
		}
	}
		
}


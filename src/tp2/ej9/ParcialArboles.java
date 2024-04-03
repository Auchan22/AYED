package tp2.ej9;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<SumDiff> sumAndDiff(BinaryTree<Integer> arbol){
		BinaryTree<SumDiff> sad = new BinaryTree<SumDiff>();
		sumAndDiff(arbol,sad,0,0);
		return sad;
	}
	
	private void sumAndDiff(BinaryTree<Integer> nodo, BinaryTree<SumDiff> sad, int acc, int parent){
		//Creo un nuevo objeto
		// La suma va a ser el acumulado hasta el objeto (acc) + el valor de este
		// La diferencia va a ser el valor del nodo - el valor del padre (parent)
		SumDiff s = new SumDiff(acc+nodo.getData(), nodo.getData()-parent);
		// Al arbol nuevo, que va por referencia, se le van agregando los nodos en el mismo orden que el arbol original
		sad.setData(s);
		
		//Por lo tanto, si arbol padre tiene hi, se agrega a arbol copia hi, con sus datos correspondientes
		if(nodo.hasLeftChild()) {
			sad.addLeftChild(new BinaryTree<SumDiff>());
			sumAndDiff(nodo.getLeftChild(), sad.getLeftChild(), acc+nodo.getData(), nodo.getData());
		}
		
		//Por lo tanto, si arbol padre tiene hd, se agrega a arbol copia hd, con sus datos correspondientes
		if(nodo.hasRightChild()) {
			sad.addRightChild(new BinaryTree<SumDiff>());
			sumAndDiff(nodo.getRightChild(), sad.getRightChild(), acc+nodo.getData(), nodo.getData());
		}
	}
}

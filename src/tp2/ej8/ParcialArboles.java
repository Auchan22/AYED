package tp2.ej8;

import tp1.ej8.Queue;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	public boolean esPrefijoRecursive(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		if(a1.getData() != a2.getData()) {
			return false;
		}
		boolean res = true;
		
		if(a1.hasLeftChild()) {
			if(a2.hasLeftChild()) {
				res = res && esPrefijoRecursive(a1.getLeftChild(), a2.getLeftChild());
			}else {
				return false;
			}
		}
		
		if(a1.hasRightChild()) {
			if(a2.hasRightChild()) {
				res = res && esPrefijoRecursive(a1.getRightChild(), a2.getRightChild());
			}else {
				return false;
			}
		}
		
		return res;
	}

    public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) throws Exception {
        Queue<BinaryTree<Integer>> cola1 = new Queue<BinaryTree<Integer>>();
        Queue<BinaryTree<Integer>> cola2 = new Queue<BinaryTree<Integer>>();

        boolean diff = false;

        cola1.enqueue(a1);
        cola2.enqueue(a2);

        BinaryTree<Integer> aux1;
        BinaryTree<Integer> aux2;

        while((!cola1.isEmpty() || !cola2.isEmpty()) && !diff){
            aux1 = cola1.dequeue();
            aux2 = cola2.dequeue();

            if(aux1 == null || aux2 == null){
                diff = true;
                break;
            };

            if(aux1.getData() == aux2.getData()){
                if(aux1.hasLeftChild()){
                    cola1.enqueue(aux1.getLeftChild());
                    if(aux2.hasLeftChild()){
                        cola2.enqueue(aux2.getLeftChild());
                    }else{
                        diff = true;
                        break;
                    }
                }
                if(aux1.hasRightChild()){
                    cola1.enqueue(aux1.getRightChild());
                    if(aux2.hasRightChild()){
                        cola2.enqueue(aux2.getRightChild());
                    }else{
                        diff = true;
                        break;
                    }
                }
            }else{
                diff = true;
            }
        }

        return !diff;
    }
}

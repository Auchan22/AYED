package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if(this.isEmpty()) return 0;
		else return (this.isLeaf() ? 0 : this.calcAltura());
	}
	
	private int calcAltura() {
		 if(this.isLeaf()) return 0;
	        else {
	            int alturaMax = -1;
	            List<GeneralTree<T>> children = this.getChildren();
	            for(GeneralTree<T> child: children) {
	                alturaMax = Math.max(alturaMax, child.calcAltura());
	            }
	            return alturaMax + 1;
	        }
	}
	
	public int nivel(T dato) throws Exception{
		if (this.isEmpty()) return  0;
		else {
			int nivel = 0;
			boolean ok = false;
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			GeneralTree<T> ag;
			cola.enqueue(this);
			cola.enqueue(null);
			while(!cola.isEmpty() && !ok) {
				ag = cola.dequeue();
				if(ag!=null) {
					if(ag.getData().equals(dato)) {
						ok = true;
					}else {
						
						List<GeneralTree<T>> children = ag.getChildren();
			            for(GeneralTree<T> child: children) {
			                cola.enqueue(child);
			            }
					}
				}else if(!cola.isEmpty()){
					nivel++;
					cola.enqueue(null);
				}
			}
			if(ok) return nivel;
			else return -1;
		}
	 }

	public int ancho() throws Exception{
		if(this.isEmpty()) return 0;
		else if(this.isLeaf()) return 1;
		else {
			int max = 0;
			int cantActual= 0;
			Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			GeneralTree<T> ag;
			cola.enqueue(this);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				ag = cola.dequeue();
				if(ag!=null) {
					List<GeneralTree<T>> children = ag.getChildren();
		            for(GeneralTree<T> child: children) {
		                cola.enqueue(child);
		                cantActual++;
		            }
				}else if(!cola.isEmpty()){
					max= Math.max(max, cantActual);
					cantActual = 0;
					cola.enqueue(null);
				}
			}
			return max;
		}
	}
}
package tp1.ej8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Queue<T> extends Sequence{
	private List<T> data;
	public Queue() {
		super();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	@Override
	public int size() {
		return data.size();
	}
	
	public T dequeue() throws Exception {
		if(this.size() == 0) {
			throw new Exception("La cola esta vacía, no se pudo obtener el primer elemento");
		}
		T d = data.remove(0);
		return d;
	}
	
	public T head() throws Exception {
		if(this.size() == 0) {
			throw new Exception("La cola esta vacía, no se pudo obtener el primer elemento");
		}
		T d = data.get(0);
		return d;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < this.size(); i++) {
			str += " - "+data.get(i).toString();
		}
		
		return str;
	}
}

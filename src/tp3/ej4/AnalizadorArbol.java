package tp3.ej4;

import tp1.ej8.Queue;
import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class AnalizadorArbol {
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) throws Exception {
		if(arbol.isEmpty()){
			return 0;
		}
		double max = -1;
		int cantNivel = 0;
		int sumNivel = 0;
		Queue<GeneralTree<AreaEmpresa>> cola= new Queue<GeneralTree<AreaEmpresa>>();
		GeneralTree<AreaEmpresa> ag;
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			ag = cola.dequeue();
			if(ag!=null) {
				cantNivel++;
				sumNivel += ag.getData().getTardanza();
				List<GeneralTree<AreaEmpresa>> children = ag.getChildren();
				for(GeneralTree<AreaEmpresa> child: children) {
					cola.enqueue(child);
				}
			}else if(!cola.isEmpty()){
				max = Math.max(max, sumNivel/cantNivel);
				cola.enqueue(null);
				cantNivel = 0;
				sumNivel = 0;
			}else{
				max = Math.max(max, sumNivel/cantNivel);
				cantNivel = 0;
				sumNivel = 0;
			}
		}
		return max;
	}
}

package tp3.ej6;

import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class RedDeAguaPotable {

    private GeneralTree<Character> arbol;

    public RedDeAguaPotable(GeneralTree<Character> ab){
        this.arbol = ab;
    }

    public double minimoCaudal(double caudal){
        if(this.arbol.isEmpty()){
            return 0;
        }
        return this.arbol.isLeaf() ? caudal : this.minimoCaudal(this.arbol, caudal);
    }

    private double minimoCaudal(GeneralTree<Character> a, double c){
        if(a.isLeaf()){
            return c;
        }
        double res = Integer.MAX_VALUE;
        List<GeneralTree<Character>> children = a.getChildren();
        for(GeneralTree<Character> child: children){
            res = Math.min(res, minimoCaudal(child, c/children.size()));
        }
        return res;
    }
}

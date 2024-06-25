package Parciales.Grafos.Parcial_24_6_2023;

import java.util.List;

public class ListaCaminos {
	private List<String> camino;
	private int cuadras;
	
	public ListaCaminos(List<String> camino, int cuadras) {
		this.camino = camino;
		this.cuadras = cuadras;
	}

	public List<String> getCamino() {
		return camino;
	}

	public int getCuadras() {
		return cuadras;
	}
	
    @Override
    public String toString() {
        return this.camino + " TOTAL=" + this.cuadras;
    }
}

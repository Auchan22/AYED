package tp2.ej9;

public class SumDiff {
	private int sum;
	private int diff;
	
	public SumDiff(int s, int d) {
		this.sum = s;
		this.diff = d;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}
	
	public String toString() {
		return "NODO [suma:"+this.getSum()+" | diff:"+this.getDiff()+" ]";
	}
}

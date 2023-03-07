package polinomios;

public class Nodo {
	
	private Nodo liga;
	private int coe;
	private int exp;
	
	public Nodo()
	{
		this.coe= 0;
		this.exp= 0;
		this.liga=null;
	}
	public Nodo(int c, int e)
	{
		this.coe=c;
		this.exp=e;
	}
	
	
	public int getC() {
		return coe;
	}

	public void setC(int c) {
		coe = c;
	}
	
	public int getE() {
		return exp;
	}
	
	public void setE(int e) {
		exp = e;
	}
	
	
	public Nodo getL() {
		return liga;
	}
	
	public void setL(Nodo l) {
		liga = l;
	}
}

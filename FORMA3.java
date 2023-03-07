package polinomios;

public class FORMA3 {
	
	Nodo punta;
	
	public	FORMA3()
	{
		punta=null;
	}
	
	public Nodo getPunta()
	{
		return punta;
	}
	public int getDU() {
		return punta.getE()+1;
	}
	
		
	
	public void convertir(String Vs[]) {
		
		for (int i= 0; i<Vs.length; i=i+2) {
			if (Vs[i]!=null){
				
				InsertarOrdenado(Integer.parseInt(Vs[i]), Integer.parseInt(Vs[i+1]));
				
			}
		}
		
	}
	
	public void InsertarOrdenado(int coe, int exp){
		
		Nodo x =new Nodo(coe,exp); 
		Nodo p= punta, a=null;
		if (p== null) {
			
			punta=x;
		}
		
		else {
			
			while (p!= null) {
				
				if (punta.getE()<x.getE()) {
					x.setL(punta);
					punta = x;
				}
				else {
					if (x.getE() < p.getE() && p.getL()==null) {
						
						p.setL(x);				
						
					}
					else {
						if(p.getE()<x.getE() && x.getE()<a.getE()) {
							x.setL(p);
							a.setL(x);
						}
						
					}
					
				}
				
				a=p;
				p= p.getL();		
				
			}
		}
		
		
	}
	
	public void Eliminar(int e)
	{
		Nodo p=punta, q=p;
		if(e==punta.getE())
		{
			punta=punta.getL();
		}
		else
		{
			while(p!=null)
			{
				
				if(p!=punta && p.getE()==e)
				{
					q.setL(p.getL());
				}
				q=p;
				p=p.getL();
			}
		}
	}
	
	
	
	public void mostrar() {
		
		Nodo p=punta;
		while (p!=null) {
			System.out.print("["+p.getC()+"]");
			System.out.print("["+p.getE()+"]");
			p=p.getL();		}
	}
	
	public FORMA3 suma(FORMA3 pol){
		boolean c=false;
		Nodo p=punta,a=p, q=pol.punta;
		FORMA3 res= new FORMA3();
		
		while(p!=null)
		{	
			q=pol.punta;
			c=false;
			while (q!=null&& p.getE()!=q.getE() )
			{
				
				if(p==punta &&   q.getE()>  p.getE())
				{
					res.InsertarOrdenado(q.getC(), q.getE());
					c=true;
				}
				else 
				{
					if(a.getE()>q.getE()&& q.getE()>p.getE())
					{
						res.InsertarOrdenado(q.getC(), q.getE());
						c=true;
					}
					else
					{
						if(p.getL()==null && q.getE()<p.getE())
						{
							res.InsertarOrdenado(q.getC(), q.getE());
							c=true;
						}
					}
					
				}
			
				
				q=q.getL();
			}
			if(q != null && p.getE()==q.getE())
			{
				res.InsertarOrdenado(q.getC()+p.getC(), q.getE());
				q=q.getL();
				if(q!=null && p.getL()==null && q.getE()<p.getE() )
				{
					res.InsertarOrdenado(q.getC(), q.getE());
				}
				
			}
			else
			{
				if(q == null && c==false)
				{
					res.InsertarOrdenado(p.getC(), p.getE());
				}
				else
				{
					if(q==null && p.getL()==null)
					{
						res.InsertarOrdenado(p.getC(), p.getE());
					}
				}
			}
			a=p;
			p=p.getL();
		}
		
		
		
		
		
		return res;
				
	}
	

}

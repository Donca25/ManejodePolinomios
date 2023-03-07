package polinomios;

public class FORMA1 {
	
	private int DU, VF1[];
	
	public FORMA1() {
		DU = 0;
		VF1= new int [20];  
	}
	
	public FORMA1(int exp ) {
		DU = exp+1;
		VF1 = new int [exp+2];  
	}
	
	
	public int getDU() {
		return DU;
	}
	
	
	public void setDU(int d) {
		DU= d;
	}
	
	
	public int[] getVF1() {
		return VF1;
	}
	
	public void setVec(int Vecaux[]) {
		VF1= Vecaux;
	}
	
	
	public int getDato(int posicion) {
		return VF1[posicion];
	}
	
	
	public void setDato(int posicion, int d) {
		VF1[posicion]= d;
	}
	

	public void convertir(String Vs[]) {
		
		int G=0;
		for (int i=1; i < Vs.length; i++) {
			if (Vs[i] != null)
			{
				if (Integer.parseInt(Vs[i]) > G ) {
					G = Integer.parseInt(Vs[i]); 
					
				}
			}
			i++;
			
		}

		setDU(G+1);
		int Vn[]= new int[G + 2];
		Vn[0] = G;
		for (int i=0;  Vs[i]!=null; i=i+2) {
			if (Vs[i+1]!=null) {
			Vn[getDU() - Integer.parseInt(Vs[i+1])] =Vn[getDU() - Integer.parseInt(Vs[i+1])] + Integer.parseInt(Vs[i]);
			}
		}

		setVec(Vn);
	}
	
	public void mostrar() {
		
		for (int i = 0; i < VF1.length; i++ ) {
			System.out.print("["+VF1[i]+"]");
		}
	}
	
	public void Redimensionar(int g) {
		FORMA1 aux = new FORMA1(g);
		
		if(g> this.getDato(0)) {
			for(int i = 1; i<=this.getDU();i++) {
				
				aux.setDato(i+(g-this.getDato(0)), this.getDato(i));
			}
			this.setVec(aux.getVF1());
			this.setDU(aux.getDU());
			
		}
		else {
			for(int i=1; i<=this.getDU()-(this.getDato(0)-g); i++) {
				
				aux.setDato(i, this.getDato(i));
			}
			
			this.setVec(aux.getVF1());
			this.setDU(aux.getDU());
		}
	}
	
	
	public void InsertarMonomio(String Mono[]) {
		
		if (Integer.parseInt(Mono[1]) > getDato(0)) {
			
			Redimensionar(Integer.parseInt(Mono[1]));	
			setDato(0, this.getDU()-1);
		}
		
		setDato(getDU()-Integer.parseInt(Mono[1]), getDato(getDU()-Integer.parseInt(Mono[1]))+ Integer.parseInt(Mono[0]));
		
	}
	public void Ajustar() {
		int i=1, cont=0, j=1;
		while(this.getDato(i)==0 && i<=this.getDU()) {
			
			cont++;
			i++;
		}
		while(j<=(this.getDU())-cont) {
			this.setDato(j, this.getDato(j+cont));
			j++;
		}
		this.Redimensionar(this.getDU()-cont-1);
	}
	
	public void Eliminar(String Mono[]) {
		boolean cont=false;
		if(	Integer.parseInt(Mono[1])<this.getDato(0)) {
			for (int i=1; i<this.getDU(); i++) {
				
				if (VF1[i]==Integer.parseInt(Mono[0]) && (this.getDU()-i)==Integer.parseInt(Mono[1]) ) {
					
					setDato(i, 0);			
					cont=true;
					i=this.getDU();
				}
			}
			if(cont==false) {
				System.out.println("el dato a borrar no existe");
			}
		}
		else {
			if(Integer.parseInt(Mono[1])==this.getDato(0) && Integer.parseInt(Mono[0])==this.getDato(1)) {
				int j=2;
				if(this.getDato(2)==0){
					for (int i=2; this.getDato(i)==0;i++) {
						j++;
					}
				}

				FORMA1 Vaux= new FORMA1((this.getDU()-j));
				Vaux.setDU((this.getDU()-j)+1);
				Vaux.setDato(0, this.getDU()-j );
				for(int i=1; i<=Vaux.getDU();i++) {
					Vaux.setDato(i, this.getDato(j));
					j++;
				}
				
				setVec(Vaux.getVF1());
				setDU(Vaux.getDato(0)+1);
			
				
			}
			else {
				
			}
		}
		
		
	}
	
	public void Suma(String Vs[]) {
			FORMA1 Vaux= new FORMA1(Vs.length);
			int G=0;
			for (int i=1; i < Vs.length; i++) {
				if (Vs[i] != null)
				{
					if (Integer.parseInt(Vs[i]) > G ) {
						G = Integer.parseInt(Vs[i]); 
						
					}
				}
				i++;
				
			}

			Vaux.setDU(G+1);
			int Vn[]= new int[G + 2];
			Vn[0] = G;
			for (int i=0;  Vs[i]!=null; i=i+2) {
				if (Vs[i+1]!=null) {
				Vn[Vaux.getDU() - Integer.parseInt(Vs[i+1])] =Vn[Vaux.getDU() - Integer.parseInt(Vs[i+1])] + Integer.parseInt(Vs[i]);
				}
			}

			Vaux.setVec(Vn);
			
			if(this.getDU()>Vaux.getDU()) {
			
				for (int j=1; j<this.getDU();j++) {
					
					for (int i=1; i<Vaux.getDU();i++) {
						
						if (this.getDU()- j == Vaux.getDU()-i) {
							
							this.setDato(this.getDU() - (this.getDU()- j), this.getDato( j)+ Vaux.getDato(i)) ;
							
						}

					}
					
				}
			}
			else {
				if(this.getDU()<Vaux.getDU()) {
					String aux[]= new String[Vaux.getDU()-this.getDU()+1];
					aux[1]=Integer.toString(Vaux.getDato(0));	
					for(int i=0; i<Vaux.getDU()-this.getDU();i++) {
						for (int j=0; j<Vaux.getDU()-this.getDU();j++) {
							aux[j]=Integer.toString(Vaux.getDato(j+1));					
						}
						this.InsertarMonomio(aux);
					}
					
					for (int j=1; j<Vaux.getDU();j++) {
						
						for (int i=1; i<this.getDU();i++) {
							
							if (Vaux.getDU()- j == this.getDU()-i) {
								
								this.setDato(this.getDU() - (this.getDU()- i), this.getDato( j)+ Vaux.getDato(j)) ;
								
							}

						}
						
					}
				}				
				
			}
	}
}

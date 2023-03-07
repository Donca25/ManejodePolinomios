package polinomios;

import javax.swing.JOptionPane;

public class FORMA2 {
	
private int DU, VF2[];
	
	public FORMA2() {
		DU = 0;
		VF2= new int [20];  
	}
	
	public FORMA2(int exp ) {
		DU = exp+1;
		VF2 = new int [exp+2];  
	}
	
	
	public int getDU() {
		return DU;
	}
	
	
	public void setDU(int d) {
		DU= d;
	}
	
	
	public int[] getVF2() {
		return VF2;
	}
	
	
	public void setVec(int Vecaux[]) {
		VF2= Vecaux;
	}
	
	
	public int getDato(int posicion) {
		return VF2[posicion];
	}
	
	
	public void setDato(int posicion, int d) {
		VF2[posicion]= d;
	}
	

	public void convertir(String Vs[]) {
		String Va[]=new String[Vs.length];
		
		int j=0;
		for ( int i=0; i <Vs.length; i++ ) {
			if (Vs[i] != null) {
				j++;
			}
		}
		
		for (int i=0; i<j; i++) {
			Va[i]= (Vs[i]);
		}
		

		int Vn[]= new int[j];
		Vn[0] = (j/2);
		int du = ((Vn[0])*2);
		String auxC[]=new String[1], auxE[]=new String[1];
		for(int u=1; u<j; u=u+2) {
			
			for (int i=1;  i <j; i=i+2) {
				
				if (Integer.parseInt(Va[u]) > Integer.parseInt(Va[i])) {
					
					auxC[0]= Va[u-1];
					auxE[0]= Va[u];
					Va[u-1]= Va[i-1];
					Va[u]= Va[i];
					Va[i-1]= auxC[0];
					Va[i]= auxE[0];					
				}			
				
			}
		}
		


		
		for (int i=1; i<j; i++) {
			Vn[i]= Integer.parseInt(Va[i-1]);
		}
	
		
		setVec(Vn);
		
	

	}
	
	 public void Redimensionar() {
	        int n = DU + 3;
	        int aux[] = new int[n];

	        for (int i = 0; i < getDU() + 1; i++) {
	            aux[i] = getDato(i);
	        }
	        this.setVec(aux); 
	    }

	    public FORMA2 Suma(FORMA2 A) {
	        int ExpA = 0, ExpB = 0, NT=0;
	        int k = 2, j = 2, i = 1;
	        
	        if(VF2[2] >= A.getDato(2) && VF2[0] >= A.getDato(0) ){
	            NT = VF2[0];
	        }else{
	            if(VF2[2] < A.getDato(2) && VF2[0] < A.getDato(0) ){
	                NT = A.getDato(0);
	            }else{
	               if(VF2[2] < A.getDato(2) && VF2[0] > A.getDato(0) || VF2[2] > A.getDato(2) && VF2[0] < A.getDato(0)){
	                   NT = VF2[0] + A.getDato(0);
	               } 
	            }
	        }

	        FORMA2 R = new FORMA2(NT);
	        R.setDato(0, NT);

	        while ((k <= getDato(0) * 2) || (j <= A.getDato(0) * 2)) {
	            ExpA = VF2[k];
	            ExpB = A.getDato(j);
	            if (ExpA == ExpB) {
	                R.setDato(i, (getDato(k - 1) + A.getDato(j - 1)));
	                R.setDato(i + 1, ExpA);
	                k += 2;
	                j += 2;
	            } else if (ExpA > ExpB) {
	                R.setDato(i, getDato(k - 1));
	                R.setDato(i + 1, ExpA);
	                k += 2;
	            } else {
	                R.setDato(i, A.getDato(j - 1));
	                R.setDato(i + 1, ExpB);
	                j += 2;
	            }
	            i += 2;
	        }
	        R.setDato(0, i/2);
	        return R;
	    }
	    
	
	
	public void Insertar(String[] A) {
        int[] V = new int[A.length - 2];
        boolean f = false, f2 = true;

        if (Integer.parseInt(A[0]) > 0) {
            for (int i = 0; i < A.length - 2; i++) {
                V[i] = Integer.parseInt(A[i]);
            }
        } else {
            for (int i = 0; i < A.length - 3; i++) {
                V[i] = Integer.parseInt(A[i]);
            }
        }
        
        int j = 2;
        while (j < DU && f == false) {
            if (VF2[j] == V[1]) {
                VF2[j - 1] += V[0];
                f = true;
            }
            j += 2;
        }
        if(!f){
            if(V[0] != 0){
                int cont=0;
                int[] aux = new int[DU+3];
                aux[0]= VF2[0]+1;
                for(int i=2;i<VF2.length;i+=2){
                    cont++;
                    if(V[1]<VF2[i]){
                        aux[i-1]=VF2[i-1];
                        aux[i]=VF2[i];
                    }else{
                        if(V[1]>VF2[i] && f2 == true){
                            aux[i-1]=V[0];
                            aux[i]=V[1];
                            f2 = false;
                        }else{
                            if(V[1]!=0){
                                for(int k=i-3;k<VF2.length;k++){
                                    aux[k+2]=VF2[k]; 
                                }
                            }
                        }
                    }
                }
                setDU(DU+2);
                setVec(aux);
            } 
        }
        if (VF2[1] == 0){
            for (int i = 2; i < DU; i++){
                VF2[i-1] = VF2[i+1];
            }
            setDU(DU-2);
            VF2[0] = VF2[0]-1;
        }
	}

	
	 public void InsertarMono(int coe, int exp) {
	        int i = 1;
	        int j = 0;

	        while ((i < getDU() + 1) && (getDato(i) > exp) && (getDato(i + 1) != 0)) {
	            i += 2;
	        }

	        if ((i < getDU() + 1 && getDato(i) == exp) && getDato(i + 1) != 0) {
	            if ((getDato(i + 1) + coe) != 0) {
	                setDato(i + 1, coe + getDato(i + 1));
	            } else {
	                for (j = i; j < getDU() + 1; j += 2) {
	                    setDato(j, getDato(j + 2));
	                    setDato(j + 1, getDato(j + 3));
	                }
	                setDU(getDU() - 1);
	                setDato(0, getDato(0) - 1);
	            }
	        } else {
	            if (getDato(0) * 2 + 1 == getVF2().length) {
	                Redimensionar();
	            }
	            for (j = getDU(); j >= i; j--) {
	            	setDato(j + 2, getDato(j));
	            }
	            setDato(i, exp);
	            setDato(i + 1, coe);
	            setDato(0, getDato(0) + 1);
	            setDU((int) getDato( 0) * 2);
	        }
	    }
	 
	 public FORMA2 MultiF2(FORMA2 A) {
	        int Vn = VF2[0] + A.VF2[0] +2, a, Acoe, Aexp;
	        int[] aux = new int [VF2[0] * A.VF2[0]*2];
	        FORMA2 res = new FORMA2(Vn);
	        res.VF2[0] = Vn;
	        a=1;
	        for (int k = 0; a < aux.length-1; k++) {
	            for (int i = 2; i < DU+1; i += 2) {
	                for (int j = 2; j < A.DU+1; j += 2) {
	                    aux[a] = VF2[i] + A.VF2[j];
	                    aux[a - 1] = VF2[i - 1] * A.VF2[j - 1];
	                    a += 2;
	                }
	            }
	        }
	        int s=0;
	        for(int o=0; o<aux.length-1; o+=2){
	            for(int i=o+2; i<aux.length-1;i+=2){
	                if(aux[o+1]==aux[i+1]){
	                    aux[o]+=aux[i];
	                    for( s = i; s < aux.length-3 ; s++){
	                        aux[s] = aux[s+2];
	                        aux[s+1] = aux[s+3];   
	                    }
	                    for ( int l = s ;  l < aux.length; l++) {
	                        aux[l] = 0;
	                    }
	                }
	            } 
	         }
	        for(int i=1; aux[i-1] != 0; i+=2){
	            for(int j=i+2; aux[j-1] != 0; j+=2){
	                if(aux[i] < aux[j]){
	                    Acoe = aux[i-1];
	                    Aexp = aux[i];
	                    aux[i] = aux[j];
	                    aux[i-1] = aux[j-1];
	                    aux[j-1]= Acoe;
	                    aux[j] = Aexp;
	                }
	            }
	        }
	        
	        for (int i = 0; i < res.VF2.length-1; i++) {
	            res.VF2[i+1] = aux[i];
	        }
	        int i;
	        for ( i = 1; res.VF2[i] != 0 ; i+=2) {
	            if (i == res.VF2.length-2){
	                i++;
	                break;
	            }
	        }
	        res.VF2[0] = (i-1)/2;
	        res.setDU(i);
	        return res;
	    }
	
	public void mostrar() {
		
		for (int i = 0; i < VF2.length; i++ ) {
			System.out.print("["+VF2[i]+"]");
		}
	}
	
    public void EliminarDto(int e){
        boolean f = false;
        int a=2;
        while(a<VF2.length){
            if(VF2[a] == e){
                f = true;
            }
            a+=2;
        }
        if(f ){
        for (int i = 1; i < DU+1; i++) {
            if (VF2[i] == e) {
                for (int j = i; j < DU+1; j++) {
                    if (j + 1 != DU+1) {
                        VF2[j - 1] = VF2[j + 1];
                    }
                }
                setDU(DU - 2);
            }
        }
	     VF2[0]=VF2[0]-1;
	
	     int[] Vn = new int[DU+2];
	     Vn[0] = VF2[0];
	     for(int i=1; i<=DU; i++){
	         Vn[i]=VF2[i];
	     }
	     setVec(Vn);
	     }else{
	        JOptionPane.showMessageDialog(null, "El término no se encuentra en el polinomio.");
	     }
    }
    
}
    
   
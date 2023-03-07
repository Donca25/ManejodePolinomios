package polinomios;





public class Polimain {

	public static String[] CREARPOLINOMIO(String poli) {
		int j=0;
		String S="", Spol= poli;
		char Vc[]= Spol.toCharArray();
		if(Vc.length<2) {
			String Vs[]= new String[Vc.length];
		}
		String Vs[]= new String[Vc.length+1];
		
		for (int i = 0; i < Vs.length; i++) 
		{
			if (i<Vc.length) {
			if(Character.isDigit(Vc[i])|| Vc[i]== '-')
			{
				
				
				S=S+Vc[i];
				if(Vc[i]=='-'&&Vc[i+1]=='x') {
					S=S+'1';
					
				}
				if(i == Vc.length-1 || Vc[i+1]=='+'|| Vc[i+1]=='-')
				{

				
					Vs[j]=S;
					S="";
					j++;
					Vs[j]="0";
					j++;
					
					if(Vc[i]=='-') {
						Vs[j]="1";
						i++;
					}
				}
				
			}
			else
			{
				if(Vc[i]== 'x')
				{
					if(i>1 && !Character.isDigit(Vc[i-1])&& Vc[i+1]!='^')	{
						
						S=S+'1';
					}
					else {
						
						if(i==0) {
							S=S+'1';
						}
					}
					
					
					Vs[j]= S;
					S="";
					j++;
					
					
					
					
					if(i+1==Vc.length || Vc[i+1] != '^' )
					{
						Vs[j]="1";
						j++;
						
					}
					
				
				}
					
			}
			
			if(Vc[i]== '^')
			{
				Vs[j]=Character.toString(Vc[i+1]);
				i++;
				j++;
			}
			
			}
			
			
		}
		
		/*for (int k=0;k<Vn.length;k++) 
		{
			
			System.out.print("["+Vs[k]+"]");
			
		}*/
		return Vs;

	}
	
	
	/*public static void POLINOMIOF1(String Vs[]) {
		
		int G=0;
		for (int i=1; i < Vs.length; i++) {
			if (Vs[i+2] != null)
			{
				if (Integer.parseInt(Vs[i]) > G ) {
					G = Integer.parseInt(Vs[i]); 
					
				}
			}
			i++;
			
		}
		int du = G+1;
		int Vn[]= new int[G + 2];
		for (int i=1; Vs[i]!= null; i=i+2) {
			Vn[du - Integer.parseInt(Vs[i])] = Integer.parseInt(Vs[i-1]);
		}
		
		for (int i = 0; i < Vn.length; i++ ) {
			System.out.print("["+Vn[i]+"]");
		}
		
		
	}*/
	
	
	
	//MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String poli= "2x^6+7x^5-2x^3+4x^4+3x^2-26";
		String Vs[]=CREARPOLINOMIO(poli);

		FORMA1 POLIF1 = new FORMA1();
		POLIF1.convertir(Vs);
		System.out.print("el vector en forma uno es: ");
		POLIF1.mostrar(); 
		System.out.print("\n");
		
		FORMA2 POLIF2 = new FORMA2();
		POLIF2.convertir(Vs);
		System.out.print("el vector en forma dos es: ");
		POLIF2.mostrar();
		System.out.print("\n");
		
		FORMA3 POLIF3 = new FORMA3();
		POLIF3.convertir(Vs);
		System.out.print("el vector en forma tres es: ");
		POLIF3.mostrar();
		System.out.print("\n");
		
		String poli2= "2x^6";
		String Mono[]=CREARPOLINOMIO(poli2);
		System.out.print("\n");
		System.out.print("\n");
		POLIF1.InsertarMonomio(Mono);
		System.out.print("el vector en forma uno ahora es: ");
		POLIF1.mostrar();
		System.out.print("\n");
		
		String poli3= "4x^6";
		String MonoE[]=CREARPOLINOMIO(poli3);
		POLIF1.Eliminar(MonoE);
		System.out.print("el vector en forma uno ahora es: ");
		POLIF1.mostrar();
		System.out.print("\n");
		
		String poli4= "4x^2+3x^6+2x^3+2x^5+2x^3";
		String polsum[]=CREARPOLINOMIO(poli4);
		POLIF1.Suma(polsum);
		System.out.print("el vector en forma uno ahora es: ");
		POLIF1.mostrar();
		System.out.print("\n");
		
	}

}

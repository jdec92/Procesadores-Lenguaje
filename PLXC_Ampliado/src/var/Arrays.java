package src.var;
import src.*;

public class Arrays {
	private static Array[] arrays=new Array[80];
	private static int cont=0;
	private static int nivel=0;

	
	public static Array GuardarVariable(String nombre,Character tipov,int tope){
		if(NoSeCrea(nombre)){
		   Generador.escribir(40,null,null,null);
		   return null;		  
		}else{
		   Array x=new Array(nombre,nivel,tipov,tope);		
		   arrays[cont]=x;
		   cont++;		
		   return x;
		}
	}	
	
	public static Array GuardarVariable(String nombre,Character tipov,int tope1,int tope2){
		if(NoSeCrea(nombre)){
		   Generador.escribir(40,null,null,null);
		   return null;		  
		}else{
		   Array x=new Array(nombre,nivel,tipov,tope1*tope2);
		   		   
		   x.tope1(tope1);
		   x.tope2(tope2);		   
		   arrays[cont]=x;
		   cont++;		
		   return x;
		}
	}	
	
	public static boolean NoSeCrea(String n){
		if(arrays[0]!=null){
			for(int i=0;i<cont;i++){
				if(arrays[i].nombre().compareTo(n)==0 && arrays[i].nivel()==nivel){						
					return true;
				}
			}
		}
		return false;
	}
	public static Array ComprobarExiste(String n){
		Array v;
		if(arrays[0]!=null){
			int p=cont-1;
			for(int i=p;i>=0;i--){
				v=arrays[i];
				if(v.nombre().compareTo(n)==0){
					return v;
				}
			}
		}		
		return null;
	}
	
	public static void BorrarActual(){		
		cont--;
		arrays[cont]=null;
	}

	public static void NuevaLlave(){
		nivel++;
	}
	public static void CerrarLlave(){
		for(int i=0;i<cont;i++){
			if(arrays[i].nivel()==nivel){
				if(i==0){
					arrays=new Array[50];
					cont=i;
				}else{
					cont=i;
				}
				break;
			}
		}
		nivel--;
	}	

	
}


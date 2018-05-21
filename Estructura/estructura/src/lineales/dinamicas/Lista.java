package lineales.dinamicas;

import lineales.dinamicas.NodoGen;

public class Lista<T> {

	private NodoGen<T> cabecera;
	private int longitud;
	
	
	public boolean insertar(T elemento , int pos){
		boolean resp = false;
		NodoGen<T> nuevo = new NodoGen<T>(elemento);
		NodoGen<T> aux = this.cabecera;	
		
		if(pos >=1 && pos <= longitud +1){
			if(pos==1){
			nuevo.setEnlace(this.cabecera);
			this.cabecera = nuevo;
			resp = true;
			longitud++;
			}
			else{
				aux = obtenerNodo(pos-1);
				nuevo.setEnlace(aux.getEnlace());
				aux.setEnlace(nuevo);
				resp = true;
				longitud++;
			}
		}
		
		return resp;
	}
	
	public boolean eliminar(int pos){
		boolean resp = false;
		NodoGen<T> aux = this.cabecera;
		
		if(pos >=1 && pos <= longitud+1){
			if(pos == 1){
				this.cabecera = this.cabecera.getEnlace();
				resp = true;
				longitud--;
			}else{
				aux = obtenerNodo(pos-2);
				aux.setEnlace(aux.getEnlace().getEnlace());
				resp = true;
				longitud--;
			}
		}
		
		return resp;
	}
	
	public T localizar(T elemento){
		//localiza la posicion de la primera aparicion del elemento dado
		NodoGen<T> aux = this.cabecera;
		boolean seguir=false;
		T pos=null;
		
		while(!seguir && aux !=null){
			if(aux.getElemento().equals(elemento));{
				seguir = true;
				pos = aux.getElemento();
			}
			aux =aux.getEnlace();
			
		}
		return pos;
	}
	
	public T recuperar(int pos){
		//obtiene el elemento en la posicion dada
	return (obtenerNodo(pos)== null) ? null : obtenerNodo(pos).getElemento();	
		
	}
	
	public int longitud(){
	return longitud;
	}
	
	public boolean esVacia(){
		return this.cabecera==null;
	}
	
	public void vaciar(){
		this.cabecera.setEnlace(null);
	}
	
	@Override
	public Lista<T> clone(){
		Lista<T> clon = new Lista<T>();
		
		return clon;
	}
	
	@Override
	public String toString(){
		//no funciona
		String s="";
		NodoGen<T> aux=this.cabecera;
		
		
		while(aux!=null){
			s+=  aux.getElemento() + " ";
			aux= aux.getEnlace();
		}
		
		
		return s;
	}
	
	public NodoGen<T> obtenerNodo(int pos){
		//recorre la lista para obtener un nodo en la posicion dada
		int i=1;
		NodoGen<T> aux = this.cabecera;
		
		while(i<pos && aux != null){
			aux = aux.getEnlace();
			i++;
		}
	return aux;
	}
}

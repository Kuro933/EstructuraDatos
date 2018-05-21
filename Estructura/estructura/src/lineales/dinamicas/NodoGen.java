package lineales.dinamicas;

class NodoGen<T> {

	private NodoGen<T> enlace;
	private T elem;


public NodoGen (T elem){
	
	this.enlace = null;
	this.elem = elem;
}

public NodoGen (T elem, NodoGen<T> enlace){
	this.enlace = enlace;
	this.elem = elem;
	
}

public NodoGen<T> getEnlace (){
	return this.enlace;
}

public void setEnlace(NodoGen<T> enlace){
	this.enlace = enlace;
}

public T getElemento(){
	return this.elem;
}
public void setElemento(T elem){
	this.elem = elem;
}
}



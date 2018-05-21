package jerarquicas;

import jerarquicas.NodoGen;

public class ArbolGen {

	private NodoGen raiz;

	public ArbolGen() {
		this.raiz = null;
	}

	//inserta en la primera posicion y va corriendo la lista de hermanos hacia la derecha 
	public boolean insertar(Object hijo, Object padre) {
		NodoGen nuevo;
		boolean exito=false;
		// inserta un elemento
		if (this.raiz == null) {
			nuevo = new NodoGen(hijo);
			this.raiz = nuevo;
			exito = true;
		} else {
			NodoGen aux = obtenerNodo(padre);
			if (aux != null) {
				nuevo = new NodoGen(hijo);
				if (aux.getHijoIzquierdo() != null) {

					nuevo.setHermanoDerecho(aux.getHijoIzquierdo());
					aux.setHijoIzquierdo(nuevo);
				} else {
					aux.setHijoIzquierdo(nuevo);
				}
				exito = true;
			}
		}
		return exito;
	}

	public NodoGen obtenerNodo(Object elem) {
		NodoGen nodo = obtenerNodoAux(this.raiz, elem);
		return nodo;
	}

	private NodoGen obtenerNodoAux(NodoGen nodo, Object elem) {

		NodoGen h = null;
		NodoGen resultado = null;
		if (nodo != null) {
			if (nodo.getElem().equals(elem)) {
				resultado = nodo;
			} else {
				h = nodo.getHijoIzquierdo();

				while (h != null && resultado == null) {
					resultado = obtenerNodoAux(h, elem);
					h = h.getHermanoDerecho();
				}
			}
		}

		return resultado;
	}

	public boolean pertenece(Object elem) {
		boolean resp = perteneceAux(this.raiz, elem);
		return resp;
	}

	private boolean perteneceAux(NodoGen nodo, Object elem) {
		boolean exito = false;
		NodoGen hijo = null;

		if (nodo != null) {
			if (nodo.getElem().equals(elem)) {
				exito = true;
			} else {
				hijo = nodo.getHijoIzquierdo();
				while (hijo != null && !exito) {
					exito = perteneceAux(hijo, elem);
					hijo = hijo.getHermanoDerecho();
				}
			}
		}

		return exito;
	}

	public Object padre(Object elem) {
		 Object padre;
		 
		 if(this.raiz.equals(elem)){
			 padre = null;
		 }else{
			padre = padreAux(this.raiz, elem);
		 }
		 		
		return padre;
	}

	private Object padreAux(NodoGen nodo, Object elem) {
		
		NodoGen hijo = null;
		Object padre=null;
		if (nodo != null) {
				hijo = nodo.getHijoIzquierdo();
				System.out.println(hijo);
				while(hijo != null && padre==null){
					if(hijo.getElem().equals(elem)){
						padre = nodo.getElem();
					}else{
					hijo= hijo.getHermanoDerecho();
					System.out.println(hijo);
					}
				}
				hijo = nodo.getHijoIzquierdo();
				padre = padreAux(hijo,elem);				
		}
		return padre;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public String toString() {
		return toStringAux(this.raiz);
	}

	private String toStringAux(NodoGen nodo) {
		String s = "";

		if (nodo != null) {
			s += nodo.getElem().toString() + "-->";
			NodoGen hijo = nodo.getHijoIzquierdo();
			while (hijo != null) {
				s += hijo.getElem().toString() + ", ";
				hijo = hijo.getHermanoDerecho();
			}
			hijo = nodo.getHijoIzquierdo();
			while (hijo != null) {
				s += "\n" + toStringAux(hijo);
				hijo = hijo.getHermanoDerecho();
			}
		} else {
			s += "Arbol Vacio";
		}
		return s;
	}
}

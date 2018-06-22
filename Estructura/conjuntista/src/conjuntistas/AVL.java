package conjuntistas;

public class AVL {
	
	private NodoAVL raiz;
	
	public AVL(){
		raiz=null;
	}
	
	public boolean pertenece(Comparable elto) {
		return perteneceAux(this.raiz, elto, false);
	}

	private boolean perteneceAux(NodoAVL nodo, Comparable elto, boolean exito) {
		while (nodo != null && !exito) {
			if (nodo.getElem().equals(elto)) {
				exito = true;
			} else {
				if (nodo.getElem().compareTo(elto) > 0) {
					exito = perteneceAux(nodo.getIzquierdo(), elto, exito);
				}
				if (nodo.getElem().compareTo(elto) < 0) {
					exito = perteneceAux(nodo.getDerecho(), elto, exito);
				}
			}
		}
		return exito;
	}
	
	public boolean insertar(Comparable elto) {
		boolean exito = true;
		int altura = 1;
		if (this.raiz == null) {
			this.raiz = new NodoAVL(elto,altura);
		} else {
			exito = insertarAux(this.raiz,altura+1, elto);
		}

		return exito;
	}

	private boolean insertarAux(NodoAVL nodo,int altura, Comparable elto) {
		boolean exito = true;

		if (elto.compareTo(nodo.getElem()) == 0) {
			exito = false;
		} else {

			if (elto.compareTo(nodo.getElem()) < 0) {
				if (nodo.getIzquierdo() != null) {
					exito = insertarAux(nodo.getIzquierdo(),altura, elto);
				} else {
					nodo.setIzquierdo(new NodoAVL(elto,altura));
				}
			} else {
				if (nodo.getDerecho() != null) {
					exito = insertarAux(nodo.getDerecho(),nodo.getAltura(), elto);
				} else {
					nodo.setDerecho(new NodoAVL(elto,altura));
				}
			}
		}
		return exito;
	}

	
	public String toString() {
		String arbol = "";

		if (this.raiz != null) {
			arbol += toStringAux(this.raiz);
		} else {
			arbol = "Arbol vacio";
		}

		return arbol;
	}

	private String toStringAux(NodoAVL nodo) {
		String listado = "";

		if (nodo != null) {
			listado += "Padre: " + nodo.getElem() + " tiene altura: " + nodo.getAltura();
			listado += " ---> ";
			if (nodo.getIzquierdo() != null) {
				listado += "Hijo izquierdo: " + nodo.getIzquierdo().getElem() + " ";
//				listado += "altura: " + nodo.getAltura() + " ";
			} else {
				listado += "Hijo izquierdo: No tiene ";
			}
			if (nodo.getDerecho() != null) {
				listado += "Hijo derecho: " + nodo.getDerecho().getElem() + " ";
//				listado += "altura: " + nodo.getAltura() + " ";
			} else {
				listado += " Hijo derecho: No tiene ";
			}

			listado += "\n";
			listado += toStringAux(nodo.getIzquierdo());
			listado += toStringAux(nodo.getDerecho());
		}
		return listado;
	}

}

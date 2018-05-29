package conjuntistas;

public class ArbolBB {

	private NodoABB raiz;

	public ArbolBB() {
		this.raiz = null;
	}

	public boolean pertenece(Comparable elto) {
		return perteneceAux(this.raiz, elto, false);
	}

	private boolean perteneceAux(NodoABB nodo, Comparable elto, boolean exito) {
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
		if (this.raiz == null) {
			this.raiz = new NodoABB(elto);
		} else {
			exito = insertarAux(this.raiz, elto);
		}

		return exito;
	}

	private boolean insertarAux(NodoABB nodo, Comparable elto) {
		boolean exito = true;

		if (elto.compareTo(nodo.getElem()) == 0) {
			exito = false;
		} else {

			if (elto.compareTo(nodo.getElem()) < 0) {
				if (nodo.getIzquierdo() != null) {
					exito = insertarAux(nodo.getIzquierdo(), elto);
				} else {
					nodo.setIzquierdo(new NodoABB(elto));
				}
			} else {
				if (nodo.getDerecho() != null) {
					exito = insertarAux(nodo.getDerecho(), elto);
				} else {
					nodo.setDerecho(new NodoABB(elto));
				}
			}
		}
		return exito;
	}

	public boolean eliminar(Comparable elto) {
		boolean exito = false;

		if (!this.esVacio()) {
			if (this.raiz.getElem().compareTo(elto) == 0) {
				// reacomodamiento(this.raiz);
			} else if (this.raiz.getIzquierdo().getElem().compareTo(elto) > 0) {
				exito = eliminarAux(this.raiz.getIzquierdo(), this.raiz, elto);
			} else {
				exito = eliminarAux(this.raiz.getDerecho(), this.raiz, elto);
			}
		}
		return exito;
	}

private boolean eliminarAux(NodoABB nodo, NodoABB padre, Comparable elto) {
		boolean exito = false;
		if (nodo != null) {
			if (nodo.getElem().compareTo(elto) == 0) {
				System.out.println(nodo.getElem());
				System.out.println(padre.getElem());
				if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
					if (padre.getIzquierdo() == nodo) {
						padre.setIzquierdo(null);
					} else {
						padre.setDerecho(null);
					}
				} else if (nodo.getElem().compareTo(padre.getElem()) < 0) {
					if (caso2Izq(nodo)) {
						padre.setIzquierdo(nodo.getIzquierdo());
					} else {
						padre.setIzquierdo(nodo.getDerecho());
					}
				} else if (caso2Der(nodo)) {
					padre.setDerecho(nodo.getDerecho());
				} else {
					padre.setDerecho(nodo.getIzquierdo());
				}
				if (caso3(nodo)) {
					reacomodamiento(nodo,padre);
				}
			}
			if (nodo.getElem().compareTo(elto) > 0) {
				exito = eliminarAux(nodo.getIzquierdo(), nodo, elto);
			} else{
				exito = eliminarAux(nodo.getDerecho(), nodo, elto);
			}
		}
		return exito;
	}
	private void reacomodamiento(NodoABB nodo,NodoABB padre){
			if(padre.getElem().compareTo(nodo.getElem())<0){
				
			}
	}	
	private boolean caso2Izq(NodoABB nodo){
		return nodo.getDerecho()==null && nodo.getIzquierdo()!=null;
	}
	
	private boolean caso2Der(NodoABB nodo){
		return nodo.getDerecho()!=null && nodo.getIzquierdo()==null;
	}
	public Lista lista() {
		// lista en orden ascendente todos los elementos del arbol
		Lista lista = new Lista();
		if (!this.esVacio()) {
			listaAux(this.raiz, lista);
		} else {
			lista.insertar(null, 1);
		}

		return lista;
	}

	private Lista listaAux(NodoABB nodo, Lista lista) {
		if (nodo != null) {
			listaAux(nodo.getIzquierdo(), lista);
			lista.insertar(nodo.getElem(), lista.longitud() + 1);
			listaAux(nodo.getDerecho(), lista);
		}

		return lista;
	}

	public Lista listarRango(Comparable minimo, Comparable maximo) {
		//TERMINARLO PREGUNATANDO LUNES
		Lista lista = new Lista();
		listarRangoAux(this.raiz, minimo, maximo, lista);

		return lista;
	}

	private Lista listarRangoAux(NodoABB nodo, Comparable min, Comparable max, Lista lista) {
		// devuelve una lista con todos los elementos que esten en el rango dado
		// [min,max]
		if (nodo != null) {
			if (nodo.getElem().compareTo(min) > 0 && nodo.getElem().compareTo(max) < 0) {
				listarRangoAux(nodo.getIzquierdo(), min, max, lista);
				lista.insertar(nodo.getElem(), lista.longitud() + 1);
				listarRangoAux(nodo.getDerecho(), min, max, lista);
			}
		}
		return lista;
	}

	public Comparable minimoElem() {
		Comparable elem = null;
		if (!this.esVacio()) {
			elem = minimoElemAux(this.raiz.getIzquierdo());
		}
		return elem;
	}

	private Comparable minimoElemAux(NodoABB nodo) {
		Comparable elem = null;

		if (nodo != null) {
			if (nodo.getIzquierdo() != null) {
				if (nodo.getElem().compareTo(nodo.getIzquierdo().getElem()) > 0) {
					nodo = nodo.getIzquierdo();
					elem = minimoElemAux(nodo);
				}
			} else {
				elem = nodo.getElem();
			}
		}
		return elem;
	}

	public Comparable maximoElem() {
		Comparable elem = null;

		if (!this.esVacio()) {
			elem = maximoElemAux(this.raiz.getDerecho());
		}
		return elem;
	}

	private Comparable maximoElemAux(NodoABB nodo) {
		Comparable elem = null;
		if (nodo != null) {
			if (nodo.getDerecho() != null) {
				if (nodo.getElem().compareTo(nodo.getDerecho().getElem()) < 0) {
					nodo = nodo.getDerecho();
					elem = maximoElemAux(nodo);
				}
			} else {
				elem = nodo.getElem();
			}
		}
		return elem;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	public void preOrden() {
		preOrdenAux(this.raiz);
	}

	private void preOrdenAux(NodoABB nodo) {
		if (nodo != null) {
			System.out.println(nodo.getElem());
			preOrdenAux(nodo.getIzquierdo());
			preOrdenAux(nodo.getDerecho());
		}
	}

	public void inOrden() {
		inOrdenAux(this.raiz);
	}

	private void inOrdenAux(NodoABB nodo) {
		if (nodo != null) {
			inOrdenAux(nodo.getIzquierdo());
			System.out.println(nodo.getElem());
			inOrdenAux(nodo.getDerecho());
		}
	}

	public void posOrden() {
		posOrdenAux(this.raiz);
	}

	private void posOrdenAux(NodoABB nodo) {

		if (nodo != null) {
			posOrdenAux(nodo.getIzquierdo());
			posOrdenAux(nodo.getDerecho());
			System.out.println(nodo.getElem());
		}
	}

	public ArbolBB clone() {
		ArbolBB clon = new ArbolBB();

		if (!this.esVacio()) {
			clon.raiz = cloneAux(this.raiz, clon);
		}
		return clon;
	}

	private NodoABB cloneAux(NodoABB nodo, ArbolBB clon) {
		NodoABB nuevo = null;

		if (nodo != null) {
			nuevo = new NodoABB(nodo.getIzquierdo(), nodo.getDerecho(), nodo.getElem());
		}
		return nuevo;
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

	private String toStringAux(NodoABB nodo) {
		String listado = "";

		if (nodo != null) {
			listado += "Padre: " + nodo.getElem();
			listado += "\n";
			if (nodo.getIzquierdo() != null) {
				listado += "Hijo izquierdo: " + nodo.getIzquierdo().getElem() + " ";
			} else {
				listado += "Hijo izquierdo: No tiene ";
			}
			if (nodo.getDerecho() != null) {
				listado += "Hijo derecho: " + nodo.getDerecho().getElem() + " ";
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

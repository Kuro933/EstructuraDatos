package conjuntistas;

public class AVL {

	private NodoAVL raiz;

	public AVL() {
		raiz = null;
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
		int altura = 0;
		if (this.raiz == null) {
			this.raiz = new NodoAVL(elto);
		} else {
			exito = insertarAux(this.raiz, null, elto);
		}

		return exito;
	}

	private boolean insertarAux(NodoAVL nodo, NodoAVL padre, Comparable elto) {
		boolean exito = true;

		if (elto.compareTo(nodo.getElem()) == 0) {
			exito = false;
		} else {

			if (elto.compareTo(nodo.getElem()) < 0) {
				if (nodo.getIzquierdo() != null) {
					exito = insertarAux(nodo.getIzquierdo(), nodo, elto);
				} else {
					nodo.setIzquierdo(new NodoAVL(elto));
				}
			} else {
				if (nodo.getDerecho() != null) {
					exito = insertarAux(nodo.getDerecho(), nodo, elto);
				} else {
					nodo.setDerecho(new NodoAVL(elto));
				}
			}

			nodo.recalcularAltura();
			equilibrio(nodo, padre);
			
		}
		return exito;
	}

	private void equilibrio(NodoAVL nodo, NodoAVL padre) {

		if (nodo.balance() == 2) {
			System.out.println("llegue a 2 con: " + nodo.getElem());
			if (nodo.getIzquierdo().balance() >= 0) {
				if (padre != null) {
					padre.setIzquierdo(rotacionSimpleDer(nodo));
				} else {
					this.raiz = rotacionSimpleDer(nodo);
					this.raiz.recalcularAltura();
				}
			} else {
				nodo.setIzquierdo(rotacionSimpleIzq(nodo));
				if (padre != null) {
					padre.setDerecho(rotacionSimpleDer(nodo));
				} else {
					this.raiz = rotacionSimpleDer(nodo);
					this.raiz.recalcularAltura();
				}
			}
		}
		if (nodo.balance() == -2) {
			System.out.println("llegue a -2 con: " + nodo.getElem());
			if (nodo.getDerecho().balance() >= 0) {
				nodo.setDerecho(rotacionSimpleDer(nodo));
				if (padre != null) {
					padre.setIzquierdo(rotacionSimpleIzq(nodo));
				} else {
					this.raiz = rotacionSimpleIzq(nodo);
					this.raiz.recalcularAltura();
				}
			} else {
				if (padre != null) {
					padre.setDerecho(rotacionSimpleIzq(nodo));
				} else {
					this.raiz = rotacionSimpleIzq(nodo);
					this.raiz.recalcularAltura();
				}
			}
		}
	}

	private NodoAVL rotacionSimpleDer(NodoAVL nodo) {
		NodoAVL hijo = nodo.getIzquierdo();
		NodoAVL temp = hijo.getDerecho();
		hijo.setDerecho(nodo);
		nodo.setIzquierdo(temp);

		return hijo;
	}

	private NodoAVL rotacionSimpleIzq(NodoAVL nodo) {
		System.out.println("nodo: " + nodo.getElem());
		NodoAVL hijo = nodo.getDerecho();
		System.out.println("hijo : " + hijo.getElem());
		NodoAVL temp = hijo.getIzquierdo();
		hijo.setIzquierdo(nodo);
		nodo.setDerecho(temp);

		return hijo;
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
			listado += "Padre: " + nodo.getElem() + " tiene altura: "
					+ nodo.getAltura();
			listado += " ---> ";
			if (nodo.getIzquierdo() != null) {
				listado += "Hijo izquierdo: " + nodo.getIzquierdo().getElem()
						+ " ";
				// listado += "altura: " + nodo.getAltura() + " ";
			} else {
				listado += "Hijo izquierdo: No tiene ";
			}
			if (nodo.getDerecho() != null) {
				listado += "Hijo derecho: " + nodo.getDerecho().getElem() + " ";
				// listado += "altura: " + nodo.getAltura() + " ";
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

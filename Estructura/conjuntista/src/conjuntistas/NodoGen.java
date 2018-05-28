package conjuntistas;

class NodoGen {
	private NodoGen enlace;
	private Object elem;

	public NodoGen(Object elem) {

		this.enlace = null;
		this.elem = elem;
	}

	public NodoGen(Object elem, NodoGen enlace) {
		this.enlace = enlace;
		this.elem = elem;

	}

	public NodoGen getEnlace() {
		return this.enlace;
	}

	public void setEnlace(NodoGen enlace) {
		this.enlace = enlace;
	}

	public Object getElemento() {
		return this.elem;
	}

	public void setElemento(Object elem) {
		this.elem = elem;
	}
}

package Estructuras;

public class Lista {

		private NodoGen cabecera;
		private int longitud;

		public boolean insertar(Object elemento, int pos) {
			boolean resp = false;
			NodoGen nuevo = new NodoGen(elemento);
			NodoGen aux = this.cabecera;

			if (pos >= 1 && pos <= longitud + 1) {
				if (pos == 1) {
					nuevo.setEnlace(this.cabecera);
					this.cabecera = nuevo;
					resp = true;
					longitud++;
				} else {
					aux = obtenerNodo(pos - 1);
					nuevo.setEnlace(aux.getEnlace());
					aux.setEnlace(nuevo);
					resp = true;
					longitud++;
				}
			}

			return resp;
		}

		public boolean eliminar(int pos) {
			boolean resp = false;
			NodoGen aux = this.cabecera;

			if (pos >= 1 && pos <= longitud + 1) {
				if (pos == 1) {
					this.cabecera = this.cabecera.getEnlace();
					resp = true;
					longitud--;
				} else {
					aux = obtenerNodo(pos - 2);
					aux.setEnlace(aux.getEnlace().getEnlace());
					resp = true;
					longitud--;
				}
			}

			return resp;
		}

		public int localizar(Object elemento) {
			// localiza la posicion de la primera aparicion del elemento dado
			NodoGen aux = this.cabecera;
			boolean seguir = false;
			int pos = Integer.MIN_VALUE, cont = 1;

			while (!seguir && aux != null) {
				if (aux.getElemento().equals(elemento)) {
					seguir = true;
					pos = cont;
				}

				cont++;
				aux = aux.getEnlace();

			}
			return pos;
		}

		public Object recuperar(int pos) {
			// obtiene el elemento en la posicion dada
			Object elem = null;
			NodoGen aux = this.cabecera;
			if (pos >= 1 && pos <= this.longitud) {
				aux = obtenerNodo(pos);
				elem = aux.getElemento();
			} else {
				elem = Integer.MIN_VALUE;
			}

			return elem;

		}

		public int longitud() {
			return longitud;
		}

		public boolean esVacia() {
			return this.cabecera == null;
		}

		public void vaciar() {
			this.cabecera = null;
		}

		@Override
		public Lista clone() {
			Lista clon = new Lista();
			
			if(!this.esVacia()){
				NodoGen aux = new NodoGen(this.cabecera.getElemento());
				clon.cabecera = aux;
				
				aux=this.cabecera.getEnlace();
				NodoGen anterior = clon.cabecera;
				
				while(aux!=null){
					NodoGen nuevo = new NodoGen(aux.getElemento());
					
					anterior.setEnlace(nuevo);
					anterior = anterior.getEnlace();
					
					aux=aux.getEnlace();
				}
			}

			return clon;
		}

		@Override
		public String toString() {

			String s = "";
			NodoGen aux = this.cabecera;

			while (aux != null) {
				s += aux.getElemento() + " ";
				aux = aux.getEnlace();
			}

			return s;
		}

		public NodoGen obtenerNodo(int pos) {
			// recorre la lista para obtener un nodo en la posicion dada
			int i = 1;
			NodoGen aux = this.cabecera;

			while (i < pos && aux != null) {
				aux = aux.getEnlace();
				i++;
			}
			return aux;
		}
	}

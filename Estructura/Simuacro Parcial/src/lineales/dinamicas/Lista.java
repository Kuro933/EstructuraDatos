package lineales.dinamicas;

import lineales.dinamicas.Nodo;

public class Lista {

	private Nodo cabecera;
	private int longitud;

	public Lista() {
		this.cabecera = null;
		this.longitud = 0;
	}

	public boolean insertar(int elem, int pos) {
		boolean resp = false;
		Nodo aux = this.cabecera;
		Nodo nuevo = new Nodo(elem);

		if (pos >= 1 && pos <= this.longitud + 1) {
			if (pos == 1) {
				nuevo.setEnlace(this.cabecera);
				this.cabecera = nuevo;
				longitud++;
				resp = true;
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

	public Nodo obtenerNodo(int pos) {
		Nodo aux = this.cabecera;
		int i = 1;

		while (aux != null && i < pos) {
			aux = aux.getEnlace();
			i++;
		}
		return aux;
	}

	@Override
	public String toString() {

		String s = "";
		Nodo aux = this.cabecera;

		while (aux != null) {
			s += aux.getElto() + " ";
			aux = aux.getEnlace();
		}
		return s;
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

	public int localizar(int elemento) {
		// localiza la posicion de la primera aparicion del elemento dado
		Nodo aux = this.cabecera;
		boolean seguir = false;
		int pos = Integer.MIN_VALUE, cont = 1;

		while (!seguir && aux != null) {
			if (aux.getElto() == elemento) {
				seguir = true;
				pos = cont;
			}

			cont++;
			aux = aux.getEnlace();

		}
		return pos;
	}

	public int recuperar(int pos) {
		// obtiene el elemento en la posicion dada
		int elem = Integer.MIN_VALUE;
		Nodo aux = this.cabecera;
		if (pos >= 1 && pos <= this.longitud) {
			aux = obtenerNodo(pos);
			elem = aux.getElto();
		}

		return elem;

	}

	public boolean eliminar(int pos) {
		boolean resp = false;
		Nodo aux = this.cabecera;

		if (pos >= 1 && pos <= longitud) {
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

	public boolean insertarPromedio() {
		boolean resp = false;
		Nodo aux = this.cabecera;
		Nodo prome = null;
		int cant = 0, total = 0, promedio;

		if (aux != null) {
			while (aux != null) {
				cant++;
				total += aux.getElto();
				prome = aux;
				aux = aux.getEnlace();
			}
			promedio = total / cant;
			Nodo siguiente = new Nodo(promedio);
			prome.setEnlace(siguiente);
			longitud++;
			resp = true;
		}
		return resp;
	}

	public boolean eliminarApariciones(int elto) {
		boolean resp = false;
		Nodo aux = this.cabecera;
		Nodo ant = aux;

		while (aux != null) {
			if (this.cabecera.getElto() == elto) {
				this.cabecera = this.cabecera.getEnlace();
				resp = true;
				longitud--;
			} else if (aux.getElto() == elto) {
				ant.setEnlace(aux.getEnlace());
				longitud--;
				resp = true;

			}
			ant = aux;
			aux = aux.getEnlace();
		}

		return resp;
	}

	public boolean compactar(int n) {
		boolean resp=false;
		if(this.longitud%n==0){
			Nodo aux=this.cabecera;
			Nodo ant=this.cabecera;
			int repeticiones=this.longitud/n;
			int total;
			while(repeticiones>0 && aux!=null){
				total=1;
				int j=n;
				while(j>0){
					total*=aux.getElto();
					aux=aux.getEnlace();
					j--;
					if(j!=1){
						ant.setEnlace(ant.getEnlace());
					}
					repeticiones--;
					ant.setElto(total);
					if(repeticiones==0){
						ant.setEnlace(null);
					}else{
						ant=ant.getEnlace();
					}
				}
				resp=true;
			}
		}
		return resp;
	}
}
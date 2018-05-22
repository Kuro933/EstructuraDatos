package conjuntistas;

public class ArbolHeap {

	private final static int TAM = 20;
	private int ultimo;
	private Comparable[] heap;

	public ArbolHeap() {
		this.ultimo = 0;
		this.heap = new Comparable[TAM - 1];
	}

	public boolean insertar(Comparable elem) {
		boolean exito = false;

		if (this.ultimo < TAM) {

			this.ultimo++;
			this.heap[ultimo] = elem;
			exito = true;
			acomodar(ultimo);
		}
		return exito;
	}

	private void acomodar(int posicion) {
		if (posicion / 2 != 0) {
			Comparable padre = this.heap[posicion / 2];
			Comparable hijo = this.heap[posicion];
			while (padre.compareTo(hijo) > 0 && posicion > 1) {
				Comparable aux = padre;
				this.heap[posicion / 2] = hijo;
				this.heap[posicion] = aux;
				posicion = posicion / 2;
				if (posicion > 1) {
					padre = this.heap[posicion / 2];
					hijo = this.heap[posicion];
				}
			}
		}
	}

	public boolean eliminarCima() {
		boolean exito = false;
		if (this.ultimo != 0) {
			this.heap[1] = this.heap[ultimo];
			this.ultimo--;
			hacerBajar(1);
			exito = true;
		}

		return exito;
	}

	private void hacerBajar(int posicion) {
		int hijoMenor;
		Comparable temp = this.heap[posicion];
		boolean salir = false;

		while (!salir) {
			hijoMenor = posicion * 2;
			if (hijoMenor <= this.ultimo) {
				if (hijoMenor < this.ultimo) {
					if (this.heap[hijoMenor + 1].compareTo(this.heap[hijoMenor]) < 0) {
						hijoMenor++;
					}
				}
				if (this.heap[hijoMenor].compareTo(temp) < 0) {
					this.heap[posicion] = this.heap[hijoMenor];
					posicion = hijoMenor;
				} else {
					salir = true;
				}
			} else {
				salir = true;
			}
		}
		this.heap[posicion] = temp;
	}

	public Comparable recuperarCima() {
		Comparable elem = null;
		if (!esVacio()) {
			elem = this.heap[1];
		}
		return elem;
	}

	public boolean esVacio() {
		return this.ultimo == 0;
	}

	public String toString() {
		String arbol = "";
		int posicion = 1;
		while (posicion < this.ultimo) {
			arbol += "Padre: " + this.heap[posicion];
			arbol += "\n";
			arbol += "Hijo izquierdo: " + this.heap[posicion * 2] + " ";
			arbol += "Hijo derecho: " + this.heap[(posicion * 2) + 1] + " ";

			arbol += "\n";
			posicion++;
		}

		return arbol;
	}
	/*este String es por si lo quieren como un arreglo
	un ejemplo de como quedaria seria |1|2|3|4|
	 public String toString() {
	 String arbol = "";
	 arbol += "|";
	 for (int i = 1; i <= this.ultimo; i++) {
	 arbol += this.heap[i] + "|";
	 }
	 return arbol;
	*/ }

}

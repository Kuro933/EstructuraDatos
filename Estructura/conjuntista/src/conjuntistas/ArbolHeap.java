package conjuntistas;

public class ArbolHeap {

	private final static int TAM = 20;
	private int ultimo;
	private int[] heap;

	public ArbolHeap() {
		this.ultimo = 0;
		this.heap = new int[TAM - 1];
	}

	public boolean insertar(int elto) {
		boolean exito = false;
		
		
		return exito;
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
		int temp = this.heap[posicion];
		boolean salir = false;

		while (!salir) {
			hijoMenor = posicion * 2;
			if (hijoMenor <= this.ultimo) {
				if (hijoMenor < this.ultimo) {
					if (this.heap[hijoMenor + 1] < this.heap[hijoMenor]) {
						hijoMenor++;
					}
				}
				if (this.heap[hijoMenor] < temp) {
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

	public int recuperarCima() {
		int elem=Integer.MIN_VALUE;
		if(!esVacio()){
			elem=this.heap[1];	
		}
		return elem;
	}

	public boolean esVacio(){
		return this.ultimo==0;
	}
	
	public String toString() {
		String arbol = "";
		int posicion = 1;
		while(posicion <= TAM){
		if (!esVacio()) {
			arbol += "Padre: " + this.heap[posicion];
			arbol += "\n";
			arbol += "Hijo izquierdo: " + this.heap[posicion*2] + " ";
			arbol += "Hijo derecho: " + this.heap[(posicion*2)+1] + " ";

			}
			arbol += "\n";
			posicion++;
		}
		return arbol;
	}

}

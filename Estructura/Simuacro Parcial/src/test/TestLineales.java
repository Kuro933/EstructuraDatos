package test;

import utiles.TecladoIn;
import lineales.dinamicas.ColaChar;

public class TestLineales {

	public static void main(String[] args) {
		ColaChar cola = new ColaChar();
		int opcion;

		do {
			menu();
			opcion = TecladoIn.readLineInt();

			switch (opcion) {
			// Menu de opciones
			case 1:// agrega un elemento a la cola
				nuevoElemento(cola);
				break;
			case 2:colaGenerar(cola);
				break;
			default:
				System.out.println("Opcion invalida");
			}

		} while (opcion != -1);

	}

	public static void nuevoElemento(ColaChar cola) {
		// carga un nuevo elemento a la pila
		int cant, i = 1;
		char elto;
		System.out.print("Cuantos elemento desea ingresa: ");
		cant = TecladoIn.readLineInt();
		while (i <= cant) {
			System.out.println("Ingrese elemento: ");
			elto = TecladoIn.readLineNonwhiteChar();
			if (cola.poner(elto)) {
				System.out.println("elemento ingresado");
			} 
			i++;
		}
	}

	public static ColaChar clonacion(ColaChar arr) {
		// permite clonar una cola
		ColaChar clon = new ColaChar();
		clon = arr.clone();
		return clon;
	}
	
	public static ColaChar colaGenerar(ColaChar c1){
		ColaChar generada = new ColaChar();
		

		
		return generada;
	}

	public static void menu() {
		System.out.println("_____________________________MENU_________________________________");
		System.out.println("1. Agregar un nuevo elemento a la cola");
		System.out.println("2. Agregar una operacion a la pila");
		System.out.println("3. calcula las operaciones de la pila con los elementos de la cola");
		System.out.println("__________________________________________________________________" + "\n");
		System.out.print("Ingrese la opcion deseada (-1 para salir): ");
	}
}

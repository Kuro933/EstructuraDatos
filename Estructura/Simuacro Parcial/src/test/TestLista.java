package test;

import utiles.TecladoIn;
import lineales.dinamicas.Lista;

public class TestLista {

	public static void main(String[] args) {
		Lista list = new Lista();
		int opcion;

		do {
			menu();
			System.out.print("Ingrese opcion: ");
			opcion = TecladoIn.readLineInt();

			switch (opcion) {
			case 1:
				ingresarValores(list);
				break;

			case 2:
				mostrar(list);
				break;
			case 3:
				System.out.println("en que posicion esta el numero: " + localizar(list));
				break;
			case 4:list.vaciar();
			System.out.println("Lista vaciada");
			break;
			case 5:System.out.println("el elemento es: " +recuperar(list));
			break;
			case 6: if(list.insertarPromedio()){
				System.out.println("Se pudo aniadir el promedio al final");
			}else{
				System.out.println("La estructura esta vacia");
			}
			break;
			case 7:if(!list.esVacia()){
				eliminarElemento(list);
				System.out.println("el elemento y sus repeticiones fueron eliminadas");
			}else{
				System.out.println("la estructura esta vacia");
			}
			break;
			case 8: if(!list.esVacia()){
				System.out.println("Ingresa n");
				int n=TecladoIn.readLineInt();
				list.compactar(n);
			}
			}
		} while (opcion != -1);

	}
	
	public static int recuperar(Lista list){
		int elemento, buscado;
		
		System.out.println("que posicion desea recuperar el elemento");
		buscado = TecladoIn.readLineInt();
		
		elemento = list.recuperar(buscado);
		
		return elemento;
	}
	
	public static int localizar(Lista list){
		int pos, elem;
		
		System.out.println("que elemento busca: ");
		elem = TecladoIn.readLineInt();
		
		pos = list.localizar(elem);
		
		return pos;
	}
	
	public static boolean eliminarElemento(Lista list){
		int elemento;
		boolean resp;
		System.out.println("Que elemento desea eliminar");
		elemento = TecladoIn.readLineInt();
		resp = list.eliminarApariciones(elemento);
		return resp;
	}

	public static void menu() {
		System.out.println("--------------menu--------------");
		System.out.println("1. ingrese valores");
		System.out.println("2. muestre todo");
		System.out.println("3. buscar en que posicion esta un numero");
		System.out.println("4. vacia la lista");
		System.out.println("5. recupera un elemento en la posicion dada");
		System.out.println("6. inserta en la ultima posicion el promedio de todos los elementos");
		System.out.println("7. elimina todos los elementos repetidos");
	}

	public static void insertar(Lista list){
		list.insertar(1, 1);
		list.insertar(2, 2);
		list.insertar(3, 3);
		list.insertar(4, 4);
		list.insertar(5, 5);
		list.insertar(6, 6);
		list.insertar(7, 7);
		list.insertar(8, 8);
	}
	
	public static void ingresarValores(Lista list) {
		int cant, numero, cont = 1, pos;
		boolean seguir = true;
		System.out.println("ingrese cuantos numeros poner");
		cant = TecladoIn.readLineInt();
		while (seguir && cont <= cant) {
			System.out.println("ingrese");
			numero = TecladoIn.readLineInt();
			System.out.println("posicion?");
			pos = TecladoIn.readLineInt();
				if (list.insertar(numero, pos)) {
					System.out.println("Elemento ingresado");
					cont++;
				} else {
					System.out.println("Posicion invalida");
					seguir = false;
				}
			}
		}

	public static void mostrar(Lista list) {

		System.out.println(list.toString());

	}

}
package test;

import utiles.TecladoIn;
import lineales.dinamicas.Lista;
import java.util.Scanner;

public class TestLista {

	public static void main(String[] args) {
		Lista<Integer> list = new Lista<Integer>();
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
			}
		} while (opcion != -1);

	}

	public static void menu() {
		System.out.println("--------------menu--------------");
		System.out.println("1. ingrese valores");
		System.out.println("2. muestre todo");
	}

	public static void ingresarValores(Lista<Integer> list) {
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

	public static void mostrar(Lista<Integer> list) {

		System.out.println(list.toString());

	}

}
package test.jerarquicas;

import jerarquicas.ArbolBinario;
public class TestArbol {

	public static void main(String[] args){
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
		ArbolBinario<Integer> clon = new ArbolBinario<Integer>();
		cargarArbol(arbol);
		
		System.out.println("el arbol es: " +arbol.toString());
		
		clon = arbol.clonarInvertido();
		System.out.println("este es el clon:" + clon.toString());
		
	}
	
	public static void cargarArbol(ArbolBinario<Integer> arbol){
		arbol.insertar(1, 1, 'I');
		arbol.insertar(2, 1, 'I');
		arbol.insertar(3, 1, 'D');
		arbol.insertar(4, 2, 'I');
		arbol.insertar(5, 2, 'D');
		arbol.insertar(6, 5, 'I');
		arbol.insertar(9, 5, 'D');
		arbol.insertar(10, 6, 'D');
		arbol.insertar(12, 3, 'I');
		arbol.insertar(14, 3, 'D');
		arbol.insertar(18, 14, 'D');
	}
}

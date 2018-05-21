package test.jerarquicas;
import jerarquicas.ArbolGen;
public class testGen {
	
	public static void main(String[] args){
		ArbolGen arbol = new ArbolGen();
		
		cargar(arbol);
		
		System.out.println("el arbol es: " + arbol.toString());
		
		System.out.println("Pertenece: " + arbol.pertenece(15));
		System.out.println("padre de 5:" + arbol.padre(5));
	}
	
	public static void cargar(ArbolGen arbol){
		arbol.insertar(1, 1);
		arbol.insertar(2, 1);
		arbol.insertar(3, 1);
		arbol.insertar(4, 1);
		arbol.insertar(5, 1);
		arbol.insertar(6, 2);
		arbol.insertar(8, 4);
		arbol.insertar(9, 2);
		arbol.insertar(14, 5);
		arbol.insertar(15, 14);
	}

	}

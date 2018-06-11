package TestParcial;
import Estructuras.Lista;
import Estructuras.ArbolBB;
import Estructuras.ArbolGen;
public class testParcial {
	
	public static void main(String[] args){
		Lista lista = new Lista();
		ArbolGen arbolito = new ArbolGen();
		ArbolBB arbolBB = new ArbolBB();
		cargarArbol(arbolito);
		cargarLista(lista);
		cargarABB(arbolBB);
		
		System.out.println(arbolito.toString() + "\n");
		arbolito.eliminar(27);
		
		System.out.println(arbolito.toString());
		
		
//		ArbolBB clon=arbolBB.clonarParteInvertida(13);
		
//		System.out.println(clon.toString());
//		System.out.println(arbolBB.eliminarMinimo());
//		System.out.println(arbolBB.toString());
		
//		System.out.println(arbolito.toString()+ "\n");
//		System.out.println(lista.toString());
//		
//		
//		System.out.println(arbolito.verificarCamino(lista));
//		System.out.println(arbolito.listarEntreNivel(1,	 2));
	}
	
	public static void cargarABB(ArbolBB arbolBB){
		arbolBB.insertar(56);
		arbolBB.insertar(13);
		arbolBB.insertar(78);
		arbolBB.insertar(7);
		arbolBB.insertar(24);
		arbolBB.insertar(15);
		arbolBB.insertar(100);
	}
	
	public static void cargarArbol(ArbolGen arbol){
		arbol.insertar(20, 1);
		arbol.insertar(54, 20);
		arbol.insertar(13, 20);
		arbol.insertar(12, 13);
		arbol.insertar(15, 13);
		arbol.insertar(4, 54);
		arbol.insertar(27, 54);
		arbol.insertar(11, 54);
		arbol.insertar(17, 27);
	}
	
	public static void cargarLista(Lista lista){
		lista.insertar(20, 1);
		lista.insertar(17, 2);
//		lista.insertar(12, 3);
//		lista.insertar(45, 4);
		
	}

}

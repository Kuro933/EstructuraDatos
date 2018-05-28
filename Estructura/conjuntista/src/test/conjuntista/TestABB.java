package test.conjuntista;
import conjuntistas.ArbolBB;

public class TestABB {
	
	public static void main(String[] args){
		ArbolBB arbol = new ArbolBB();
		ArbolBB clon = new ArbolBB();
		cargar(arbol);
		
//		System.out.println("el minimo es: " + arbol.minimoElem());
//		System.out.println("el maximo es: " + arbol.maximoElem());
		System.out.println(arbol.lista());
		
//		System.out.println("pertenece : "+ arbol.pertenece(45));
//		
//		System.out.println("el arbol de forma ordenada quedaria de la siguiente forma: " +arbol.lista());
//		
//		System.out.println(arbol.listarRango(30, 60));
		arbol.eliminar(13);
		System.out.println(arbol.lista());
		
//		clon= arbol.clone();
//		
//		System.out.println(clon.toString());
	}
	
	public static void cargar(ArbolBB arbol){
		arbol.insertar(45);
		arbol.insertar(34);
		arbol.insertar(65);
		arbol.insertar(13);
		arbol.insertar(55);
		arbol.insertar(73);
		arbol.insertar(96);
	}

}

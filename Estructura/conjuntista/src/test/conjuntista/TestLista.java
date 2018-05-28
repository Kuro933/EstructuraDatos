package test.conjuntista;
import conjuntistas.Lista;
public class TestLista {
	
	public static void main(String[] args){
		Lista lista = new Lista();
		
		cargar(lista);
		
		System.out.println(lista.toString());
		Lista clon = lista.clone();
		
		System.out.println("clonada :" + clon.toString());
	}
	
	public static void cargar(Lista lista){
		lista.insertar(1,1);
		lista.insertar(2,1);
		lista.insertar(3,1);
		lista.insertar(4,1);
	}

}

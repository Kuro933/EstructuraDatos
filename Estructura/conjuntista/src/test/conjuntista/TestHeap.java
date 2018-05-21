package test.conjuntista;
import conjuntistas.ArbolHeap;
import utiles.TecladoIn;
public class TestHeap {
	
	public static void main(String[] args){
	ArbolHeap arbol = new ArbolHeap();

	cargar(arbol);
	System.out.println(arbol.recuperarCima());
	
	System.out.println(arbol.toString());
	}
	
	public static void cargar(ArbolHeap arbol){
		
		System.out.println("cuantos ingresan?: ");
		int cant = TecladoIn.readLineInt();
		int cont=0;
		while(cont < cant){
			System.out.println("ingrese el elemento amigo: ");
			int elto = TecladoIn.readLineInt();
			arbol.insertar(elto);
			cont++;
		}
	}
}

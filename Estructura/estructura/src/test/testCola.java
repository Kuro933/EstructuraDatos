package test;

import lineales.dinamicas.ColaChar;

public class testCola {
	
	public static void main(String[] args) {

		ColaChar c1 = new ColaChar();

		System.out.println(invertir("HOLA"));
		insertar(c1);
		
		System.out.println("la cola generada queda: " + generar(c1).toString());

	}

	public static void insertar(ColaChar c1) {

		c1.poner('A');
		c1.poner('B');
		c1.poner('#');
		c1.poner('C');
		c1.poner('#');
		c1.poner('D');
		c1.poner('E');
		c1.poner('F');
	}

	public static ColaChar generar(ColaChar c1) {
		ColaChar generada = new ColaChar();
		String aux = "";

		while (!c1.esVacia()) {
			if (c1.obtenerFrente() != '#') {
				aux += c1.obtenerFrente();
				c1.sacar();
			} else {
				aux = aux + invertir(aux) + aux;
			
				for (int i = 0; i < aux.length(); i++) {
					generada.poner(aux.charAt(i));
				}
				generada.poner('#');
				c1.sacar();
				aux = "";
			}
		}
		aux = aux + invertir(aux) + aux;
		for (int i = 0; i < aux.length(); i++) {
			generada.poner(aux.charAt(i));
		}

		return generada;
	}

	public static String invertir(String frase) {
		String invertido = "";
		int longitud = frase.length();

		for (int i = longitud - 1; i >= 0; i--) {
			invertido += frase.charAt(i);
		}

		return invertido;
	}

}

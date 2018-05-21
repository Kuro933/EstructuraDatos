package lineales.dinamicas;


public class ColaChar {

    private NodoChar frente;
    private NodoChar fin;

    public ColaChar() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(char elem) {
        NodoChar nuevo = new NodoChar(elem);

        if (this.esVacia()) {
            this.frente = nuevo;
        } else {
            this.fin.setEnlace(nuevo);
        }
        this.fin = nuevo;

        return true;
    }

    public boolean sacar() {
        boolean exito = (this.frente != null);

        if (exito) {
            this.frente = this.frente.getEnlace();

            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public char obtenerFrente() {
        char res = ' ';

        if (!this.esVacia()) {
            res = this.frente.getElem();
        }

        return res;
    }

    public boolean esVacia() {
        return (this.frente == null);
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    public ColaChar clone() {
        ColaChar nueva = new ColaChar();

        if (!this.esVacia()) {
            NodoChar aux = new NodoChar(this.frente.getElem());
            nueva.frente = aux;

            aux = this.frente.getEnlace();
            nueva.fin = nueva.frente;

            while (aux != null) {
                NodoChar nuevo = new NodoChar(aux.getElem());

                nueva.fin.setEnlace(nuevo);
                nueva.fin = nueva.fin.getEnlace();

                aux = aux.getEnlace();
            }
        }
        return nueva;
    }

    public String toString() {
        String s = "[]";
        char elem = ' ';

        if (!this.esVacia()) {
            s = "[";
            NodoChar aux = this.frente;

            while (aux != null) {
                elem = aux.getElem();
                s += elem;
                aux = aux.getEnlace();
            if (aux != null) {
            	s += ", ";
            }
			}
            }
            s += "]";
        
        return s;

    }
}

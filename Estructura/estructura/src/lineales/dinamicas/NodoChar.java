/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author nacho
 */
public class NodoChar {
    
    private char elem; 
    private NodoChar enlace;
    
    public NodoChar (char elem){
        this.elem = elem;
    }
    
    public NodoChar (char elem, NodoChar siguiente){
        this.elem = elem;
        this.enlace = siguiente;
    }
    
    public char getElem (){
        return this.elem;
    }
    
    public NodoChar getEnlace (){
        return this.enlace;
    }
    
    public void setElem (char elem){
        this.elem = elem;        
    }
    
    public void setEnlace (NodoChar siguiente){
        this.enlace = siguiente;
    }
    
}

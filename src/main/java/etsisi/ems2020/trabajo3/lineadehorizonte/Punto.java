package etsisi.ems2020.trabajo3.lineadehorizonte;

import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * 
 * @author Juan Manuel
 * Clase para definir un punto sobre el eje
 * cartesiano de coordendas
 */
public class Punto {
	int x;
    int y;

    /*
     * Constructor sin par�metros de un punto en concreto
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }
    
    /*
     * Constructos con par�metros de un punto
     * @param x
     * @param y
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /*
     * 
     * Get de la coordenada X
     */
    public int getX() {
        return x;
    }
    /*
     * 
     * Set de la coordenada X
     */
    public void setX(int x) {
        this.x = x;
    }
    /*
 	   Get de la coordenada Y
     */
    public int getY() {
        return y;
    }
    /* 
     * Set de la coordenada Y
     */
    public void setY(int y) {
        this.y = y;
    }

	@Override
	public String toString() {
		return "Punto [x="+ x + ", y="+ y +  "]";
	}

	public void actualizarPunto( int x, int y){
        this.x = x;
        this.y = y;
    }

    public void imprimirPunto(PrintWriter out){
        out.print(this.x);
        out.print(" ");
        out.print(this.y);
        out.println();
    }
    public int comprobarVacioAux(int prev, LineaHorizonte salida){
        int aux = prev;
        if (this.y != prev)
        {
            salida.addPunto(this);
            aux = this.y;

        }
        return aux;
    }
    
    
}

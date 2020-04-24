package etsisi.ems2020.trabajo3.lineadehorizonte;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.log4j.Logger;


public class LineaHorizonte {
	
	private static final Logger LOG = Logger.getLogger(LineaHorizonte.class);
	
	private ArrayList <Punto> lineaHorizonte ;
	
    /*
     * Constructor sin par�metros
     */
    public LineaHorizonte()
    {
        lineaHorizonte = new ArrayList <Punto>();
    }
            
    /*
     * m�todo que devuelve un objeto de la clase Punto
     */
    public Punto getPunto(int i) {
        return (Punto)this.lineaHorizonte.get(i);
    }
    
    // A�ado un punto a la l�nea del horizonte
    public void addPunto(Punto p)
    {
        lineaHorizonte.add(p);
    }    
    
    // m�todo que borra un punto de la l�nea del horizonte
    public void borrarPunto(int i)
    {
        lineaHorizonte.remove(i);
    }
    
    //Metodo que dvuelve el tamano de lineaHorizonte
    public int size()
    {
        return lineaHorizonte.size();
    }
    // m�todo que me dice si la l�nea del horizonte est� o no vac�a
    public boolean isEmpty()
    {
        return lineaHorizonte.isEmpty();
    }
   
    /*
      M�todo al que le pasamos una serie de par�metros para poder guardar 
      la linea del horizonte resultante despu�s de haber resuelto el ejercicio
      mediante la t�cnica de divide y vencer�s.
     */
    
    public void guardaLineaHorizonte (String fichero)
    {
        try
        {
            Punto p;
            FileWriter fileWriter = new FileWriter(fichero);
            PrintWriter out = new PrintWriter (fileWriter);
         
            for(int i=0; i<this.size(); i++)
            {
                p=(getPunto(i));
                p.imprimirPunto(out);
            }
            out.close();
        }
        catch(Exception e){}
    }
    
    //Metodo que  imprime por pantalla toda la informacion
    public void imprimir (){
    	
    	for(int i=0; i< lineaHorizonte.size(); i++ ){
    		LOG.info(cadena(i));
    		System.out.println(cadena(i));
    	}
    }
    
    //Metodo que devuelve el string de los datos de lineaHorizonte
    public String cadena (int i){
    	Punto p = lineaHorizonte.get(i);
    	int x = p.getX();
    	int y = p.getY();
    	String linea = "Punto [x="+ x + ", y="+ y +  "]";
		return linea;
    }
}
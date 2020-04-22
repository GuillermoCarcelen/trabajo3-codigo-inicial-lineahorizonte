package etsisi.ems2020.trabajo3.lineadehorizonte;


import org.apache.log4j.Logger;

public class FusionaLineasHorizontes {
	
	private static final Logger LOG = Logger.getLogger(FusionaLineasHorizontes.class);

    private int prev ,s1y , s2y ;
    LineaHorizonte salida;

	public FusionaLineasHorizontes() {
		this.s1y = -1;
		this.s2y = -1;
		this.prev = -1;
		this.salida = new LineaHorizonte(); 
	}
	
    public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getS1y() {
		return s1y;
	}

	public void setS1y(int s1y) {
		this.s1y = s1y;
	}

	public int getS2y() {
		return s2y;
	}

	public void setS2y(int s2y) {
		this.s2y = s2y;
	}

	public LineaHorizonte getSalida() {
		return salida;
	}

	public void setSalida(LineaHorizonte salida) {
		this.salida = salida;
	}



	public LineaHorizonte fusion(LineaHorizonte s1, LineaHorizonte s2){


    	// en estas variables guardaremos las alturas de los puntos anteriores, en s1y la del s1, en s2y la del s2 
    	// y en prev guardaremos la previa del segmento anterior introducido
        //int s1y=-1, s2y=-1, prev=-1;    
        //LineaHorizonte salida = new LineaHorizonte(); // LineaHorizonte de salida
        
        Punto p1 = new Punto();         // punto donde guardaremos el primer punto del LineaHorizonte s1
        Punto p2 = new Punto();         // punto donde guardaremos el primer punto del LineaHorizonte s2
        
        
        
        //Mientras tengamos elementos en s1 y en s2
        while ((!s1.isEmpty()) && (!s2.isEmpty())) 
        {
            //paux = new Punto();  // Inicializamos la variable paux
            p1 = s1.getPunto(0); // guardamos el primer elemento de s1
            p2 = s2.getPunto(0); // guardamos el primer elemento de s2

            if ( menorValorX(p1.getX(), p2.getX()) ) 
			{
				s1y=anadirFusion(p1,this.s2y, s1);
			} else if (  !( menorValorX(p1.getX(), p2.getX()) )  ) 
			{
				s2y=anadirFusion(p2,this.s1y, s2);
			}else // si la X del s1 es igual a la X del s2
            {
            	actualizarLineaHorizonte(p1, p2);
				this.s1y=actualizarPunto(s1,p1);
				this.s2y=actualizarPunto(s2,p2);
            }
        }
        comprobarVacio(s1);
        comprobarVacio(s2);
        return this.salida;
	}

	private void actualizarLineaHorizonte(Punto p1, Punto p2){

		if ((p1.getY() > p2.getY()) && (p1.getY() != this.prev)) {
			guardarActualizarLineaHorizonte(p1);
		}
		if ((p1.getY() <= p2.getY()) && (p2.getY() != this.prev)) {
			guardarActualizarLineaHorizonte(p2);
		}
		

	}
	


	//************************************************************************************************************************************************** */
	private int anadirFusion(Punto p,int sy,LineaHorizonte s) {
		
		Punto paux = new Punto();
		
		paux.setX(p.getX()); 
		paux.setY(Math.max(p.getY(), sy)); 

		if (paux.getY() != this.prev) 
		{
			guardarActualizarLineaHorizonte(paux); 
		}
		//sy = p.getY(); 
		return actualizarPunto(s,p);
	
	}

	/*Funcion que guarda parte del resultado (paux) en la salida final y actualiza*/
	private void guardarActualizarLineaHorizonte(Punto paux) {
		
		this.salida.addPunto(paux); 
		this.prev = paux.getY(); 
	
	}


	/*Funcion que actualiza la altura de s2y y elimina el punto de s2*/
	private int actualizarPunto(LineaHorizonte s,Punto p) {
		
		s.borrarPunto(0); 
		return p.getY(); 
		
	
	}
	
	private boolean menorValorX(int valor1, int valor2){

		return valor1 < valor2;


	}
	
	
	private void comprobarVacio(LineaHorizonte s) {
		
		Punto paux;
		while ((!s.isEmpty())) // si aun nos quedan elementos en el s2
		{
			paux = s.getPunto(0); // guardamos en paux el primer punto

			if (paux.getY() != this.prev) // si paux no tiene la misma altura del segmento previo
			{
				this.salida.addPunto(paux); // lo añadimos al LineaHorizonte de salida
				this.prev = paux.getY(); // y actualizamos prev
			}
			s.borrarPunto(0); // en cualquier caso eliminamos el punto de s2 (tanto si se añade como si no es
								// valido)
		}
	
	}

}
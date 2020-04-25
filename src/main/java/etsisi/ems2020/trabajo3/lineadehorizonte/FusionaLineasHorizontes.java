package etsisi.ems2020.trabajo3.lineadehorizonte;



public class FusionaLineasHorizontes {
	

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
        
        Punto p1;       // punto donde guardaremos el primer punto del LineaHorizonte s1
        Punto p2;   // punto donde guardaremos el primer punto del LineaHorizonte s2
        

        while ((!s1.isEmpty()) && (!s2.isEmpty())) 
        {

            p1 = s1.getPunto(0);
            p2 = s2.getPunto(0);

			int x1=p1.getX();
			int x2=p2.getX();

			int y1=p1.getY();
			int y2=p2.getY();

            if ( menorValorX(x1, x2) )
			{
				s1y=anadirFusion(x1, y1, this.s2y);
				s1.borrarPunto(0);
			} else if (  !( menorValorX(x1, x2) )  )
			{
				s2y=anadirFusion(x2, y2, this.s1y);
				s2.borrarPunto(0);

			}else
            {
            	actualizarLineaHorizonte(p1, p2);
				s2.borrarPunto(0);
				s1.borrarPunto(0);
            	this.s1y=y1;
            	this.s2y=y2;

            }
        }
        comprobarVacio(s1);
        comprobarVacio(s2);
        return this.salida;
	}

	private void actualizarLineaHorizonte(Punto p1, Punto p2){
		int y1=p1.getY();
		int y2=p2.getY();

		if ((y1 > y2) && (y1 != this.prev)) {
			guardarActualizarLineaHorizonte(p1, y1);
		}
		if ((y1 <= y2) && (y2 != this.prev)) {
			guardarActualizarLineaHorizonte(p2, y2);
		}
		

	}
	


	//************************************************************************************************************************************************** */
	private int anadirFusion(int x, int y, int sy) {

		int puntoY = Math.max(y, sy);
		Punto paux = new Punto(x, puntoY);

		if (puntoY!= this.prev)
		{
			guardarActualizarLineaHorizonte(paux, puntoY);
		}
		return y;
	}

	/*Funcion que guarda parte del resultado (paux) en la salida final y actualiza*/
	private void guardarActualizarLineaHorizonte(Punto paux, int pauxY) {
		
		this.salida.addPunto(paux); 
		this.prev = pauxY;
	
	}

	
	private boolean menorValorX(int valor1, int valor2){

		return valor1 < valor2;


	}
	
	
	private void comprobarVacio(LineaHorizonte s) {
		
		Punto paux;
		while ((!s.isEmpty()))
		{
			paux = s.getPunto(0);
			this.prev = paux.comprobarVacioAux(this.prev, this.salida);
			s.borrarPunto(0);

		}
	
	}

}
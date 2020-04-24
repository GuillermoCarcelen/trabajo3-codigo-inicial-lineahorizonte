package etsisi.ems2020.trabajo3.lineadehorizonte;

import java.io.FileWriter; 
import java.io.PrintWriter;
import org.apache.log4j.Logger;

public class Main {
	public static void Main(String[] args) {
		
		/*
		 Empezamos a ejecutar el c�digo para intentar hacer el ejercicio
		 que nos piden, calcular la l�nea del horizonte de una ciudad.
		 */
        Ciudad c = new Ciudad();
        c.cargarEdificios("ciudad1.txt");

        LineaHorizonte linea = c.getLineaHorizonte();
        
        linea.guardaLineaHorizonte("salida.txt");
        System.out.println("-- Proceso finalizado Correctamente --");
	}

}

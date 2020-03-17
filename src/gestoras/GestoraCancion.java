package gestoras;
import java.util.Random;

import Utiles.Utiles;
import clasesbasicas.Cancion;

public class GestoraCancion {

									//Interfaz
	/******************************************************************************
	 * Función que genera una cantidad definida por el usuario de instancias de la
	 * clase Cancion.
	 * Signatura: public Cancion[] generarCanciones(int cantidad); 
	 * Entradas: -int cantidad
	 * Precondiciones: La cantidad debe ser mayor que 0. 
	 * Salidas: - Cancion[] cancion.
	 * Postcondiciones: Devuelve un array de tipo Cancion con una cantidad de
	 * 					instancias de canciones.
	 ******************************************************************************/
	public static Cancion[] generarCanciones(int cantidad)
	{
		Random aleatorio = new Random();
		
		String nombre, autor;
		int voto;
		
		Cancion[] cancion = new Cancion[cantidad];
		
		for(int i = 0; i < cancion.length; i++)
		{
			nombre = Utiles.generarCadena(6);
			autor = Utiles.generarCadena(6);
			voto = aleatorio.nextInt(101);
			
			cancion[i] = new Cancion(nombre, autor, voto);
		}
		
		return cancion;
	}

}

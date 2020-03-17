package Utiles;
import java.util.Random;

public class Utiles {
										//Interfaz
	/******************************************************************************
	* Función que genera una cadena aleatoria de una longitud fija.
	* Signatura: public String generarCadena(int longitud); 
	* Entradas:
	* 		- int longitud
	* Precondiciones: La longitud debe ser mayor que 0. 
	* Salidas: 
	* 		- String cadena
	* Postcondiciones: Devuelve una cadena de una longitud fija asociada al nombre
	******************************************************************************/
	public static String generarCadena(int longitud)
	{
		Random aleatorio = new Random();
		
		String cadena = "";
		
		for (int j = 0; j <= longitud; j++)
		{
			if (j == 0)
			{
				cadena += (char)(aleatorio.nextInt(26) + 65);
			}
			else
			{
				cadena += (char)(aleatorio.nextInt(26) + 97);
			}
		}
		
		return cadena;
		
	}
}
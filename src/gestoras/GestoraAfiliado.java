package gestoras;

import java.util.Random;

import Utiles.Utiles;
import clasesbasicas.Afiliado;
import enums.TypeActivity;

public class GestoraAfiliado {
	
									//Interfaz
	/******************************************************************************
	* Función que genera una cantidad definida por el usuario de instancias de la
	* clase Afiliado.
	* Signatura: public Afiliado[] generarCanciones(int cantidad); 
	* Entradas: 
	* 		- int cantidad
	* Precondiciones: La cantidad debe ser mayor que 0. 
	* Salidas: 
	* 		- Afiliado[] afiliado.
	* Postcondiciones: Devuelve un array de tipo Afiliado con una cantidad de
	* 					instancias de afiliados.
	******************************************************************************/
	public static Afiliado[] generarAfiliados(int cantidad)
	{
		Random aleatorio = new Random();
		
		String surnameName;
		TypeActivity typeActivity;
		double weight;
		
		Afiliado[] afiliado = new Afiliado[cantidad];
		
		for(int i = 0; i < afiliado.length; i++)
		{
			surnameName = Utiles.generarCadena(6);
			surnameName += " "+Utiles.generarCadena(6);
			typeActivity = generarTypeActivity();
			weight = aleatorio.nextInt(81) + 40;
			
			afiliado[i] = new Afiliado(surnameName, typeActivity, weight);
		}
		
		return afiliado;
	}
	
									//Interfaz
	/******************************************************************************
	* Función que genera un typeActivity aleatorio.
	* Signatura: public TypeActivity generarTypeActivity(); 
	* Entradas: No hay
	* Precondiciones: No hay
	* Salidas: 
	* 		- TypeActivity typeActivity.
	* Postcondiciones: Devuelve una variable TypeActivity con un valor aleatorio
	* 				   asociado al nombre.
	******************************************************************************/
	public static TypeActivity generarTypeActivity()
	{
		Random aleatorio = new Random();
		
		TypeActivity typeActivity = null;
		
		int aux = aleatorio.nextInt(3);
		
		switch(aux)
		{
			case 0:
				
				typeActivity = TypeActivity.LOW;
				
			break;
			case 1:
				
				typeActivity = TypeActivity.MEDIUM;
				
			break;
			case 2:
				
				typeActivity = TypeActivity.HIGH;
				
		}
		
		return typeActivity;
	}
}

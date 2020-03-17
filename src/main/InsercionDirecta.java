package main;

import Utiles.MetodosPolimorficos;
import clasesbasicas.Afiliado;
import clasesbasicas.Cancion;
import gestoras.GestoraAfiliado;
import gestoras.GestoraCancion;

public class InsercionDirecta {

	public static void main(String[] args) {
		
		Cancion[] canciones = GestoraCancion.generarCanciones(100);
		Afiliado[] afiliados = GestoraAfiliado.generarAfiliados(100);
		
		MetodosPolimorficos.insercionDirecta(canciones);
		
		for(Cancion cancion : canciones)
		{
			System.out.println(cancion);
		}
		
		System.out.println(" \n");
		
		MetodosPolimorficos.insercionDirecta(afiliados);
		
		for(Afiliado afiliado : afiliados)
		{
			System.out.println(afiliado);
		}
	}

}

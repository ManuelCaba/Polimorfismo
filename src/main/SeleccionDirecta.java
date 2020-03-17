package main;

import Utiles.MetodosPolimorficos;
import clasesbasicas.Afiliado;
import clasesbasicas.Cancion;
import gestoras.GestoraAfiliado;
import gestoras.GestoraCancion;

public class SeleccionDirecta {

	public static void main(String[] args) {
		
		Cancion[] canciones = GestoraCancion.generarCanciones(100);
		Afiliado[] afiliados = GestoraAfiliado.generarAfiliados(100);
		
		MetodosPolimorficos.seleccionDirecta(canciones);
		
		for(Cancion cancion : canciones)
		{
			System.out.println(cancion);
		}
		
		System.out.println("\n");
		
		MetodosPolimorficos.seleccionDirecta(afiliados);
		
		for(Afiliado afiliado : afiliados)
		{
			System.out.println(afiliado);
		}
	}

}

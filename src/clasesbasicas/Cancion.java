package clasesbasicas;
/*
 * Clase Cancion:
 * 
 * Propiedades b�sicas:
 * 		
 * 				ID --> tipo int, consultable
 * 				nombre --> tipo String, consultable
 * 				artista --> tipo String, consultable
 * 				voto --> tipo int, consultable
 * 
 * Propiedades derivadas: No hay
 * 
 * Propiedades compartidas
 * 
 * 				incrementoID: tipo int
 * 
 * INTERFAZ
 * 
 * Get y Set:
 * 		
 * 		int getID();
 * 		
 * 		String getNombre();
 * 
 * 		String getArtista();
 * 
 * 		int getVoto();
 * 
 * Restricciones:
 * 
 * 		El ID se genera secuencialmente a partir de 1
 * 		El voto debe ser mayor que 0
 * 
 * M�todos a�adidos: cambiarVoto();
 */
public class Cancion implements Cloneable, Comparable<Cancion>
{
	//Declaraci�n de las propiedades de la Clase
	private int ID;
	private String nombre;
	private String artista;
	private int voto;
	private static int incrementoID = 0;
	
	//Constructor por defecto
	public Cancion()
	{
		ID = ++incrementoID;
		nombre = "Anonimo";
		artista = "Anonimo";
		voto = 0;
	}
	
	//Constructor con par�metros
	public Cancion(String nombre, String artista)
	{
		ID = ++incrementoID;
		this.nombre = nombre;
		this.artista = artista;
		voto = 0;
	}
	
	//Constructor para el polimorfismo
	public Cancion(String nombre, String artista, int voto)
	{
		ID = ++incrementoID;
		this.nombre = nombre;
		this.artista = artista;
		this.voto = voto;
	}
	
	//Constructor de copia
	public Cancion(Cancion cancion)
	{
		ID = ++incrementoID;
		this.nombre = cancion.nombre;
		this.artista = cancion.artista;
		voto = 0;
	}
	
	//Get y Set
	
	public int getID()
	{
		return ID;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getArtista()
	{
		return artista;
	}
	
	public int getVoto()
	{
		return voto;
	}
	
	//M�todos a�adidos
	
	public void cambiarVoto(int voto)
	{
		this.voto = voto;
	}
	
	//Funcion sobreescritas
	
	//hashCode
	@Override
	public int hashCode()
	{
		return ID * 3 + nombre.hashCode() * 11 + artista.hashCode() * 7;
	}
	
	//compareTo
	/*
	 * Criterio de igualdad: Las canciones se ordenar�n por voto e ID.
	 * Devuelve -1, 0 o 1 seg�n:
	 * 	Negativo --> Si la canci�n que recibe la llamada es menor a la canci�n introducida
	 *  0 --> Si ambos son id�nticos
	 *  Positivo --> Si la canci�n que recibe la llamada es mayor a la canci�n introducida
	 */
	public int compareTo(Cancion cancion)
	{
		int ret;
		
		ret = this.voto - cancion.voto;
		
		if(ret == 0)
		{
			ret = this.ID - cancion.ID;
		}
		
		return ret;
	}
	
	//equals
	/*
	 * Dos canciones son iguales si tienen el mismo nombre y autor.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean ret = false;
		
		if(this == obj)
		{
			ret = true;
		}
		else
		{
			if(obj != null && obj instanceof Cancion)
			{
				Cancion cancion = (Cancion) obj;
				
				if(this.getArtista() == cancion.getArtista() && this.getNombre() == cancion.getNombre())
				{
					ret = true;
				}
			}
		}
			
		return ret;
	}
	
	//clone
	@Override
	public Cancion clone()
	{
		Cancion copia = null;
		
		try
		{
			copia = (Cancion) super.clone();
		}catch(CloneNotSupportedException error)
		{
			System.out.println("Error en la copia");
		}
		
		return copia;
	}
	
	//toString
	@Override
	public String toString()
	{
		return "| "+this.getID()+" | Nombre: "+this.getNombre()+", Artista: "+this.getArtista()+", Votos: "+this.getVoto();
	}
	 
}

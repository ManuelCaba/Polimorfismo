package clasesbasicas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import enums.TypeActivity;
import excepciones.ExcepcionAfiliado;
/*
 * Clase Afiliado
 * 
 * Propiedades Básicas:
 * 
 * 		- code --> int, Consultable
 * 		- surnameName --> String, Consultable
 * 		- date --> GregorianCalendar, Consultable (Fecha de alta en el club)
 * 		- typeActivity --> typeActivity, Consultable y Modificable
 * 		- weight --> double, Consultable y Modificable
 * 	
 * Propiedades Compartidas:
 * 
 * 		- incrementoCode --> int
 * 
 * Propiedades Derivadas:
 * 
 * 		- category --> int, Consultable
 * 
 * Getters y/o Setters
 * 
 * 		public int getCode();
 * 
 * 		public String getSurnameName();
 * 
 * 		public GregorianCalendar getDate();
 * 		public int getDay();
 * 		public int getMonth();
 * 		public int getYear();
 * 
 * 		public typeActivity getTypeActivity();
 * 		public void setTypeActivity(typeActivity typeActivity);
 * 		public double getCTE();
 * 
 * 		public double getWeight();
 * 		public void setWeight(double weight);
 * 
 * 		public int getCategory();
 * 
 * Restricciones:
 * 		
 * 		- typeActivity tendrá como valores LOW, MEDIUM o HIGH
 * 		- code será un numero entero positivo de 4 dígitos que se proporcionará automaticamente de manera creciente por cada afiliado
 * 		- weight debe ser un número entero positivo mayor o igual a 40
 * 		- La categoría es 1 cuando el afiliado se da de alta y va aumentado uno por uno cada año hasta llegar a 6 
 */
public class Afiliado implements Cloneable, Comparable<Afiliado> 
{	
	//Declaración Atributos de la clase
	private int code;
	private String surnameName;
	private GregorianCalendar date;
	private TypeActivity typeActivity;
	private double weight;
	private static int incrementoCode = 1000;
	
	//Constructor por defecto
	public Afiliado()
	{
		code = incrementoCode++;
		surnameName = "Anonimo";
		date = new GregorianCalendar();
		typeActivity = TypeActivity.DEFAULT;
		weight = 40;
	}
	
	//Constructor por parámetros
	public Afiliado(String surnameName, TypeActivity typeActivity, double weight)
	{
		code = incrementoCode++;
		this.surnameName = surnameName;
		this.date = new GregorianCalendar();
		this.typeActivity = typeActivity;
		
		if(weight < 40)
		{
			System.out.println("Error con el peso, valor por defecto asignado");
			
			weight = 40;
		}
		else
		{
			this.weight = weight;
		}
	}
	
	//Constructor de copia
	public Afiliado(Afiliado afiliado)
	{
		code = incrementoCode++;
		this.surnameName = afiliado.surnameName;
		this.date = afiliado.date;
		this.typeActivity = afiliado.typeActivity;
		this.weight = afiliado.weight;
	}
	
	//Getters y/o Setters
	
	public int getCode()
	{
		return code;
	}
	
	public String getSurnameName()
	{
		return surnameName;
	}
	 
	public String getDate()
	{
		return this.getDay()+"/"+this.getMonth()+"/"+this.getYear();
	}
	
	public int getDay()
	{
		return this.date.get(Calendar.DATE);
	}
	
	public int getMonth()
	{
		return this.date.get(Calendar.MONTH) + 1;
	}
	
	public int getYear()
	{
		return this.date.get(Calendar.YEAR);
	}
	   
	public TypeActivity getTypeActivity()
	{
		return typeActivity;
	}
	
	public void setTypeActivity(TypeActivity typeActivity)
	{
		this.typeActivity = typeActivity;
	}
	
	public double getCTE()
	{
		return this.getCTE();
	}
	  
	public double getWeight()
	{
		return weight;
	}
	
	public void setWeight(double weight) throws ExcepcionAfiliado
	{
		if(weight >= 40)
		{
			this.weight = weight;
		}
		else
		{
			throw new ExcepcionAfiliado("El peso del afiliado debe ser mayor igual a 40");
		}
		
	}
	  
	public int getCategory()
	{
		int category = 0;
		
		//Generar Fecha Actual
		GregorianCalendar fechaActual = new GregorianCalendar();
		
		//Calcular dias entre dos fechas
		int dias = (int) ((fechaActual.getTimeInMillis() - this.date.getTimeInMillis())/86400000);
		
		//Transformar dias transcurridos a años
		int anhos = dias/365;
		
		//Calcular categoría
		if(anhos != 6 && anhos != 0)
		{
			category = anhos + 1;
		}
			
		return category;
	}
	
	//Funciones Sobreescritas
	
	//hashCode
	@Override
	public int hashCode()
	{
		return this.getCode() + this.surnameName.hashCode();
	}
	
	//compareTo
	/*
	 * Criterio de igualdad: Los afiliados se ordenarán por typeActivity, weight y code.
	 * Devuelve negativo, 0 o positivo según:
	 * 		negativo --> Si el afiliado que recibe la llamada es menor que el pasado por parámetros.
	 * 		0 --> Si ambos code son iguales.
	 * 		positivo --> Si el afiliado que recibe la llamada es mayor que el pasado por parámetros.
	 */
	public int compareTo(Afiliado afiliado)
	{
		int ret;
		
		ret = this.typeActivity.ordinal() - afiliado.typeActivity.ordinal();
		
		if(ret == 0)
		{
			ret = Double.compare(this.weight, afiliado.weight);
			
			if(ret == 0)
			{
				ret = this.code - afiliado.code;
			}
		}
		
		return ret;
	}
	
	//equals
	/*
	 * Criterio de igualdad: Dos afiliados son iguales si tienen el mismo code.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean ret = false;
		
		if(this == obj)
		{
			ret = true;
		}
		else if(obj != null && obj instanceof Afiliado)
		{
			Afiliado afiliado = (Afiliado) obj;
			
			if(this.getCode() == afiliado.getCode())
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	//clone
	@Override
	public Afiliado clone()
	{
		Afiliado afiliado = null;
		
		try
		{
			afiliado = (Afiliado) super.clone();
			afiliado.date = (GregorianCalendar) this.date.clone();
		}
		catch(CloneNotSupportedException error)
		{
			System.out.println("Error en la copia");
		}
		
		return afiliado;
	}
	
	//toString
	@Override
	public String toString()
	{
		return this.getCode()+","+this.surnameName+","+this.getDate()+","+this.getTypeActivity().toString()+","+this.weight;
	}
}

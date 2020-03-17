package Utiles;

public class MetodosPolimorficos {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void insercionDirecta(Comparable[] array)
	{
		Comparable aux;
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; j--)
			{
				aux = array[j];
				array[j] = array[j - 1];
				array[j -1] = aux;
			}
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void seleccionDirecta(Comparable[] array)
	{
		int minimo = 0;
		Comparable aux;
		
		for(int i = 0; i < array.length; i++)
		{
			minimo = i;
			
			for(int j = i + 1; j < array.length; j++)
			{
				if(array[j].compareTo(array[minimo]) < 0)
				{
					minimo = j;
				}
			}
			
			aux = array[i];
			array[i] = array[minimo];
			array[minimo] = aux;
		}
	}

}

package enums;
public enum TypeActivity {
	
	LOW(0.15), MEDIUM(0.25), HIGH(0.36), DEFAULT(0.0);
	
	private double CTE;
	
	private TypeActivity(double CTE)
	{
		this.CTE = CTE;
	}
	
	//Getters
	
	public double getCTE()
	{
		return this.CTE;
	}
}

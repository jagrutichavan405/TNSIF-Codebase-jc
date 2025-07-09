package day7.overriding;



public class HDFC extends overloadingRBI{

	public float getRateofInterest()
	{
		System.out.println("Base rate of interest of home loan");
		return 7.5f;
	}
}
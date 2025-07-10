package finallyblock;

public class NEGATIVEexception extends Exception {


	public negativeException(String string)
	{
		super (string);
	}
	public negativeException()
	{
		super ("Percentage should not be negative");
	}
	
}
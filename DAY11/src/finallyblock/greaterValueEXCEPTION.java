package finallyblock;
public class greaterValueEXCEPTION extends Exception {
	
	
	public greatervalueException(String string)
	{
		super(string);
	}
	
	public greatervalueException()
	{
		super("Percentage should not be more then 100");
	}
}
package Static;

 public class MyClass {

 private int section;
 public static int srNo;
 
 
   //static block;

	//static block
	static 
	{
		System.out.println("------Within Static block-----");
		srNo=1000;
	//	section=101;
	}
	//defalt constructor 
	public MyClass() {
		
	System.out.println("----Within DFefault constructor ----");
	srNo++;
	section++;
	}
	@Override
	public String toString() {
		return "MyClass [serial No "+srNo+",section=" + section + "]";
	}
	
	//static method 
	static void display()
	{
		//System.out.println("Section :"+ section);
		
		System.out.println("Serial no :"+srNo);
		
		
	}
 }
	

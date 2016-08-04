package util;



public class Printer 
{
	private String classname;
	
	public Printer(Class<?> c)
	{
		classname = c.getSimpleName();
	}
	
	public void println()
	{
		System.out.println();
	}
	
	public void println(String str)
	{
		System.out.println(classname+": "+str);
	}
	
	public void println(boolean bool)
	{
		System.out.println(classname+": "+bool);
	}
	
	public void println(char c)
	{
		System.out.println(classname+": "+c);
	}
	
	public void println(char[] c)
	{
		System.out.println(classname+": "+c);
	}
	
	public void println(Double d)
	{
		System.out.println(classname+": "+d);
	}
	
	public void println(float f)
	{
		System.out.println(classname+": "+f);
	}
	
	public void println(int i)
	{
		System.out.println(classname+": "+i);
	}
	
	public void prinln(long l)
	{
		System.out.println(classname+": "+l);
	}
	
	public void println(Object o)
	{
		System.out.println(classname+": "+o);
	}
}

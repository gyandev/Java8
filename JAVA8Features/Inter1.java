package com.gyan.JAVA8Features;

@FunctionalInterface
public interface Inter1 
{
	public void m1();
	default void log()
	{
		
	}
	static void m3()
	{
		
	}

}

interface I1 extends Inter1
{
	public void m2();
	default void log()
	{
		
	}
	static void m3()
	{
		
	}
}

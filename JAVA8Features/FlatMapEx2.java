package com.gyan.JAVA8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapEx2 
{
	public List m1(List l)
	{
		return l;
	}
	
	public static void main(String[] args) {
		
		List x = null;
		List l=new FlatMapEx2().m1(x);
		
		Map m =new HashMap();
		m.put(null, "gyan");
		m.put(null, null);
		System.out.println(m);
		System.out.println(m.size());
		
		
		
	}

}

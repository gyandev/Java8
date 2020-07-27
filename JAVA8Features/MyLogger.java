package com.gyan.JAVA8Features;

public class MyLogger implements I1,Inter1{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
	
		
		Runnable r=()-> System.out.println("Hello Thread");
		Thread t=new Thread(r);
		t.start();
		
	}



	

}

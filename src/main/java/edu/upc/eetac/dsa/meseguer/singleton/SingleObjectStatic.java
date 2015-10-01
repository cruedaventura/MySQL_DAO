package edu.upc.eetac.dsa.meseguer.singleton;

public class SingleObjectStatic {

	//create an object of SingleObject
	private static SingleObjectStatic instance = new SingleObjectStatic();

	//make the constructor private so that this class cannot be
	//instantiated
	private SingleObjectStatic(){}

	//Get the only object available
	public static SingleObjectStatic getInstance(){
		return instance;
	}

	public void showMessage(){
		System.out.println("Hello World!");
	}
}
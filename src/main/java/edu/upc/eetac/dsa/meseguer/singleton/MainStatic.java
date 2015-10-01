package edu.upc.eetac.dsa.meseguer.singleton;

public class MainStatic {

	public static void main(String[] args) {

		//Compile Time Error: The constructor SingleObject() is not visible
		//SingleObject object = new SingleObject();

		//Get the only object available
		SingleObjectStatic object = SingleObjectStatic.getInstance();

		//show the message
		object.showMessage();
	}
}
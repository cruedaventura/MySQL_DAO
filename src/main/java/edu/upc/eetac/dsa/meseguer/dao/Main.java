package edu.upc.eetac.dsa.meseguer.dao;

public class Main {
	   public static void main(String[] args) {
	      ProvidersDao providersDao = new ProvidersDao();

	      //print all providerses
	      for (Providers providers : providersDao.getAllProviders()) {
	         System.out.println("Providers: [RollNo : " + providers.getRollNo() + ", Code : " + providers.getCode() + ", Name : " + providers.getName() + " ]");
	      }


	      //update providers
	      Providers providers = providersDao.getAllProviders().get(0);
		   providers.setCode("VIP");
	      providers.setName("Very important");
		   providersDao.updateStudent(providers);

	      //get the providers
	      providersDao.getProviders(0);
	      System.out.println("Providers: [RollNo : " + providers.getRollNo() + ", Code : " + providers.getCode() + ", Name : " + providers.getName() +" ]");
	   }
	}

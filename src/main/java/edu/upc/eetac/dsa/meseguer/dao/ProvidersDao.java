package edu.upc.eetac.dsa.meseguer.dao;

import java.util.ArrayList;
import java.util.List;

public class ProvidersDao
{
	
   //list is working as a database
   List<Providers> providerses;

   public ProvidersDao(){
      providerses = new ArrayList<Providers>();
      Providers providers1 = new Providers("FT","Fairy Tail",0);
      Providers providers2 = new Providers("OP", "One Piece",1);
      providerses.add(providers1);
      providerses.add(providers2);
   }
   public void deleteStudent(Providers providers) {
      providerses.remove(providers.getRollNo());
      System.out.println("Providers: Roll No " + providers.getRollNo() + ", deleted from database");
   }

   public List<Providers> getAllProviders() {
      return providerses;
   }

   public Providers getProviders(int rollNo) {
      return providerses.get(rollNo);
   }

   public void updateStudent(Providers providers) {
      providerses.get(providers.getRollNo()).setName(providers.getName());
      System.out.println("Providers: Roll No " + providers.getRollNo() + ", updated in the database");
   }
}

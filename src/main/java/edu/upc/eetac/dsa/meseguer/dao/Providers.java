package edu.upc.eetac.dsa.meseguer.dao;

// Object Model
public class Providers
{
    private String name;
    private String code;
    private int rollNo;

    Providers(String code, String name, int rollNo)
    {
        this.code = code;
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRollNo()
    {
        return rollNo;
    }

    public void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}

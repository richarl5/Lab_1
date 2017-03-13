package com.eetakemon.entity;

/**
 * Created by Home on 21/02/2017.
 */
public class Eetakemon
{
    private String name;
    private int id;
    private int level;

    public Eetakemon()
    {
    }

    public Eetakemon (String name, int id, int level)
    {
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public String getName()
    {
        return name;
    }

    public int getLevel()
    {
        return level;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(Integer id)
    {
        this.id = id;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }
}

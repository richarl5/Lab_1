package com.eetakemon.entity;

/**
 * Created by Home on 28/02/2017.
 */
public class User
{
    private String name;
    private String pass;
    private String mail;
    public User (String name, String pass, String mail)
    {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
    }

    public String getName()
    {
        return name;
    }

    public String getPass()
    {
        return pass;
    }

    public String getMail()
    {
        return mail;
    }
}

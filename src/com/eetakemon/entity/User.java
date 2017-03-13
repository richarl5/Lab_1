package com.eetakemon.entity;

/**
 * Created by Home on 28/02/2017.
 */
public class User
{
    private String name;
    private String passhash;
    private String mail;

    public User ()
    {
    }
    public User (String name, String pass, String mail)
    {
        this.name = name;
        this.passhash = pass;
        this.mail = mail;
    }

    public String getName()
    {
        return name;
    }

    public String getPass()
    {
        return passhash;
    }

    public String getMail()
    {
        return mail;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPass(String pass)
    {
        this.passhash = pass;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }
}

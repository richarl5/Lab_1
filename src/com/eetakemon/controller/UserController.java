package com.eetakemon.controller;

import com.eetakemon.entity.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 07/03/2017.
 */
public class UserController
{
    private static Map<String,User> lista = new HashMap<>();
    public UserController()
    {
    }

    public String hashCompute(String toHash)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(toHash.getBytes());
            byte byteData[] = md.digest();
            return String.format("%064x", new java.math.BigInteger(1, byteData)).toUpperCase();
        }
        catch (NoSuchAlgorithmException ex){
            return null;
        }
    }

    public boolean addUser (User u)
    {
        u.setPass(hashCompute(u.getPass()));
        if(lista.putIfAbsent(u.getName(),u)==null) return true;
        return false;
    }

    public boolean delUSer (String name)
    {
        if(lista.remove(name)!=null) return true;
        return false;
    }

    public boolean LogIn (String name, String pass)
    {
        if(lista.containsKey(name)) {
            User user = lista.get(name);
            if (user.getPass().equals(hashCompute(pass))) return true;
        }
        return false;
    }

    public User searchUser (String name)
    {
        if (lista.containsKey(name)) {
            User user = lista.get(name);
            return user;
        }
        return null;
    }
}

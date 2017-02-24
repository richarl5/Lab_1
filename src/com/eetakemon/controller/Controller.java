package com.eetakemon.controller;

import com.eetakemon.entity.Eetakemon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 21/02/2017.
 */
public class Controller
{
    private static List<Eetakemon> lista = new ArrayList<>();
    private final int MAX = 50;
    public Controller()
    {
    }

    public boolean addEetakemon (Eetakemon e)
    {
        if(lista.size() < MAX)
        {
            lista.add(e);
            return true;
        }
        else return false;
    }

    public boolean delById (int id)
    {
        boolean found = false;
        for(int i=0; i < lista.size() && !found; i++)
        {
            Eetakemon e = lista.get(i);
            if(e.getId() == id)
            {
                found = true;
                lista.remove(i);
            }
        }
        return found;
    }

    public List<Eetakemon> listEetakemon ()
    {
        return lista;
    }

    public List<Eetakemon> searchByName (String name)
    {
        List<Eetakemon> lista2 = new ArrayList<>();
        for (Eetakemon e:lista)
        {
            if (e.getName().equals(name))
                lista2.add(e);
        }
        return lista2;
    }
}





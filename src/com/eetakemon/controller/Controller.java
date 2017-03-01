package com.eetakemon.controller;

import com.eetakemon.entity.Eetakemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Home on 21/02/2017.
 */
public class Controller
{
    private static Map<Integer,Eetakemon> lista = new HashMap<>();
    public Controller()
    {
    }

    public boolean addEetakemon (Eetakemon e)
    {
        if(lista.put(e.getId(),e)==null) return true;
        return false;
    }

    public boolean delById (int id)
    {
        if(lista.remove(id)!=null) return true;
        return false;
    }

    public List<Eetakemon> listEetakemon ()
    {
        List<Eetakemon> list = new ArrayList<>();
        for (Eetakemon e:lista.values())
            list.add(e);
        return list;
    }

    public List<Eetakemon> searchByName (String name)
    {
        List<Eetakemon> list = new ArrayList<>();
        List<Eetakemon> list2 = new ArrayList<>();
        for (Eetakemon e:lista.values())
            list.add(e);
        for (Eetakemon e:list)
        {
            if (e.getName().equals(name))
                list2.add(e);
        }
        return list2;
    }
}





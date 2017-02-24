package com.eetakemon.view;

import com.eetakemon.controller.Controller;
import com.eetakemon.entity.Eetakemon;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        List <Eetakemon> lista;
        String name;
        int counter = 0;
        int level,id,code;
        Controller c = new Controller();
        Scanner reader = new Scanner(System.in);
        for(;;)
        {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1-Add Eetakemon");
            System.out.println("2-Del Eetakemon by ID");
            System.out.println("3-List Eetakemon");
            System.out.println("4-Search by name");
            System.out.println("5-Exit");
            System.out.print("Select option: ");
            code = getCode(reader);
            switch (code)
            {
                case 1:
                    System.out.print("Insert name: ");
                    name = reader.nextLine();
                    try {
                        System.out.print("Insert level: ");
                        level = reader.nextInt();
                        counter++;
                        Eetakemon e = new Eetakemon(name,counter,level);
                        boolean res = c.addEetakemon(e);
                        if(res) System.out.println("Eetakemon added!");
                        else System.out.println("List is full!");
                    } catch (InputMismatchException ime) {
                        System.out.println("Insert a number!");
                        reader.next();
                    }
                    break;
                case 2:
                    System.out.print("Insert ID: ");
                    try {
                        id = reader.nextInt();
                        boolean res = c.delById(id);
                        if(res) System.out.println("Eetakemon ID: " + id + " deleted!");
                    } catch (InputMismatchException ime){
                        System.out.println("Insert a number!");
                        reader.next();
                    }
                    break;
                case 3:
                    lista = c.listEetakemon();
                    printList(lista);
                    break;
                case 4:
                    System.out.print("Insert name: ");
                    name = reader.nextLine();
                    lista  = c.searchByName(name);
                    printList(lista);
                    break;
                case 5:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select valid option!");
            }
        }
    }

    private static void printList(List <Eetakemon> lista)
    {
        for(Eetakemon e : lista)
            System.out.println("ID: " + e.getId() + " Name: " + e.getName() + " Level: " + e.getLevel());

    }

    private static int getCode(Scanner reader)
    {
        int code = 0;
        try {
            code = reader.nextInt();
            reader.nextLine();
        } catch (InputMismatchException ime){
            System.out.println("Insert a number!");
            reader.next();
        }
        return code;
    }
}

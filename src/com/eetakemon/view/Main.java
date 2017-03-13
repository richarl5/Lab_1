package com.eetakemon.view;

import com.eetakemon.controller.EetakemonController;
import com.eetakemon.controller.UserController;
import com.eetakemon.entity.Eetakemon;
import com.eetakemon.entity.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        List <Eetakemon> lista;
        String name,pass,mail;
        int counter = 0;
        int level,id,code;
        boolean res;
        EetakemonController c = new EetakemonController();
        UserController u = new UserController();
        Scanner reader = new Scanner(System.in);
        for(;;)
        {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1-Add Eetakemon");
            System.out.println("2-Del Eetakemon by ID");
            System.out.println("3-List Eetakemon");
            System.out.println("4-Search by name");
            System.out.println("5-Add User");
            System.out.println("6-Remove User");
            System.out.println("7-LogIn");
            System.out.println("8-Search User");
            System.out.println("9-Exit");
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
                        res = c.addEetakemon(e);
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
                        res = c.delById(id);
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
                    System.out.print("Insert Username: ");
                    name = reader.nextLine();
                    System.out.print("Insert Pass: ");
                    pass = reader.nextLine();
                    System.out.print("Enter password confirmation: ");
                    String passconfirm = reader.nextLine();
                    if(pass.equals(passconfirm)) {
                        System.out.print("Insert Mail: ");
                        mail = reader.nextLine();
                        User user = new User(name, pass, mail);
                        res = u.addUser(user);
                        if (res) System.out.println("User added!");
                        else System.out.println("Username already exists!");
                    }
                    else System.out.println("Pass doesn't match!");
                    break;
                case 6:
                    System.out.print("Insert User: ");
                    name = reader.nextLine();
                    res = u.delUSer(name);
                    if(res) System.out.println("User: " + name + " deleted!");
                        else System.out.println("User does not exists!");
                    break;
                case 7:
                    System.out.print("Insert Username: ");
                    name = reader.nextLine();
                    System.out.print("Insert Pass: ");
                    pass = reader.nextLine();
                    res = u.LogIn(name,pass);
                    if(res) System.out.println("Logged in!");
                    else System.out.println("Incorrect Username or password!");
                    break;
                case 8:
                    System.out.print("Insert Username: ");
                    name = reader.nextLine();
                    User user = u.searchUser(name);
                    if(user == null) System.out.println("User does not exists!");
                    else System.out.println("User: " + user.getName() + " Pass: " + user.getPass() + " Mail: " + user.getMail());
                    break;
                case 9:
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

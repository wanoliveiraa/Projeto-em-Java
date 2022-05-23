
package model;

import java.util.ArrayList;
import java.util.Scanner;
import view.*;

public class Login {
    private static ArrayList<Login> users;
    private int id;
    private String username;
    private String password;

    public Login(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
   public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}





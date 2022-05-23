
package model;

import java.util.ArrayList;

public class Relatorio {
    private ArrayList<Usuario> users;

    public Relatorio(ArrayList<Usuario> users) {
        this.users = users;
    }
    
    
    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }
    
    
}

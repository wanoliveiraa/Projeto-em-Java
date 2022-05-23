
package model;

import java.util.Calendar;

public class Exercicio implements Cloneable {
    private String id;
    private String atividade;
    private String caloria;
    private double tempo;
    private double caloriaexercio;
    private double coloriatotal;
    private Usuario users;
  

    public Exercicio(String id,String atividade, String caloria) {
        this.id=id;
        this.atividade = atividade;
        this.caloria = caloria;
    }

  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getCaloria() {
        return caloria;
    }

    public void setCaloria(String caloria) {
        this.caloria = caloria;
    }

    public double getColoriatotal() {
        return coloriatotal;
    }

    public void setColoriatotal(double coloriatotal) {
        this.coloriatotal = coloriatotal;
    }

    public double getCaloriaexercio() {
        return caloriaexercio;
    }

    public void setCaloriaexercio(double caloriaexercio) {
        this.caloriaexercio = caloriaexercio;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
    
    public Usuario getUsers() {
        return users;
    }

    public void setUsers(Usuario users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Exercicio=" + atividade + ", caloria=" + caloria +"\n";
    }
    public Object clone() {
        try {
            // call clone in Object.
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
    

}

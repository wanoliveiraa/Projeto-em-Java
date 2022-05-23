
package model;

public class Metas {
   private double atvdiarias;
   private double caloriasdiarias;
   private double peso;

    public Metas(double atvdiarias, double peso) {
        this.atvdiarias = atvdiarias;
        this.peso = peso;
    }

    public double getAtvdiarias() {
        return atvdiarias;
    }

    public void setAtvdiarias(double atvdiarias) {
        this.atvdiarias = atvdiarias;
    }

    public double getCaloriasdiarias() {
        return caloriasdiarias;
    }

    public void setCaloriasdiarias(double caloriasdiarias) {
        this.caloriasdiarias = caloriasdiarias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

   
   
}

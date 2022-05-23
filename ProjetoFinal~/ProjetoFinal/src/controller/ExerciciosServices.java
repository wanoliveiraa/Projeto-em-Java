
package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import model.*;

public class ExerciciosServices {
    
    public static double calculoCal(Exercicio ex,Usuario u1,double tempo){
        double caloria=Double.parseDouble(ex.getCaloria())*tempo;
        for(Exercicio a: u1.getHst()){
           caloria+=a.getColoriatotal();
           a.setColoriatotal(caloria);
           u1.setCaloriaTotal(ex.getColoriatotal());
        }
       
        return caloria;
    }
    public static double mediaExercico(Usuario u1,Calendar gc){
       
        long millis = Math.abs(gc.getTimeInMillis() - u1.getGc().getTimeInMillis());
        
        long days = TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
        
        double media= u1.getCaloriaTotal()/days;
        
        return media;
    }
    public static double mediaTempo(Usuario u1,Calendar gc){
        double somaTempo = 0;
        
        for(Exercicio a: u1.getHst()){
            somaTempo += a.getTempo();
        }

        long millis = Math.abs(gc.getTimeInMillis() - u1.getGc().getTimeInMillis());
        
        long days = TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
        
        double media= somaTempo/days;
        
        return media;
    }        
    public static double perdaPeso(double kcal){
        double aux = 0;
        aux = kcal/7700;
        return aux;
    }

    public static Exercicio pesquisarExercico (ArrayList <Exercicio> ex,String id){
        for (Exercicio el: ex){
            if(el.getId().equals(id)){
                return el;
            }
        }
        return null;
    }

}

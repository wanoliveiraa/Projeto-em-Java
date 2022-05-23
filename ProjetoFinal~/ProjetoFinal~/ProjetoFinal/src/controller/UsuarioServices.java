
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class UsuarioServices {
    
    public double caloriasPorDias(Usuario usuario,int sex){
        double caloriaM=66+((13.7* usuario.getPeso()) + (5*usuario.getAltura()*100) - (6.5 * usuario.getIdade()));
        double caloriaF=665+((9.6* usuario.getPeso()) + (1.8*usuario.getAltura()*100) - (4.7 * usuario.getIdade()));
        do{
            switch(sex){
                case 1:
                    usuario.setCaloriaTotal(caloriaM);
                    return usuario.getCaloriaTotal();
                case 2: 
                    usuario.setCaloriaTotal(caloriaF);
                    return usuario.getCaloriaTotal();
                default:
                    System.out.println("Entrada invalida");
                break;    
            }    
        }while(sex!=1|| sex!=2);
        
        return 0;
    }
    
    public static String imc(double altura,double peso){
        double imc = peso/(altura*altura);
        if(imc<=18.5){
          return "Abaixo do peso";
        }else if(imc>=18.5 && imc<=24.9){
            return "Peso normal";    
        }else if(imc>=25 && imc<=29.9){
             return "Sobrepeso I";
        }else if(imc>=30 && imc<=39.9){
             return "Obesidade II "; 
        }else if(imc>=40){
            return "Obesidade Grave III ";     
        }   
       return ""; 
    }
    
    public static Usuario pesquisarUsuario (ArrayList <Usuario> users,String nome){
        Scanner teclado = new Scanner(System.in);
        //try{
        for (Usuario el: users){
            if(el.getNome().equals(nome)){
                return el;
            }
              //  System.out.println("Nome invalido");
              //  System.out.println("Coloque seu nome novamente:");
               // String nome2=teclado.nextLine();
                //return pesquisarUsuario(users,nome2);   
        }
       // }catch(NullPointerException c){
         //   System.out.println("Sem nome cadastrados");
        //}    
        return null;
    }
  
}   



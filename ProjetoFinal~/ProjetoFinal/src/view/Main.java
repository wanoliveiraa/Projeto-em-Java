
package view;

import java.util.ArrayList;
import model.*;
import controller.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Scanner;
import view.Render;

public class Main {
    public static void main(String[] args) {
        String atv = null;
        int tempo = 0;
        BufferedReader leitor=null;
        BufferedReader leitor1=null;
        BufferedWriter escreve=null;
        ArrayList <Usuario> users= new ArrayList<>();
        ArrayList <Exercicio> ex = new ArrayList<>();
        Hashtable<String,Usuario> login= new  Hashtable<>();
        int op=0;
     
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        Calendar gc = Calendar.getInstance();
        System.out.println(df.format(gc.getTime())); 
        
        Render.bancoDeExercicios(ex,leitor);
        Scanner teclado = new Scanner(System.in);
        do{
        System.out.println("--------------------------------------------------------------");
        System.out.println("Seja Bem vindo!");
        System.out.println("ao Perda de peso!");
        System.out.println("1-Cadastrar seu usuario: ");
        System.out.println("2-Cadastrar exercicio:");
        System.out.println("3-Listar exercicios:");
        System.out.println("4-Listar usuarios:");
        System.out.println("5-Caloria do dia: ");
        System.out.println("6-Pular um dia");
        System.out.println("0-Sair");
        System.out.println("--------------------------------------------------------------");
        op = teclado.nextInt();
            switch(op){
            case 1:
                Render.cadastroDeUsuarios(users,gc);
                break;
            case 2:
                Render.listaExercicio(ex);
                Render.cadastroDeExercicio(ex, users);
                break;
            case 3:
                Render.listaExercicio(ex);
                break;
            case 4:
                Render.listaDeUsuario(users);
                break;
            case 5:
                System.out.println("Digite o seu nome:");
                String n1=teclado.next();
                Render.listaCalorias(users, n1);
               break;
            case 6:
                
               Render.pularDia(users,gc, df);
               Render.bancoDeDados(users, escreve);
               Render.salvar(users);
               Render.reset(users);
               break;
            case 0:
                System.out.println("Até mais!");
                break;
            default:
                System.out.println("Opção invalidada");
            }
            System.out.println(" ");
        }while(op!=0);
        teclado.close();
    }
}
   


package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import controller.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Render {
  
    public static void cadastroDeUsuarios(ArrayList <Usuario> users, Calendar gc){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\nNome do usuario : ");
        String nome =  teclado.nextLine();

        System.out.println("Sua idade: ");
        int idade = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Sua altura :");
        double altura = teclado.nextDouble();
        teclado.nextLine();

        System.out.println("Seu peso :");
        double peso = teclado.nextDouble(); 
        teclado.nextLine();
        Usuario u1=new Usuario(nome, idade, altura, peso,(Calendar)gc.clone());
        u1.setImc(UsuarioServices.imc(altura,peso));
        System.out.println("Seu imc é:" +u1.getImc());
        System.out.println("");
        users.add(u1);
        criaMetas(users, nome);   
    }
    
    public static void criaMetas(ArrayList <Usuario> users,String nome){
      
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe sua meta de quantos exercicios por dia:");
        double atividade = teclado.nextDouble();

        System.out.println("Informe sua meta de peso(kg): ");
        double peso =  teclado.nextDouble();


        Metas metas = new Metas(atividade,peso);
        for(Usuario e: users){
        if(e.getNome().equals(nome)){
            e.setMetas(metas);
            }
        }        
    }
    public static void bancodeUsuario( Hashtable<String,Usuario> login,BufferedReader leitor,Calendar gc){
        Usuario usuario;
        try{
            leitor = new BufferedReader(new FileReader("Membro.txt"));
            String linha = null;
       
            while((linha = leitor.readLine())!=null){
                String dividir[] = linha.split(";");
                int idade=Integer.parseInt(dividir[1]);
                double peso=Double.parseDouble(dividir[3]);
                double altura=Double.parseDouble(dividir[2]);
                String key=dividir[4];
                usuario=new Usuario(dividir[0],idade,altura,peso,gc);     
                login.put(key, usuario);
            }
            leitor.close();
        }catch(FileNotFoundException file){
            System.out.println("Arquivo não encontrado");
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }    
    }
    public static void escreverUsuario(ArrayList <Usuario> login,BufferedWriter escreve) throws IOException{
       
        escreve = new BufferedWriter(new FileWriter("Membro.txt"));
        

        for (Usuario i: login){
            escreve.write(i.getNome()+";"+i.getIdade()+";"+i.getAltura()+";"+i.getPeso()+";"+"\n");
        }

        escreve.close();
    }
    
    public static void salvar(ArrayList <Usuario> users){
        Relatorio r = new Relatorio(users);
    }
    
    public static void reset(ArrayList <Usuario> users){
        for(Usuario i : users){
            for(int j=0;j<i.getAtv().size();j++){      
                i.getAtv().clear();
            }
          
        }    
    } 

    public static void listaDeUsuario(ArrayList <Usuario> users){
        
        for(Usuario i: users){
            System.out.println("Nome do usuario : "+i.getNome());
            System.out.println("Idade : "+i.getIdade());
            System.out.println("Altura :"+i.getAltura());
            System.out.println("Peso :"+i.getPeso());
            System.out.println("Exercicio Cadastrados:" );
            for(int j =0;j<i.getAtv().size();j++){
                System.out.println(i.getAtv().get(j));
            }
            try{
                System.out.println("Meta de tempo de exercicio: "+i.getMetas().getAtvdiarias());   
                System.out.println("Meta de peso: "+i.getMetas().getPeso());
            }catch(NullPointerException e){
                System.out.println("Sem metas cadastrada");
            }    
        }
           
    }
    
    public static void cadastroDeExercicio(ArrayList <Exercicio> atv,ArrayList <Usuario> users){
        Scanner teclado = new Scanner(System.in);
        int i=0;
       boolean flag=true;
       System.out.println("Coloque seu nome:");
        
       String nome=teclado.nextLine();
       
       Usuario u1=UsuarioServices.pesquisarUsuario(users,nome);
       while(i<u1.getMetas().getAtvdiarias()){
            System.out.println("Coloque o id do exercicio:");
            String id=teclado.nextLine();

            System.out.println("Por quantos minutos: ");
            double tempo=teclado.nextDouble();
            teclado.nextLine();


            Exercicio ex1=ExerciciosServices.pesquisarExercico(atv, id);

            ex1 = (Exercicio)ex1.clone();
            ex1.setTempo(tempo);

            u1.getAtv().add(ex1);
            u1.getHst().add(ex1);

            double valor=ExerciciosServices.calculoCal(ex1,u1,tempo);
            System.out.println("O valor de caloria gasta no exercicio: " +valor);
            i++;
        }
  
    }

     public static void bancoDeExercicios(ArrayList <Exercicio> ex,BufferedReader leitor){
         
       try{
            leitor = new BufferedReader(new FileReader("atividades.txt"));
            String linha = null;
       
            while((linha = leitor.readLine())!=null){
                
                String dividir[] = linha.split(";");
                String id=dividir[0];
                String ativ =dividir[1];
                String cal=dividir[2];

                ex.add(new Exercicio(id,ativ,cal));
            }
        }catch(FileNotFoundException file){
            System.out.println("Arquivo não encontrado");
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }   
    }
 
    public static void listaExercicio(ArrayList <Exercicio> atv){
        for(Exercicio i: atv){
            System.out.println("Id:" + i.getId()+", Exercicio: " + i.getAtividade() +", Gasto Calórico: " + i.getCaloria()+"\n");
        }
    }
    
    // da uma olhada depois

    public static void listaCalorias(ArrayList <Usuario> users,String nome){
        for(Usuario i :users){
            if(i.getNome().equals(nome)){ 
                System.out.println("Seu Gasto calorico é:" +i.getCaloriaTotal());
            
            }       
        }            
    }

    public static void bancoDeDados(ArrayList <Usuario> users,BufferedWriter escreve){
      //Relatório  
        try{
            String temp="";
            escreve = new BufferedWriter(new FileWriter("Bancodedados.html"));
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            Calendar gc = Calendar.getInstance();    
            for (Usuario i : users) {
                temp+= Html.cabeçalho("Relatório do ultimo dia:"+df.format(i.getNovoDia().getTime()));
                for(int j = 0;j<i.getHst().size();j++){
                    String aux1 = Html.cadastroUser(i.getNome(), 
                                                i.getHst().get(j).getAtividade(), i.getHst().get(j).getCaloria()); 
                           
                    temp+=aux1;
                }
                    String aux2=Html.segundaTabela(i.getNome(),i.getMediaExe(),i.getMediaTemp(),i.getPerdaPeso(),i.getCaloriaTotal());
                    temp+=aux2;      
            } 
            escreve.write(temp);
        escreve.close();
        }catch(IOException file){
            System.out.println("Erro ao criar o arquivo");
        }catch(NullPointerException c){
            System.out.println("Sem exercicios cadastrados");
        }
    }
    public static void pularDia(ArrayList<Usuario> user , Calendar gc, DateFormat df){  
        gc.add((GregorianCalendar.DAY_OF_MONTH),1);
        System.out.println(df.format(gc.getTime()));  
        for(Usuario a: user){
            for(int j=0;j<a.getAtv().size();j++){
                a.setNovoDia(gc);
                a.setMediaTemp(ExerciciosServices.mediaTempo(a, gc));
                a.setMediaExe(ExerciciosServices.mediaExercico(a, gc));
                a.setPerdaPeso(ExerciciosServices.perdaPeso(a.getAtv().get(j).getTempo()));
            }    
        }
    }    
    
}   

    

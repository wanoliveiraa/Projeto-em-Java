package controller;

import java.text.DateFormat;
import java.util.Calendar;

public class Html {
    public static String cabeçalho(String current){
        return "<h1>"+current+"</h1>" ;
    }
    public static String quebraLinha(String current){
        return "</br>"+current;
    }
    public static String divisao(String current){
        return "<div>"+current+"</div>";
    }

    public static String cadastroUser(String nome,
                                        String exerc,String calT
                                      ){
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            String tabela =  
            "<style>"+
            " .azul{"+
            "background-color: blue;"+
            "}"+
            "td{"+
            "color:white;"+
            "}"+         
            ".cinza{"+
            "background-color: gray;"+
            "}"+ 
            "</style>"+
            "<table border=1;color:white>"+
            "<colgroup>"+ 
            "<col class=azul>"+
            "<col class=cinza>"+
            "</colgroup>"+
            "<caption>Relatório:"+"</caption>"+
                "<thead>"+
                    " <tr>"+
                    " <td>Nome</td>"+
                    "<td>"+nome+"</td>"+
                    " </tr>"+
                    " <td>Exercicio</td>"+
                     " <td>"+exerc+"</td>"+
                    "<tr>"+
                    " <td>Caloria do exercicio</td>"+
                    " <td>"+calT+"</td>"+
                    "<tr>"+
                    "</thead>"+
        "</table>";
        return tabela;
       
    }
    public static String segundaTabela(String nome,double media1,double media2,double media3,double calt){
        String tabela=
            "<style>"+
            " .azul{"+    
            "background-color: blue;"+
            "}"+
            "td{"+
            "color:white;"+
            "}"+ 
            ".cinza{"+
            "background-color: gray;"+
            "}"+ 
            "</style>"+
            "<table border=1>"+    
            "<colgroup>"+ 
            "<col class=azul>"+
            "<col class=cinza>"+
            "</colgroup>"+
             "<caption>Relatório do:" +nome+"</caption>"+
                "<thead>"+
                    " <tr>"+
                    " <td>Caloria Total</td>"+
                    "<td>"+String.valueOf(calt)+"</td>"+
                    " </tr>"+
                    " <td>Media de Exercio por dia</td>"+
                    "<td>"+String.valueOf(media1)+"</td>"+
                    " </tr>"+      
                    " <td>Media do tempo de exercios por dia</td>"+
                    "<td>"+String.valueOf(media2)+"</td>"+
                    " </tr>"+ 
                    " <td>Media de perda de peso</td>"+
                    "<td>"+String.format("%.2f",media3)+"</td>"+
                    " </tr>" +
                   "</thead>"+
        "</table>";

        return tabela;
                            
    }
    
    
    /*
    escreve.append("Nome:"+i.getNome()+"; " +"Idade:"+i.getIdade()+"; " +"Peso:"+i.getPeso()+"; " +"Altura:"+i.getAltura()+"; " +"Imc:"+i.getImc()+"; " +
    "Exercio:"+i.getAtv().get(j).getAtividade()+"; " +"CaloriaTotal:"+i.getAtv().get(j).getColoriatotal()+"; " + 
   "TempodeExercicio:"+i.getMetas().getAtvdiarias()+"; " +"Metadiarias:"+i.getMetas().getCaloriasdiarias()+"; " +"\n"+"\n");
 */


}

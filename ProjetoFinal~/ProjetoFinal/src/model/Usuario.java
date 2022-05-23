
package model;

import java.util.ArrayList;
import java.util.Calendar;


public class Usuario {
    
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private double caloriaTotal; 
    private String imc;
    private ArrayList<Exercicio> atv;
    private ArrayList<Exercicio> hst;
    private Metas metas;
    private Exercicio ex;
    private Calendar gc;
    private double mediaTemp;
    private double mediaExe;
    private double perdaPeso;
    private Calendar novoDia;

    public Usuario(String nome, int idade, double altura, double peso,Calendar gc) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.gc=gc;
        this.atv=new ArrayList<Exercicio>();
        this.hst=new ArrayList<Exercicio>();
    }
    public Calendar getNovoDia() {
        return novoDia;
    }

    public void setNovoDia(Calendar novoDia) {
        this.novoDia = novoDia;
    }

    public double getPerdaPeso() {
        return perdaPeso;
    }

    public void setPerdaPeso(double perdaPeso) {
        this.perdaPeso = perdaPeso;
    }

    public double getMediaExe() {
        return mediaExe;
    }

    public void setMediaExe(double mediaExe) {
        this.mediaExe = mediaExe;
    }

    public double getMediaTemp() {
        return mediaTemp;
    }

    public void setMediaTemp(double mediaTemp) {
        this.mediaTemp = mediaTemp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCaloriaTotal() {
        return caloriaTotal;
    }

    public void setCaloriaTotal(double caloriaTotal) {
        this.caloriaTotal = caloriaTotal;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public ArrayList<Exercicio> getAtv() {
        return atv;
    }

    public void setAtv(ArrayList<Exercicio> atv) {
        this.atv = atv;
    }

    public Exercicio getEx() {
        return ex;
    }

    public void setEx(Exercicio ex) {
        this.ex = ex;
    }

    public Metas getMetas() {
        return metas;
    }

    public void setMetas(Metas metas) {
        this.metas = metas;
    }

    public ArrayList<Exercicio> getHst() {
        return hst;
    }

    public void setHst(ArrayList<Exercicio> hst) {
        this.hst = hst;
    }

    public Calendar getGc() {
        return gc;
    }

    public void setGc(Calendar gc) {
        this.gc = gc;
    }
    
}

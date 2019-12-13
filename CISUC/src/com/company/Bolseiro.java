package com.company;

import java.util.*;

public abstract class Bolseiro extends Pessoa{
    protected Calendar inicioBolsa;
    protected Calendar fimBolsa;
    protected String nomeProjeto;
    protected boolean projeto = false;

    public Bolseiro(String nome, String email) {
        super(nome, email);
        this.inicioBolsa = Calendar.getInstance();
        this.fimBolsa = Calendar.getInstance();
    }

    public Bolseiro() {     }

    public boolean tenhoProjeto() {
        return projeto;
    }

    public void setProjeto() {
        projeto = true;
    }

    public void setInicioBolsa() {
        System.out.println("Introduza a data de inicio da bolsa. (DD/MM/YYYY)");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        inicioBolsa.set(Calendar.YEAR, ano);
        inicioBolsa.set(Calendar.MONTH, mes);
        inicioBolsa.set(Calendar.DAY_OF_MONTH, dia);
        System.out.println(inicioBolsa.get(Calendar.DAY_OF_MONTH) + "/" + inicioBolsa.get(Calendar.MONTH) + "/" + inicioBolsa.get(Calendar.YEAR));
    }

    public void setFimBolsa() {
        System.out.println("Introduza a data final da bolsa. (DD/MM/YYYY)");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        if(inicioBolsa.get(Calendar.YEAR) > ano) {
            System.out.println("Data de final de bolsa anterior a data de inicio.");
            System.out.println("Data inicio bolsa: " + inicioBolsa.get(Calendar.DAY_OF_MONTH) + "/" + inicioBolsa.get(Calendar.MONTH) + "/" + inicioBolsa.get(Calendar.YEAR));
            return;
        }
        if(inicioBolsa.get(Calendar.MONTH) > mes && inicioBolsa.get(Calendar.YEAR) == ano) {
            System.out.println("Data de final de bolsa anterior a data de inicio.");
            System.out.println("Data inicio bolsa: " + inicioBolsa.get(Calendar.DAY_OF_MONTH) + "/" + inicioBolsa.get(Calendar.MONTH) + "/" + inicioBolsa.get(Calendar.YEAR));
            return;
        }
        fimBolsa.set(Calendar.DAY_OF_MONTH, dia);
        fimBolsa.set(Calendar.MONTH, mes);
        fimBolsa.set(Calendar.YEAR, ano);
        System.out.println(fimBolsa.get(Calendar.DAY_OF_MONTH) + "/" + fimBolsa.get(Calendar.MONTH) + "/" + fimBolsa.get(Calendar.YEAR));
    }
}

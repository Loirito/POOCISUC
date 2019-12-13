package com.company;

import java.util.Calendar;
import java.util.Scanner;

public abstract class Tarefa {

    protected Calendar inicio;
    protected double duracao;
    protected double percConclusao;
    protected Calendar fim;
    protected double esforco;

    public Tarefa(double duracao) {
        this.duracao = duracao;
        this.percConclusao = 0.0;
        this.inicio = Calendar.getInstance();
        this.fim = Calendar.getInstance();
    }

    public Tarefa() { }

    public void insereDatas() {
        System.out.println("Insira a data de inicio da tarefa.");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        inicio.set(Calendar.DAY_OF_MONTH, dia);
        inicio.set(Calendar.MONTH, mes);
        inicio.set(Calendar.YEAR, ano);
        System.out.println("Data inicio tarefa: " + inicio.get(Calendar.DAY_OF_MONTH) + "/" + inicio.get(Calendar.MONTH) + "/" + inicio.get(Calendar.YEAR));
        System.out.println("Quantos dias para completar tarefa?");
        int fim = sc.nextInt();
        this.fim = inicio;
        if(mes <= 7) {
            if(mes%2 != 0) {
                int divfim = fim/31;
                int remfim = fim%31;
                this.fim.add(Calendar.MONTH, divfim);
                this.fim.add(Calendar.DAY_OF_MONTH, remfim);
            }
            else if(mes%2 == 0 && mes != 2) {
                int divfim = fim/30;
                int remfim = fim%30;
                this.fim.add(Calendar.MONTH, divfim);
                this.fim.add(Calendar.DAY_OF_MONTH, remfim);
            }
            else {
                int divfim = fim/28;
                int remfim = fim%28;
                this.fim.add(Calendar.MONTH, divfim);
                this.fim.add(Calendar.DAY_OF_MONTH, remfim);
            }
        }
        else {
            if(mes%2 == 0) {
                int divfim = fim/31;
                int remfim = fim%31;
                this.fim.add(Calendar.MONTH, divfim);
                this.fim.add(Calendar.DAY_OF_MONTH, remfim);
            }
            else {
                int divfim = fim/30;
                int remfim = fim%30;
                this.fim.add(Calendar.MONTH, divfim);
                this.fim.add(Calendar.DAY_OF_MONTH, remfim);
            }
        }

        System.out.println("Data final tarefa: " + this.fim.get(Calendar.DAY_OF_MONTH) + "/" + this.fim.get(Calendar.MONTH) + "/" + this.fim.get(Calendar.YEAR));

    }

    public double getPercConclusao() {
        return percConclusao;
    }

    public void setPercConclusao(double perc) {
        if((this.percConclusao + perc) <= 100) {
            this.percConclusao += perc;
        }
        else System.out.println("Valor ultrapassa a percentagem maxima (100).");
    }

    public double getEsforco() {
        return this.esforco;
    }

    public Calendar getInicio() {
        return this.inicio;
    }

    public Calendar getFim() {
        return this.fim;
    }

    @Override
    public String toString() {return "";}
}

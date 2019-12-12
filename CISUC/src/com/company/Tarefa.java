package com.company;

import java.util.Calendar;

public abstract class Tarefa {

    protected Calendar inicio;
    protected double duracao;
    protected double percConclusao;
    protected Calendar fim;
    protected double esforco;

    public Tarefa(double duracao) {
        this.duracao = duracao;
        this.percConclusao = 0.0;
    }

    public Tarefa() { }

    public void insereInicio() {
        return;
    }

    public void insereFim() {
        return;
    }

    public double getPercConclusao() {
        return percConclusao;
    }

    public void setPercConclusao(double perc) {
        if((this.percConclusao + perc) <= 1) {
            this.percConclusao += perc;
        }
        else System.out.println("Valor ultrapassa a percentagem maxima (1).");
    }

    public double getEsforco() {
        return this.esforco;
    }
}

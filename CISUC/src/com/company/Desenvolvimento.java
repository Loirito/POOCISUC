package com.company;

public class Desenvolvimento extends Tarefa{

    public Desenvolvimento(double duracao) {
        super(duracao);
        this.esforco = 1;
    }

    public Desenvolvimento() {
        super();
        this.esforco = 1;
    }

    @Override
    public String toString() {
        return "Desenvolvimento";
    }
}

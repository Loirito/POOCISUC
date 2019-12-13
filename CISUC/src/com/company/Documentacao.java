package com.company;

public class Documentacao extends Tarefa{

    public Documentacao(double duracao) {
        super(duracao);
        this.esforco = 0.25;
    }

    @Override
    public String toString() {
        return "Documentacao";
    }
}

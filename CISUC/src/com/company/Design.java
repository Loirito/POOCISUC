package com.company;

public class Design extends Tarefa{

    public Design(double duracao) {
        super(duracao);
        this.esforco = 0.5;
    }

    public Design() {
        super();
        this.esforco = 0.5;
    }

    @Override
    public String toString() {
        return "Design";
    }
}

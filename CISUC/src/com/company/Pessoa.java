package com.company;

import java.util.*;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected ArrayList<Tarefa> listaTarefas;
    protected int custo;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.listaTarefas = new ArrayList<>();
    }

    public Pessoa() {   }

    public void addTarefa(Tarefa tarefa) {
        return;
    }

    public int getCusto() {
        return custo;
    }

    public double esforcoLivre() {
        return 0.0;
    }
}

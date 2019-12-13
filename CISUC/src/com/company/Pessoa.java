package com.company;

import java.util.*;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected List<Tarefa> listaTarefas;
    protected double custo;
    protected double esforco;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.listaTarefas = new ArrayList<>();
        this.esforco = 1;
    }

    public Pessoa() {   }

    public void addTarefa(Tarefa tarefa) {
        if(esforco - tarefa.getEsforco() >= 0) {
            esforco -= tarefa.getEsforco();
            listaTarefas.add(tarefa);
        }
        else System.out.println("Nao pode adicionar esta tarefa a esta pessoa. Esforco atual: " + esforco + " Esforco tarefa: " + tarefa.getEsforco());
    }

    public boolean isTarefaInList(Tarefa tarefa) {
        if(listaTarefas.contains(tarefa)) {
            return true;
        }
        else return false;
    }

    public double getCusto() {
        return this.custo;
    }

    public double getEsforco() {
        return this.esforco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
}

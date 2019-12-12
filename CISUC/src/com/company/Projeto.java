package com.company;

import javax.print.Doc;
import java.util.*;

public class Projeto {

    private String nomeProjeto;
    private String acronimo;
    private double duracao;
    private Calendar inicio;
    private Calendar fim;
    private ArrayList<Bolseiro> listaBolseiros;
    private ArrayList<Tarefa> listaTarefas;
    private Docente investigadorPrincipal;
    private ArrayList<Docente> listaInvestigadores;
    private boolean estaConcluido;

    public Projeto(String nomeProjeto, String acronimo, double duracao, Docente investigadorPrincipal) {
        this.nomeProjeto = nomeProjeto;
        this.acronimo = acronimo;
        this.duracao = duracao;
        this.listaBolseiros = new ArrayList<>();
        this.listaTarefas = new ArrayList<>();
        this.investigadorPrincipal = investigadorPrincipal;
        this.listaInvestigadores = new ArrayList<>();
        this.estaConcluido = false;
    }

    public Projeto() {  }

    public void addTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public boolean getEstaConcluido() {
        return estaConcluido;
    }

    public void delTarefa(Tarefa tarefa) {
        return;
    }

    public void addBolseiro(Bolseiro bolseiro) {
        listaBolseiros.add(bolseiro);
    }

    public void addInvestigador(Docente docente) {
        listaInvestigadores.add(docente);
    }

    public Calendar getFim() {
        return fim;
    }

    public void atribuirTarefa(Pessoa pessoa, Tarefa tarefa) {
        // falta logica
        pessoa.listaTarefas.add(tarefa);
    }

    public void listTarefaNaoConc() {
        return;
    }

    public void listTarefaNaoInit() {
        return;
    }

    public int custoProjeto() {
        return 0;
    }

    public void listTarefasConc() {
        return;
    }

    private void setEstaConcluido() {
        estaConcluido = true;
        return;
    }
}

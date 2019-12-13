package com.company;

import javax.print.Doc;
import java.util.*;

public class Projeto {

    private String nomeProjeto;
    private String acronimo;
    private double duracao;
    private Calendar inicio;
    private Calendar fim;
    private List<Bolseiro> listaBolseiros;
    private List<Tarefa> listaTarefas;
    private Docente investigadorPrincipal;
    private List<Docente> listaInvestigadores;
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

    public Projeto(String nomeProjeto, String acronimo, double duracao) {
        this.nomeProjeto = nomeProjeto;
        this.acronimo = acronimo;
        this.duracao = duracao;
        this.listaBolseiros = new ArrayList<>();
        this.listaTarefas = new ArrayList<>();
        this.listaInvestigadores = new ArrayList<>();
        this.estaConcluido = false;
    }

    public Projeto() {  }

    public void addTarefa(Tarefa tarefa) {
        if(listaTarefas.contains(tarefa)) {
            System.out.println("Esta tarefa ja foi adicionada ao Projeto.");
            return;
        }
        listaTarefas.add(tarefa);
    }

    public boolean getEstaConcluido() {
        return estaConcluido;
    }

    public void delTarefa(Tarefa tarefa) {
        if(listaTarefas.remove(tarefa)) System.out.println("Tarefa removida com sucesso.");
        else System.out.println("Tarefa nao se encontra na lista de tarefas deste projeto.");
    }

    public void addBolseiro(Bolseiro bolseiro) {
        if(listaBolseiros.contains(bolseiro)) {
            System.out.println("Este aluno ja se encontra na lista de bolseiros.");
            return;
        }
        System.out.println("Bolseiro");
        listaBolseiros.add(bolseiro);
    }

    public void addInvestigador(Docente docente) {
        if(listaInvestigadores.contains(docente)) {
            System.out.println("Este docente ja se encontra na lista de investigadores.");
            return;
        }
        listaInvestigadores.add(docente);
    }

    public Calendar getFim() {
        return fim;
    }

    public void atribuirTarefa(Pessoa pessoa, Tarefa tarefa) {
        if(!(listaTarefas.contains(tarefa))){
            System.out.println("Tem de adicionar a tarefa a lista de tarefas do projeto antes de a associar a uma pessoa");
            return;
        }
        if(!(listaInvestigadores.contains(pessoa)) && !(listaBolseiros.contains(pessoa))) {
            System.out.println("Tem de adicionar a pessoa a respetiva lista antes de a associar a uma tarefa");
            return;
        }
        pessoa.addTarefa(tarefa);
        if(pessoa.isTarefaInList(tarefa)) System.out.println("Tarefa adicionada com sucesso.");
        else System.out.println("Nao foi possivel adicionar a tarefa a lista");
    }

    public void listTarefaNaoConc() {
        System.out.println("Tarefas nao concluidas:");
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getPercConclusao() != 100) {
                System.out.println("Tarefa " + tarefa.toString());
            }
        }
    }

    public void listTarefaNaoInit() {
        System.out.println("Tarefas nao iniciadas:");
        for(Tarefa tarefa : listaTarefas) {
            if(tarefa.getPercConclusao() == 0) {
                System.out.println("Tarefa " + tarefa.toString());
            }
        }
    }

    public int custoProjeto() {
        int custo = 0;
        for(Bolseiro bolseiro : listaBolseiros) {
            custo += bolseiro.getCusto()*(duracao/31);
        }
        return custo;
    }

    public void listTarefasConc() {
        System.out.println("Tarefas concluidas:");
        for(Tarefa tarefa : listaTarefas) {
            if(tarefa.getPercConclusao() == 100) {
                System.out.println("Tarefa " + tarefa.toString());
            }
        }
    }

    private void setEstaConcluido() {
        estaConcluido = true;
        return;
    }
}

package com.company;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private File fdPessoas;
    private File fdTarefas;
    private File fdProjetos;
    private List<Projeto> listaProj;
    private List<Tarefa> listaTarefas;
    private List<Pessoa> listaPessoas;

    public GUI(File fdPessoas, File fdTarefas, File fdProjetos, List<Projeto> listaProj, List<Tarefa> listaTarefas, List<Pessoa> listaPessoas){
        this.fdPessoas = fdPessoas;
        this.fdTarefas = fdTarefas;
        this.fdProjetos = fdProjetos;
        this.listaProj = listaProj;
        this.listaTarefas = listaTarefas;
        this.listaPessoas = listaPessoas;
    }

    public void mainFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("CISUC");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Criar projeto");
        JButton button2 = new JButton("Listar projetos nao concluidos");
        JButton button3 = new JButton("Listar projetos concluidos");
        JButton button4 = new JButton("Entrar em projeto");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        button.addActionListener(new buttonCreateProject());
        button2.addActionListener(new buttonListNonConc());
        button3.addActionListener(new buttonListConc());

        frame.add(panel);
        frame.setVisible(true);
    }

    private class buttonCreateProject implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Ficheiro file = new Ficheiro();
            file.criarProjeto(fdProjetos, listaProj);
        }
    }

    private class buttonListNonConc implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Projeto projeto : listaProj) {
                if(!(projeto.getEstaConcluido())) {
                    System.out.println("Projeto " + projeto.getNomeProjeto() + " [" + projeto.getAcronimo() + "] nao foi ainda concluido.");
                }
            }
        }
    }

    private class buttonListConc implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Projeto projeto : listaProj) {
                if(projeto.getEstaConcluido()) {
                    System.out.println("Projeto " + projeto.getNomeProjeto() + " [" + projeto.getAcronimo() + "] ja foi concluido.");
                }
            }
        }
    }

    private class buttonListEnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Enter project
        }
    }
}

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        File fileTarefas = new File("tarefas.txt");
        File fileProjetos = new File("projetos.txt");
        File filePessoas = new File("pessoas.txt");
        File checkFile = new File("checkfile.txt");
        File objFileTarefas = new File("tarefas.obj");
        File objFileProjetos = new File("projetos.obj");
        File objFilePessoas = new File("pessoas.obj");
        List<Tarefa> listaTarefas = new ArrayList<>();
        List<Projeto> listaProjetos = new ArrayList<>();
        List<Pessoa> listaPessoas = new ArrayList<>();
        Ficheiro file = new Ficheiro();
        if(file.checkFile(checkFile) == 0) {
            file.readFileTarefas(fileTarefas, objFileTarefas);
            file.readFileProjetos(fileProjetos, objFileProjetos);
            file.readFilePessoas(filePessoas, objFilePessoas);
            file.firstTime(checkFile);
        }
        file.readObjFileTarefa(objFileTarefas, listaTarefas);
        file.readObjFileProjeto(objFileProjetos, listaProjetos);
        file.readObjFilePessoa(objFilePessoas, listaPessoas);

        GUI gui = new GUI(objFilePessoas, objFileTarefas, objFileProjetos, listaProjetos, listaTarefas, listaPessoas);
        gui.mainFrame();
    }
}

package com.company;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Ficheiro {

    public Ficheiro() {}

    public void readFileTarefas(File file, File objfile) {
        if(file.exists() && file.isFile()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader buffreader = new BufferedReader(reader);

                String line;

                while((line = buffreader.readLine()) != null) {
                    double duracao = 0.0;
                    for(String val : line.split("-")) {
                        if(val.compareTo("Desenvolvimento") == 0) {
                            if(duracao > 0.0) {
                                Desenvolvimento dev = new Desenvolvimento(duracao);
                                storeObjectFileTarefas(objfile, dev);
                            }
                            else {
                                System.out.println("Problem in file format at this line.");
                            }
                        }
                        else if(val.compareTo("Design") == 0) {
                            if(duracao > 0.0) {
                                Design design = new Design(duracao);
                                storeObjectFileTarefas(objfile, design);
                            }
                        }
                        else if(val.compareTo("Documentacao") == 0) {
                            if(duracao > 0.0) {
                                Documentacao doc = new Documentacao(duracao);
                                storeObjectFileTarefas(objfile, doc);
                            }
                        }
                        else {
                            duracao = Double.parseDouble(val);
                        }
                    }
                }

                buffreader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Erro ao abrir ficheiro de texto tarefas.txt");
            }
            catch(IOException ex) {
                System.out.println("Erro ao ler o ficheiro de texto tarefas.txt");
            }
        }
    }

    public void readFilePessoas(File file, File objfile) {
        if(file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while((line = br.readLine()) != null) {
                    String email = "";
                    String nome = "";
                    String area = "";
                    int numero = 0;
                    for(String val : line.split("-")) {
                        if(val.contains("@")) {
                            email = val;
                        }
                        else if(val.compareTo("Licenciado") == 0) {
                            if(nome.isEmpty() || email.isEmpty()) {
                                System.out.println("Nome ou email nao inseridos.");
                            }
                            Licenciado lic = new Licenciado(nome, email);
                            System.out.println("debugger");
                            System.out.println(lic.toString());
                            storeObjectFilePessoas(objfile, lic);
                        }
                        else if(val.compareTo("Mestre") == 0) {
                            if(nome.isEmpty() || email.isEmpty()) {
                                System.out.println("Nome ou email nao inseridos.");
                            }
                            Mestre mestre = new Mestre(nome, email);
                            storeObjectFilePessoas(objfile, mestre);
                        }
                        else if(val.compareTo("Doutorado") == 0) {
                            if(nome.isEmpty() || email.isEmpty()) {
                                System.out.println("Nome ou email nao inseridos.");
                            }
                            Doutorado doutor = new Doutorado(nome, email);
                            storeObjectFilePessoas(objfile, doutor);
                        }
                        else if(val.contains("Area")) {
                            String[] val2 = val.split(" ");
                            int i = 0;
                            for(String num : val2) {
                                if(i == 1) {
                                    area = num;
                                }
                                i++;
                            }
                        }
                        else if(val.contains("Numero")) {
                            String[] val2 = val.split(" ");
                            int i = 0;
                            for(String num : val2) {
                                if(i == 1) {
                                    numero = Integer.parseInt(num);
                                }
                                i++;
                            }
                        }

                        else if(val.compareTo("Docente") == 0) {
                            if(nome.isEmpty() || email.isEmpty() || area.isEmpty() || numero == 0) {
                                System.out.println("Algum dos campos obrigatorios de Docente esta por preencher.");
                            }
                            Docente doc = new Docente(nome, email, numero, area);
                            storeObjectFilePessoas(objfile, doc);

                        }
                        else nome = val;
                    }
                }
                br.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Erro ao abrir ficheiro de texto pessoas.txt");
            }
            catch(IOException ex) {
                System.out.println("Erro ao ler o ficheiro de texto pessoas.txt");
            }
        }
    }

    public void storeObjectFilePessoas(File file, Pessoa pessoa) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(pessoa);
            System.out.println(pessoa.toString());

            oos.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error: Couldn't find object file pessoas.obj");
        }
        catch(IOException ex) {
            System.out.println("Error: Writing to file pessoas.obj");
        }
    }

    public void storeObjectFileTarefas(File file, Tarefa tarefa) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(tarefa);

            oos.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Error: Couldn't find file");
        }
        catch (IOException ex) {
            System.out.println("Error: Writing to file");
        }
    }

    public void storeObjectFileProjeto(File file, Projeto projeto) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(projeto);

            oos.close();
        }

        catch (FileNotFoundException ex) {
            System.out.println("Error: Couldn't find file.");
        }
        catch (IOException ex) {
            System.out.println("Error: Writing to file.");
        }
    }

    public void readFileProjetos(File file, File objfile) {
        if(file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while((line = br.readLine()) != null) {
                    String nomeProj = "";
                    String acronimo = "";
                    double duracao = 0.0;
                    for(String val : line.split("-")) {
                        if(val.contains("nome")) {
                            String[] val2 = val.split(" ");
                            int i = 0;
                            for(String newval : val2) {
                                if(i==1) {
                                    nomeProj = newval;
                                }
                                i++;
                            }
                        }
                        else if(val.contains("acronimo")) {
                            String[] val2 = val.split(" ");
                            int i=0;
                            for(String newval : val2) {
                                if(i==1) {
                                    acronimo = newval;
                                }
                                i++;
                            }
                        }

                        else if(val.contains("duracao")) {
                            String[] val2 = val.split(" ");
                            int i=0;
                            for(String newval : val2) {
                                if(i==1) {
                                    duracao = Double.parseDouble(newval);
                                }
                                i++;
                            }
                        }
                        else if(val.compareTo("Projeto") == 0) {
                            if(nomeProj.isEmpty() || acronimo.isEmpty() || duracao == 0) {
                                System.out.println("Algum dos campos de preenchimentos ficou vazio");
                            }
                            Projeto proj = new Projeto(nomeProj, acronimo, duracao);
                            System.out.println(proj.toString());
                            storeObjectFileProjeto(objfile, proj);
                        }
                        else System.out.println("String splitter didn't find anything for this section.");
                    }
                }
            }

            catch(FileNotFoundException ex) {
                System.out.println("Erro ao abrir ficheiro de texto projetos.txt");
            }
            catch(IOException ex) {
                System.out.println("Erro ao ler ficheiro de texto projetos.txt");
            }
        }
    }

    public void readObjFileProjeto(File file, List<Projeto> lista) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Projeto projeto;
            while((projeto = (Projeto)ois.readObject()) != null) {
                lista.add(projeto);
                System.out.println(projeto.toString());
            }
            ois.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Opening file.");
        }
        catch (IOException ex) {
            System.out.println("Error: Reading file");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error: converting object.");
        }
    }

    public void readObjFilePessoa(File file, List<Pessoa> lista) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pessoa pessoa;

            while((pessoa = (Pessoa)ois.readObject()) != null) {
                lista.add(pessoa);
                System.out.println(pessoa.toString());
            }
            ois.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Opening file.");
        }
        catch (IOException ex) {
            System.out.println("Error: Reading file");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error: converting object.");
        }
    }

    public void readObjFileTarefa(File file, List<Tarefa> lista) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Tarefa tarefa;
            while((tarefa = (Tarefa)ois.readObject()) != null) {
                lista.add(tarefa);
                System.out.println(tarefa.toString());
            }
            ois.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Opening file.");
        }
        catch (IOException ex) {
            System.out.println("Error: Reading file");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error: converting object.");
        }
    }

    public void criarProjeto(File file, List<Projeto> lista) {
        String nomeProj;
        String acronimo;
        double duracao;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza o nome do projeto.");
        nomeProj = sc.next();
        System.out.println("Introduza o acronimo do projeto.");
        acronimo = sc.next();
        acronimo = acronimo.toUpperCase();
        System.out.println("Introduza a duracao do projeto em dias.");
        duracao = sc.nextDouble();

        Projeto proj = new Projeto(nomeProj, acronimo, duracao);
        lista.add(proj);
        storeObjectFileProjeto(file, proj);
    }

    public void firstTime(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("checked");
            bw.close();
        }
        catch (IOException ex) {
            System.out.println("Erro a escrever no ficheiro checked.");
        }
    }

    public int checkFile(File file) {
        if(file.exists() && file.isFile()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();
                if(line != null && line.compareTo("checked") == 0) {
                    return 1;
                }
                else return 0;
            }
            catch (FileNotFoundException ex) {
                System.out.println("file checker not found.");
            }
            catch (IOException ex) {
                System.out.println("Erro a ler");
            }
        }
        return 0;
    }
}

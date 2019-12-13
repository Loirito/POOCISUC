package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Projeto projeto = new Projeto("proj1", "P1", 50);
        Design design = new Design(20);
        Desenvolvimento dev = new Desenvolvimento(50);
        Licenciado licenciado = new Licenciado("lic1", "lic1@gmail.com");
        Licenciado licenciado2 = new Licenciado("lic2", "lic2@gmail.com");
        design.setPercConclusao(80);
        projeto.addTarefa(design);
        projeto.addTarefa(dev);
        projeto.addBolseiro(licenciado);
        projeto.addBolseiro(licenciado2);
        System.out.println(projeto.custoProjeto());
    }
}

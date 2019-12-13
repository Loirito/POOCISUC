package com.company;

import java.util.*;

public abstract class Formando extends Bolseiro {

    protected List<Docente> listaOrientadores;

    public Formando(String nome, String email) {
        super(nome, email);
        this.listaOrientadores = new ArrayList<>();
    }

    public Formando() {     }

    public List<Docente> getListaOrientadores() {
        return listaOrientadores;
    }

    public void addDocente(Docente docente) {
        if(listaOrientadores.contains(docente)) {
            System.out.println("Este docente ja esta associado ao Formando.");
            return;
        }
        listaOrientadores.add(docente);
    }

}

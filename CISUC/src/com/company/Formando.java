package com.company;

import java.util.*;

public abstract class Formando extends Bolseiro {

    protected ArrayList<Docente> listaOrientadores;

    public Formando(String nome, String email) {
        super(nome, email);
        this.listaOrientadores = new ArrayList<>();
    }

    public Formando() {     }

    public ArrayList<Docente> getListaOrientadores() {
        return listaOrientadores;
    }

    public void addDocente(Docente docente) {
        listaOrientadores.add(docente);
    }

}

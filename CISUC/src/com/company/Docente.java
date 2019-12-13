package com.company;

public class Docente extends Pessoa{

    private int numeroDoc;
    private String area;

    public Docente(String nome, String email, int numeroDoc, String area) {
        super(nome, email);
        this.numeroDoc = numeroDoc;
        this.area = area;
        this.custo = 0;
    }

    public Docente() {}

    public int getNumeroDoc() {
        return numeroDoc;
    }

    public String getArea() {
        return area;
    }

}

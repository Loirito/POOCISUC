package com.company;

import java.util.*;

public abstract class Bolseiro extends Pessoa{
    protected Calendar inicioBolsa;
    protected Calendar fimBolsa;
    protected String nomeProjeto;

    public Bolseiro(String nome, String email) {
        super(nome, email);
    }

    public Bolseiro() {     }

    public boolean tenhoProjeto() {
        return true;
    }
}

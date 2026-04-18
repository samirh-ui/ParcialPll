package com.example.modelo;

public class Arma {

    private int dañoAdicional;

    public Arma(int dañoAdicional) {
        this.dañoAdicional = dañoAdicional;
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public int atacarConArma() {
        return dañoAdicional;
    }

    
}
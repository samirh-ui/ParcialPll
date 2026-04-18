package com.example.modelo;

public class Arma {
    private final String nombre;
    private final int dañoBase;
    private final int bonoMagico;

    public Arma(String nombre, int dañoBase, int bonoMagico) {
        this.nombre = nombre;
        this.dañoBase = dañoBase;
        this.bonoMagico = bonoMagico;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDañoBase() {
        return dañoBase;
    }

    public int getBonoMagico() {
        return bonoMagico;
    }

    public int getDañoAdicional() {
        return dañoBase + bonoMagico;
    }

    public void atacarConArma(Criatura atacante, Criatura objetivo) {
        int daño = getDañoAdicional() + atacante.getFuerza() / 2;
        System.out.printf("%s ataca con %s y causa %d puntos de daño.%n", atacante.getNombre(), nombre, daño);
        objetivo.defender(daño);
    }
}
